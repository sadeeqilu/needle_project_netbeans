package com.needle.controller;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import com.needle.fxml.Pages;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;

import javafx.fxml.Initializable;

public class LoginController extends BaseController implements Initializable{


	    @FXML
	    private PasswordField confirmTxt;

	    @FXML
	    private Button signinButon;

	    @FXML
	    private Button cancelButton;

	    @FXML
	    private PasswordField passwordTxt;

	    @FXML
	    void handleCancelButton(ActionEvent event) {

	    }

	    @FXML
	    void handleSignInButton(ActionEvent event) throws IOException {

	    	if(passwordTxt.getText().equalsIgnoreCase("Admin")
	    			&& confirmTxt.getText().equalsIgnoreCase("admin")) {
	    		navigate(event, Pages.MAIN.getPage());
	    	}
	    }

	
	@Override
	public void initialize(URL location, ResourceBundle resources) {
		// TODO Auto-generated method stub
		
	}

}
