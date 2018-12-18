package com.needle.util;

import java.time.LocalDate;

import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.TextField;

public class InputValidation {

	 	Alert alert;
	   
	 	public InputValidation() {
			// TODO Auto-generated constructor stub
		}
	 	
	    public boolean isPresent(TextField t , String title){
	        if(t.getText().length() > 0){
	            return true;
	        }
	        else{
	            alert = new Alert(AlertType.ERROR);
	            alert.setContentText(title+ " field is empty");
	            alert.showAndWait();
	            t.requestFocus();
	            return false;
	        }
	    }
	    
	     public boolean isInteger(TextField t, String title){
	        try{
	            Integer.parseInt(t.getText());
	            return true;
	        }catch(NumberFormatException ex){
	            alert = new Alert(Alert.AlertType.ERROR);
	            alert.setContentText(title +" field is not a number");
	            alert.showAndWait();
	            t.requestFocus();
	            return false;
	        }
	    }
	    
	    public boolean isDouble(TextField t, String title){
	        try{
	            Double.parseDouble(t.getText());
	            return true;
	        }catch(NumberFormatException ex){
	            alert = new Alert(Alert.AlertType.ERROR);
	            alert.setContentText(title +" field is not a number");
	            alert.showAndWait();
	            t.requestFocus();
	            return false;
	        }
	    }
	    
	    public boolean isDouble(TextField t, String title, double upperBound, double lowerBound){
	        try{
	            Double.parseDouble(t.getText());
	            
	            return true;
	        }catch(NumberFormatException ex){
	            alert = new Alert(Alert.AlertType.ERROR);
	            alert.setContentText(title +" field is not a number");
	            alert.showAndWait();
	            t.requestFocus();
	            return false;
	        }
	    }
	    
	    public boolean verifyDate(LocalDate later, LocalDate earliar) {
	    	if(later.isAfter(earliar))
	    		return true;
	    	else {
	    		alert = new Alert(Alert.AlertType.ERROR);
	            alert.setContentText(" Date is incorrect");
	            alert.showAndWait();
	    		return false;
	    	}
	    }
}
