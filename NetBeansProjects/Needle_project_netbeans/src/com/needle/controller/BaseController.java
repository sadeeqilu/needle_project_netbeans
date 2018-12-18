package com.needle.controller;

import java.io.IOException;
import java.net.URL;
import javafx.event.Event;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

/**
 *
 * @author Sadiq Ilu
 * @version 1.1
 * @since javafx 2.0 jdk 1.8
 */
public class BaseController {
    
    private double xAxis;
    private double yAxis;
    
    public void navigate(Event event , URL page) throws IOException{

    	Parent node = FXMLLoader.load(page);


    	Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();

    	
    	Scene scene = new Scene(node);
    	node.setOnMousePressed(e ->{
    		xAxis = e.getSceneX();
    		yAxis = e.getSceneY();
    	});

    	node.setOnMouseDragged(e ->{
    		stage.setX(e.getScreenX() - xAxis);
    		stage.setY(e.getScreenY() - yAxis);
    	});
    	stage.setScene(scene);
    	stage.centerOnScreen();
    	stage.show();

    }
}
