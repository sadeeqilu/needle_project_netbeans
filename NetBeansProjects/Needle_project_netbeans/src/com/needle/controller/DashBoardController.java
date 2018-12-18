package com.needle.controller;

import java.net.URL;
import java.util.ResourceBundle;

import com.needle.business.Guest;
import com.needle.business.Room;
import com.needle.database.GuestDB;
import com.needle.database.RoomDB;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.chart.BarChart;
import javafx.scene.chart.CategoryAxis;
import javafx.scene.chart.NumberAxis;
import javafx.scene.chart.PieChart;
import javafx.scene.chart.XYChart;
import javafx.scene.layout.VBox;

public class DashBoardController implements Initializable{

    @FXML
    private VBox dashboard;

    @FXML
    private BarChart<?, ?> barchart;

    @FXML
    private CategoryAxis typeBar;

    @FXML
    private NumberAxis priceBar;

    @FXML
    private PieChart pie;

    RoomDB rdb = new RoomDB();
    ObservableList<Room> rooms = FXCollections.observableArrayList();
    
    GuestDB gdb = new GuestDB();
    ObservableList<Guest> guests = FXCollections.observableArrayList();
    
	@Override
	public void initialize(URL location, ResourceBundle resources) {
		rooms = rdb.getMenu();
		 XYChart.Series xy = new XYChart.Series<>();
		 
		 for (int i = 0; i < rooms.size(); i++) {
			 String type = rooms.get(i).getType();
			 double price = rooms.get(i).getPrice();
			xy.getData().add(new XYChart.Data<>(type,price));
		}
	        /*xy.getData().add(new XYChart.Data<>("Ahmad", 2000));
	        xy.getData().add(new XYChart.Data<>("Sani", 10000));
	        xy.getData().add(new XYChart.Data<>("Deejah", 5000));
	        xy.getData().add(new XYChart.Data<>("Sadiq", 3000));
	        xy.getData().add(new XYChart.Data<>("Tanko", 14000));*/
	        
	        barchart.getData().addAll(xy);
	        
	        
	        guests = gdb.getAll();
	        int male = 0;
	        int female = 0;
	        for(int i = 0; i < guests.size(); i++) {
	        	if(guests.get(i).getGender().equalsIgnoreCase("male"))
	        		male++;
	        	else
	        		female++;
	        }
	        ObservableList<PieChart.Data> pieData = FXCollections.observableArrayList(
	                new PieChart.Data("Male", male),
	                new PieChart.Data("Female", female)
	        );
	        
	        
	        
	        
	        pie.setData(pieData);
		
	}

}
