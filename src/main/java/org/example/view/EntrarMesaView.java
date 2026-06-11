package org.example.view;

import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

public class EntrarMesaView {

    private Stage stage;

    public EntrarMesaView(Stage stage){
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
