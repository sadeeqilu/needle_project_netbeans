package com.needle.controller;

import java.net.URL;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ResourceBundle;
import java.util.function.Predicate;
import com.needle.business.Guest;
import com.needle.database.GuestDB;

import javafx.beans.property.ReadOnlyStringWrapper;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.collections.transformation.FilteredList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.VBox;

public class GuestPageController implements Initializable{

    @FXML
    private VBox dashboard;

    @FXML
    private TextField searchGuestText;

    @FXML
    private TableView<Guest> guestsTable;

    @FXML
    private TableColumn<Guest, String> phoneNumberCol;

    @FXML
    private TableColumn<Guest, String> fnameCol;

    @FXML
    private TableColumn<Guest, String> lnameCol;

    @FXML
    private TableColumn<Guest, String> genderCol;

    @FXML
    private TableColumn<Guest, LocalDate> dobCol;

    @FXML
    void handleDelGuestBtn(ActionEvent event) {

    }

    @FXML
    void handleNewGuestBtn(ActionEvent event) {

    }

    @FXML
    void handleUpdateGuestBtn(ActionEvent event) {

    }

    GuestDB gdb = new GuestDB();
    ObservableList<Guest> guests = FXCollections.observableArrayList();
	@Override
	public void initialize(URL location, ResourceBundle resources) {
		phoneNumberCol.setCellValueFactory(new PropertyValueFactory<>("phonenumber"));
		fnameCol.setCellValueFactory(new PropertyValueFactory<>("firstName"));
		lnameCol.setCellValueFactory(new PropertyValueFactory<>("lastName"));
		genderCol.setCellValueFactory(new PropertyValueFactory<>("gender"));
		dobCol.setCellValueFactory(new PropertyValueFactory<>("dob"));
		
		guests = (ObservableList<Guest>) gdb.getAll();
		guestsTable.setItems(guests);
		FilteredList<Guest> filteredguests = new FilteredList<>(guests, i -> true);
		
		searchGuestText.setOnKeyReleased(e -> {
			filteredguests.setPredicate(new Predicate<Guest>() {
				@Override
				public boolean test(Guest t) {
					if(phoneNumberCol.getText() == null || phoneNumberCol.getText().isEmpty() || 
							fnameCol.getText() == null || fnameCol.getText().isEmpty() ||
							 lnameCol.getText() == null || lnameCol.getText().isEmpty() ||
							 genderCol.getText() == null || genderCol.getText().isEmpty())
						return true;
					return t.getPhonenumber().contains(searchGuestText.getText()) ||
							t.getFirstName().toLowerCase().contains(searchGuestText.getText().toLowerCase()) ||
							t.getLastName().contains(searchGuestText.getText()) ||
							t.getGender().toLowerCase().contains(searchGuestText.getText().toLowerCase());
				}
			});
		});
		
		guestsTable.setItems(filteredguests);	
		
	}

}
