package com.needle.controller;

import java.net.URL;
import java.time.LocalDate;
import java.util.ResourceBundle;
import com.needle.business.Guest;
import com.needle.business.Room;
import com.needle.business.Visit;
import com.needle.database.GuestDB;
import com.needle.database.RoomDB;
import com.needle.database.VisitDB;
import com.needle.fxml.Pages;
import com.needle.util.DiscountCalculator;
import com.needle.util.InputValidation;
import com.needle.util.Utility;

import javafx.application.Platform;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.input.KeyCodeCombination;
import javafx.scene.input.KeyCombination;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.VBox;
import com.jfoenix.controls.JFXDatePicker;

import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import javafx.fxml.Initializable;


/**
 * 
 * @author Sadiq Ilu
 * @version 1.1
 * @since javafx 2.0 jdk 1.8
 *
 */

public class UserPageController implements Initializable{
	
	 	@FXML
	    private BorderPane userRootPane;

	    @FXML
	    private VBox MenuPane;

	    @FXML
	    private VBox MenuBox;

	    @FXML
	    private ComboBox<String> roomTypeCombo;
	    

	    @FXML
	    private ComboBox<Integer> nightsCombo;

	    @FXML
	    private Text priceperNightText;

	    @FXML
	    private JFXDatePicker checkInDatePicker;

	    @FXML
	    private JFXDatePicker checkoutDatePicker;

	    @FXML
	    private Button roomNextBtn;

	    @FXML
	    private VBox personalDetailsBox;

	    @FXML
	    private TextField phoneText;

	    @FXML
	    private Button verifyBtn;

	    @FXML
	    private GridPane gridBox;

	    @FXML
	    private TextField fnameText;

	    @FXML
	    private TextField lnameText;

	    @FXML
	    private RadioButton maleRadio;

	    @FXML
	    private RadioButton femaleRadio;

	    @FXML
	    private JFXDatePicker dobPicker;

	    @FXML
	    private HBox nextcancelbox;

	    @FXML
	    private Button personalDetailnextBtn;

	    @FXML
	    private Button cancelBtn;

	    @FXML
	    private VBox ReceiptBox;

	    @FXML
	    private Text payText;

	    @FXML
	    private Text discountText;

	    @FXML
	    private Text totalAmountText;

	    @FXML
	    private Button printBtn;

	    @FXML
	    private Button printCancelBtn;


	    KeyCombination ctrlo = KeyCodeCombination.keyCombination("ctrl + o");
	    
	    @FXML
	    void handleAdmin(KeyEvent event) {

	    	userRootPane.setOnKeyPressed(e -> {
	    		if(ctrlo.match(e)) {
	    			try {
	    				Parent root = FXMLLoader.load(Pages.LOGIN.getPage());
	    				Scene scene = new Scene(root);

	    				Stage primaryStage = new Stage();
	    				primaryStage.initStyle(StageStyle.UNDECORATED);
	    				primaryStage.setScene(scene);
	    				
	    				primaryStage.show();
	    			}catch(Exception ex) {
	    				System.out.print("Error "+ex.getMessage());
	    			}
	    		}
	    	});
	    }
	    
	    @FXML
	    void handleExitBtn(ActionEvent event) {
	    	Platform.exit();
	    }

	    @FXML
	    void handleCancelBtn(ActionEvent event) {

	    	clearRoomMenuFields();
	    	clearPersonDetailsFields();
	    	setVisibility(false);
	    }

	    // handles what happens with the data and concerned data in the personal details part
	    @FXML
	    void handlePersonalDetailNextBtn(ActionEvent event) {

	    	double totalPrice;
	    	double payable = 0;
	    	double discount;
	    	guest.setPhonenumber(phoneText.getText());
	    	guest.setFirstName(fnameText.getText());
    		guest.setLastName(lnameText.getText());
    		if(maleRadio.isSelected())
    			guest.setGender("Male");
    		else
    			guest.setGender("Female");
    		guest.setDob(dobPicker.getValue());
    		
    		visit.setRoom(room);
    		ReceiptBox.setVisible(true);
			totalPrice = visit.getTotal(nights);
			totalAmountText.setText(Utility.priceFormatter(totalPrice));
			
			// adds further discount for customers that are coming back to stay at the hotel again
    		if(visitCount > 0) {		
    			payable = totalPrice - (totalPrice*DiscountCalculator
    					.CalculateDiscount(guest.getDob()
    							.getYear(), guest.getGender())) - this.additionalDiscount;
    			
    		}
    		// for guests that are coming for the first tym
    		else{
    			payable = totalPrice - (totalPrice*DiscountCalculator
    					.CalculateDiscount(guest.getDob()
    							.getYear(), guest.getGender()));
    		}
    		
    		discount = totalPrice - payable;
			discountText.setText(Utility.priceFormatter(discount));
			payText.setText(Utility.priceFormatter(payable));
	    }

	    // commits the changes to the database
	    public void commit() {
	    	if(visitCount < 1)
	    		gdb.add(guest);
	    	room.setRoomNumber(rdb.assignRoom(room, visit));
	    	room.setStatus("occupied");
	    	rdb.update(room);
	    	visit.setGuest(guest);
	    	vdb.add(visit);
	    }
	    
	    // sets the visibility status of the listed panes 
	    // in order to enhance usability of the system
	    public void setVisibility(boolean visible) {
	    	gridBox.setVisible(visible);
	    	nextcancelbox.setVisible(visible);
	    	personalDetailsBox.setVisible(visible);	    	
	    	ReceiptBox.setVisible(visible);
	    }
	    
	    // clear fields in the room selection part
	    public void clearRoomMenuFields() {
	    	roomTypeCombo.setItems(null);
	    	priceperNightText.setText("");
	    	checkInDatePicker.setValue(null);
	    	nightsCombo.setItems(null);
	    	checkoutDatePicker.setValue(null);
	    }
	    
	    // clears fields in the personal details part
	    public void clearPersonDetailsFields() {
	    	phoneText.setText("");
	    	gridBox.setVisible(false);
	    	nextcancelbox.setVisible(false);
	    	fnameText.setText("");
	    	lnameText.setText("");
	    	maleRadio.setSelected(true);
	    	dobPicker.setValue(null);
	    }
	    
	    // Sets of lines to be executed when init() is called
	    public void init() {
	    	
	    	// sets a toggle group for male and female radio button
	    	ToggleGroup genderToggle = new ToggleGroup();
			maleRadio.setToggleGroup(genderToggle);
			femaleRadio.setToggleGroup(genderToggle);
			genderToggle.selectToggle(maleRadio);
			
			roomNextBtn.setDisable(true);
			// gets all types of room from the database
			rooms = (ObservableList<Room>) rdb.getMenu();
			
			// creates an empty list of string data-type  
			ObservableList<String> roomTypes = FXCollections.observableArrayList();
			ObservableList<Integer> numberOfDays = FXCollections.observableArrayList();
			
			// assigns values to the observable list created using the rooms in the database
			for (int i = 0; i < rooms.size(); i++) {
				roomTypes.add(rooms.get(i).getType());
			}
			
			// assigns numbers from 1 - 30 to the combo box of selecting nights to be spent in the hotel
			for (int i = 1; i <= 30; i++) {
				numberOfDays.add(i);
			}
			
			// sets the items to their respective combo boxes
			roomTypeCombo.setItems(roomTypes);
			nightsCombo.setItems(numberOfDays);
				
	    }
	    
	    // handles what happens after pressing print button
	    @FXML
	    void handlePrintBtn(ActionEvent event) {

	    	// saves changes to database
	    	commit();
	    	
	    	// restarts everything
	    	init(); 
	    	
	    	// set the system to where it begins
	    	setVisibility(false);
	    	
	    }

	    @FXML
	    void handlePrintCancelBtn(ActionEvent event) {

	    	clearRoomMenuFields();
	    	clearPersonDetailsFields();
	    	setVisibility(false);
	    	init();
	    }

	    @FXML
	    void handleNightsCombo(ActionEvent event) {
	    	LocalDate check_in_date = checkInDatePicker.getValue();

	    	visit.setCheckIn(check_in_date);
	    	
	    	try {
	    		nights = nightsCombo.getSelectionModel().getSelectedItem();	    	
	    		checkoutDatePicker.setValue(check_in_date.plusDays(nights));
	    	}catch(NullPointerException n) {
	    		
	    	}

	    }
	    
	    @FXML
	    void handleRoomNextBtn(ActionEvent event) {

	    	
	    	LocalDate check_out_date = checkoutDatePicker.getValue();
	    	
	    	visit.setCheckOut(check_out_date);
	    	personalDetailsBox.setVisible(true);
	    	

	    }
	    
	    public boolean isValidPersonalDetails() {
	    	return validation.isPresent(phoneText, "Phone number")
	    			&& validation.isPresent(fnameText, "First name")
	    			&& validation.isPresent(lnameText, "Last name")
	    			&& validation.verifyDate(LocalDate.now(), dobPicker.getValue());
	    }

	    // This triggers the next lines to be executed after a room type is selected
	    // from the combo box for types of rooms available.
	    @FXML
	    void handleRoomTypeCombo(ActionEvent event) {

	    	// this gets the type of room after selecting from the dropdown list
	    	String roomType = roomTypeCombo.getSelectionModel().getSelectedItem();
	    	
	    	// this calls a method from the room table in database which returns
	    	// a vacant room with the specified type of room.
	    	room = rdb.get(roomType);
	    	
	    	priceperNightText.setText(Utility.priceFormatter(room.getPrice()));
	    	priceperNightText.setVisible(true);
	    	nightsCombo.setDisable(false);
	    	nightsCombo.getSelectionModel().selectFirst();
	    	checkInDatePicker.setValue(LocalDate.now());
	    	roomNextBtn.setDisable(false);
	    }

	    // setGuest gets the information about the guest entered in the fields 
	    // and assigns them to the global varible guest.
	   public void setGuest() {
		   if(isValidPersonalDetails()) {
			   guest = gdb.get(phoneText.getText());
			   fnameText.setText(guest.getFirstName());
			   lnameText.setText(guest.getLastName());
			   if(guest.getGender().equalsIgnoreCase("male"))
				   maleRadio.setSelected(true);
			   else
				   femaleRadio.setSelected(true);
			   dobPicker.setValue(guest.getDob());
		   }
	   }
		   

	   /**
	    * this method handles the next steps to be executed when the <button>verify</button
	    * is pressed.
	    * @param event
	    */
	    @FXML
	    void handleVerifyBtn(ActionEvent event) {
	    	if(validation.isPresent(phoneText, "Phone number")) {
	    		visitCount = vdb.getVisitCount(phoneText.getText());
	    		gridBox.setVisible(true);
	    		nextcancelbox.setVisible(true);
	    		if(visitCount > 0) {
	    			additionalDiscount = DiscountCalculator.CalculateDiscount(visitCount);
	    			this.setGuest();
	    		}
	    	}
	    }
	    
	    
	    // Global variables so that they can be accessible from any method within this class
	    Visit visit = new Visit();
	    ObservableList<Room> rooms = FXCollections.observableArrayList();
	    Room room = new Room();
	    RoomDB rdb = new RoomDB();
	    private int nights = 0;
	    VisitDB vdb = new VisitDB();
	    Guest guest = new Guest();
	    GuestDB gdb = new GuestDB();
	    double additionalDiscount = 0.0;
	    private int visitCount;
	    InputValidation validation = new InputValidation();

	    
	    
	/**
	 * This is where the whole program starts its execution
	 * 
	 */
	@Override
	public void initialize(URL location, ResourceBundle resources) {
		init();
	}
}