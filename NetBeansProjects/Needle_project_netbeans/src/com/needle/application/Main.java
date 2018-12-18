package com.needle.application;
	
import com.needle.fxml.Pages;


import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import javafx.scene.Parent;
import javafx.scene.Scene;



public class Main extends Application {
    double xAxis;
    double yAxis;
	@Override
	public void start(Stage primaryStage) {

		try {
			Parent node = FXMLLoader.load(Pages.USERPAGE.getPage());

	    	primaryStage.initStyle(StageStyle.UNDECORATED);
	    	Scene scene = new Scene(node);
	    	node.setOnMousePressed(e ->{
	    		xAxis = e.getSceneX();
	    		yAxis = e.getSceneY();
	    	});

	    	node.setOnMouseDragged(e ->{
	    		primaryStage.setX(e.getScreenX() - xAxis);
	    		primaryStage.setY(e.getScreenY() - yAxis);
	    	});
	    	primaryStage.setScene(scene);
	    	primaryStage.centerOnScreen();
	    	primaryStage.show();

		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public static void main(String[] args) {
		launch(args);
	}
}
