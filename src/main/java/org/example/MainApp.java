package org.example;

import org.example.view.MenuView;

import javafx.application.Application;
import javafx.stage.Stage;

public class MainApp extends Application {

    @Override
    public void start(Stage primaryStage){
        try{
            MenuView menuView = new MenuView(primaryStage);
            menuView.exibir();
        } catch (Exception e){
            e.printStackTrace();
        }
    }

    public static void main(String[] args){
        launch(args);
    }
}
