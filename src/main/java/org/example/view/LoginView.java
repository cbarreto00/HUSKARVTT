package org.example.view;

import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.scene.Parent;

import org.example.controller.LoginController;

public class LoginView
{
    private Stage stage;
    
    public LoginView(Stage stage) {
         this.stage = stage;
    }
        
    public void exibir(){
        try{
            FXMLLoader fxmlloader = new FXMLLoader(getClass().getResource("/org/example/view/login.fxml"));
            Parent root = fxmlloader.load();

            LoginController controller = fxmlloader.getController();
            controller.setLoginTela(this);

            Scene scene = new Scene(root);
            this.stage.setScene(scene);
            this.stage.setTitle("Login");
            this.stage.show();

        } catch (Throwable t) {
            System.out.println("\n[ERRO ENCONTRADO NO FXML]");
            t.printStackTrace();
        }
    }
    
    public void stop() {
        this.stage.close();
    }
    
}