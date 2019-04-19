package it.polito.tdp.anagrammi.controller;
	

import it.polito.tdp.lab05.model.*;
import javafx.application.Application;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;
import javafx.fxml.FXMLLoader;


public class Main extends Application {
	@Override
	public void start(Stage primaryStage) {
		try {
			FXMLLoader loader = new FXMLLoader(getClass().getResource("Anagrammi.fxml")) ;
			BorderPane root = (BorderPane)loader.load();
		
			Scene scene = new Scene(root);
			primaryStage.setScene(scene);
			primaryStage.show();
			
			AnagrammiController controller = loader.getController();
			
			controller.setModel((new Model()));
			
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public static void main(String[] args) {
		launch(args);
	}
}
