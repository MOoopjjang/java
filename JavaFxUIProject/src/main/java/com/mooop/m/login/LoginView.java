package com.mooop.m.login;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXTextField;

import io.reactivex.Flowable;
import io.reactivex.schedulers.Schedulers;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

public class LoginView {
	
	AnchorPane loginRoot = null;
	JFXTextField email;
	JFXTextField pwd;
	JFXButton btnSignIn;
	
	Stage stage;
	
	
	String templateLayout;
	
	
	AuthenticationManager am = new AuthenticationManager();
	
	
	
	public LoginView(String _template , Stage stage) {
		this.templateLayout = _template;
		this.stage = stage;
		
		try {
			setLayout();
			setListener();
		}catch(Exception e) {
			e.printStackTrace();
		}
		
	}
	
	
	public void setLayout() throws Exception{
		loginRoot = FXMLLoader.load(getClass().getResource(this.templateLayout));
		
		email = (JFXTextField) loginRoot.lookup("#email");
		pwd = (JFXTextField) loginRoot.lookup("#pwd");
		btnSignIn = (JFXButton)loginRoot.lookup("#signin");
		
		Scene scene = new Scene(loginRoot);
		stage.setScene(scene);
		stage.show();
		
	}
	
	public void setListener() {
		
		btnSignIn.setOnAction(e->{
			Flowable.just(new UserInfo(email.getText().toString(), pwd.getText().toString()))
			.subscribeOn(Schedulers.io())
			.subscribe(am);
		});
	}

}
