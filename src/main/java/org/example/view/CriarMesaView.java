package org.example.view;

import org.example.controller.MesaController;

import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.stage.Stage;

public class CriarMesaView {

    private Stage stage;

    public CriarMesaView(Stage stage){
        this.stage = stage;
    }

    public void exibir(){
        try{
            FXMLLoader fxmlloader = new FXMLLoader(getClass().getResource("/org/example/view/Mesaview.fxml"));
            Parent rootMesa = fxmlloader.load();

            MesaController controller = fxmlloader.getController();
            controller.setTelaMesa(this);

            Scene scene = new Scene(rootMesa);
            this.stage.setScene(scene);
            this.stage.setTitle("Mesa");
            this.stage.show();

        } catch (Exception e){
            Alert alerta = new Alert(Alert.AlertType.ERROR);
            alerta.setHeaderText("Erro");
            alerta.showAndWait();
        }
    }
}
