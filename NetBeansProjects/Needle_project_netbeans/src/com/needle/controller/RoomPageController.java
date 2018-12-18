package com.needle.controller;

import java.net.URL;
import java.util.ResourceBundle;
import java.util.function.Predicate;

import com.needle.business.Room;
import com.needle.database.RoomDB;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.collections.transformation.FilteredList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.VBox;

public class RoomPageController implements Initializable{

    @FXML
    private VBox dashboard;

    @FXML
    private Button newRoomBtn;

    @FXML
    private TextField searchRoomText;

    @FXML
    private TableView<Room> roomsTable;

    @FXML
    private TableColumn<Room, Integer> roomNumberCol;

    @FXML
    private TableColumn<Room, String> roomTypeCol;

    @FXML
    private TableColumn<Room, Double> priceCol;

    @FXML
    private TableColumn<Room, String> statusCol;

    @FXML
    private Button updateRoomBtn;

    @FXML
    private Button delRoomBtn;

    @FXML
    void handleDelRoomBtn(ActionEvent event) {

    }

    @FXML
    void handleNewRoomBtn(ActionEvent event) {

    }

    @FXML
    void handleUpdateRoomBtn(ActionEvent event) {

    }
    
    RoomDB rdb = new RoomDB();
    ObservableList<Room> rooms = FXCollections.observableArrayList();

	@Override
	public void initialize(URL location, ResourceBundle resources) {
		roomNumberCol.setCellValueFactory(new PropertyValueFactory<>("roomNumber"));
		roomTypeCol.setCellValueFactory(new PropertyValueFactory<>("type"));
		priceCol.setCellValueFactory(new PropertyValueFactory<>("price"));
		statusCol.setCellValueFactory(new PropertyValueFactory<>("status"));
		
		rooms = rdb.getAll();
		roomsTable.setItems(rooms);
		FilteredList<Room> filteredRoom = new FilteredList<>(rooms, i -> true);
		
		searchRoomText.setOnKeyReleased(e -> {
			filteredRoom.setPredicate(new Predicate<Room>() {
				@Override
				public boolean test(Room t) {
					if(roomNumberCol.getText() == null || roomNumberCol.getText().isEmpty() || 
							roomTypeCol.getText() == null || roomTypeCol.getText().isEmpty() ||
							 priceCol.getText() == null || priceCol.getText().isEmpty() ||
							 statusCol.getText() == null || statusCol.getText().isEmpty())
						return true;
					return Integer.toString(t.getRoomNumber()).contains(searchRoomText.getText()) ||
							t.getType().toLowerCase().contains(searchRoomText.getText().toLowerCase()) ||
							Double.toString(t.getPrice()).contains(searchRoomText.getText()) ||
							t.getStatus().toLowerCase().contains(searchRoomText.getText().toLowerCase());
				}
			});
		});
		
		roomsTable.setItems(filteredRoom);		
	}

}
