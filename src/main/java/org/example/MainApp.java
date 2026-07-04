package org.example;

import org.example.view.LoginView;

import javafx.application.Application;
import javafx.stage.Stage;

public class MainApp extends Application {

    @Override
    public void start(Stage primaryStage){
        try{
            LoginView loginView = new LoginView(primaryStage);
            loginView.exibir();
        } catch (Exception e){
            e.printStackTrace();
        }
    }

    public static void main(String[] args){
        launch(args);
    }
}
