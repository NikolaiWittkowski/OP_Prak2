package main;

import MVC.CafeControl;
import MVC.CafeView;
import business.Cafe;
import business.CafeModel;
import javafx.application.Application;
import javafx.stage.Stage;

public class Main extends Application {
	
	@Override
	public void start(Stage primaryStage) {
		new CafeControl(primaryStage);
	}	
	
	public static void main(String[] args){
		launch(args);
	}
}
