package org.example.view;

import org.example.controller.MesaController;
import org.example.model.Mesa;

import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.stage.Stage;

public class EntrarMesaView {

    private Stage stage;
    private Mesa mesa;

    public EntrarMesaView(Stage stage, Mesa mesa){
        this.stage = stage;
        this.mesa = mesa;
    }

    public void exibir(){
        try{
            FXMLLoader fxmlloader = new FXMLLoader(getClass().getResource("/org/example/view/Mesaview.fxml"));
            Parent rootMesa = fxmlloader.load();

            MesaController controller = fxmlloader.getController();
            controller.setTelaEntrarMesa(this);
            controller.setMesa(mesa);

            Scene scene = new Scene(rootMesa);
            this.stage.setScene(scene);
            this.stage.setTitle(mesa != null ? "Mesa - " + mesa.getNome() : "Mesa");
            this.stage.show();

        } catch (Exception e){
            Alert alerta = new Alert(Alert.AlertType.ERROR);
            alerta.setHeaderText("Erro");
            alerta.showAndWait();
        }
    }
}
