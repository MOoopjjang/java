package com.mooop.m.login;

import com.jfoenix.controls.JFXTextField;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

public class LoginMain extends Application{
	
	public static void main(String[] args) {
		Application.launch(args);
	}
	
	
	private void setListener(AnchorPane root) {
		
		JFXTextField email = (JFXTextField) root.lookup("#email");
	}

	@Override
	public void start(Stage primaryStage) throws Exception {
		
		try {
			
			new LoginView("/template/Login.fxml" , primaryStage);
			
//			AnchorPane root = FXMLLoader.load(getClass().getResource("/template/Login.fxml"));
//			
//			Scene scene = new Scene(root);
//			primaryStage.setScene(scene);
//			primaryStage.show();
		}catch(Exception e) {
			e.printStackTrace();
		}
		
	}

}
