package org.example.view;

import javafx.stage.Modality;
import org.example.controller.CriarMesaController;
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
            FXMLLoader fxmlloader = new FXMLLoader(getClass().getResource("/org/example/view/criarMesa.fxml"));
            Parent rootCriarMesa = fxmlloader.load();

            CriarMesaController controller = fxmlloader.getController();

            Scene scene = new Scene(rootCriarMesa);
            this.stage.setScene(scene);
            this.stage.setResizable(false);
            this.stage.initModality(Modality.APPLICATION_MODAL);
            this.stage.setTitle("Criar Mesa");
            this.stage.show();

        } catch (Exception e){
            e.printStackTrace();
            Alert alerta = new Alert(Alert.AlertType.ERROR);
            alerta.setHeaderText("Erro");
            alerta.showAndWait();
        }
    }
}
