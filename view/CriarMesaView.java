package org.example.view;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

public class CriarMesaView {

    private Stage stage;

    public CriarMesaView(Stage stage){
        this.stage = stage;
    }

    public void exibir(){
        try{
            AnchorPane rootVazio = new AnchorPane();

            Scene scene = new Scene(rootVazio);

            Stage stage = new Stage();
            stage.setScene(scene);
            stage.show();
        } catch (Exception e){
            Alert alerta = new Alert(Alert.AlertType.ERROR);
            alerta.setHeaderText("Erro");
            alerta.showAndWait();
        }
    }
}
