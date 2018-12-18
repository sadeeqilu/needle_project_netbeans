package com.needle.controller;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import com.needle.fxml.Pages;

import javafx.application.Platform;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.control.Button;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.BorderPane;

public class MainPageController implements Initializable{

    @FXML
    private Button dashboardBtn;

    @FXML
    private Button guestsBtn;

    @FXML
    private Button roomsPageBtn;

    @FXML
    private Button hsitoryBtn;

    @FXML
    private Button logoutBtn;

    @FXML
    private BorderPane dashboardPane;

    @FXML
    void handleDashboardBtn(MouseEvent event) throws IOException {

    	this.loadUI(Pages.DASHBOARD.getPage());
    }

    @FXML
    void handleGuestBtn(MouseEvent event) throws IOException {

    	this.loadUI(Pages.GUEST.getPage());
    }

    @FXML
    void handleHistoryBtn(MouseEvent event) throws IOException {

    	this.loadUI(Pages.HISTORY.getPage());
    }

    @FXML
    void handleLogoutBtn(MouseEvent event) {
    	Platform.exit();
    }

    @FXML
    void handleRoomBtn(MouseEvent event) throws IOException {

    	this.loadUI(Pages.ROOM.getPage());
    }
    
    private void loadUI(URL page) throws IOException{
        Parent root = null;
        root = FXMLLoader.load(page);
        dashboardPane.setCenter(root);
    }


	@Override
	public void initialize(URL location, ResourceBundle resources) {
		try {
			this.loadUI(Pages.DASHBOARD.getPage());
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
