package com.needle.controller;

import java.net.URL;
import java.time.LocalDate;
import java.util.ResourceBundle;
import java.util.function.Predicate;

import com.needle.business.Room;
import com.needle.business.Visit;

import javafx.collections.transformation.FilteredList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.VBox;

public class HistoryPageController implements Initializable{

    @FXML
    private VBox dashboard;

    @FXML
    private TextField searchHistoryText;

    @FXML
    private TableView<Visit> HistoryTable;

    @FXML
    private TableColumn<Visit, String> guestCol;

    @FXML
    private TableColumn<Visit, Integer> roomNumberCol;

    @FXML
    private TableColumn<Visit, String> roomTypeCol;

    @FXML
    private TableColumn<Visit, LocalDate> checkInCol;

    @FXML
    private TableColumn<Visit, LocalDate> checkOutCol;

    @FXML
    private TableColumn<Visit, String> priceCol;

	@Override
	public void initialize(URL location, ResourceBundle resources) {
		guestCol.setCellValueFactory(new PropertyValueFactory<>("guest.fname+guest.lname"));
		
		roomNumberCol.setCellValueFactory(new PropertyValueFactory<>("room.roomNumber"));
		roomTypeCol.setCellValueFactory(new PropertyValueFactory<>("room.type"));
		priceCol.setCellValueFactory(new PropertyValueFactory<>("price"));
	
	}

}
