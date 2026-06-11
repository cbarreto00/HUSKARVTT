package org.example.view;

import org.example.controller.MenuController;

import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.stage.Stage;

public class MenuView {

    private Stage stage;

    public MenuView(Stage stage){
        this.stage = stage;
    }

    public void exibir(){
        try{
            FXMLLoader fxmlloader = new FXMLLoader(getClass().getResource("/org/example/view/menu.fxml"));
            Parent root = fxmlloader.load();

            MenuController controller = fxmlloader.getController();
            controller.setTelaMenu(this);

            Scene scene = new Scene(root);
            this.stage.setScene(scene);
            this.stage.setTitle("Menu");
            this.stage.show();

        } catch (Throwable t) {
            System.out.println("\n[ERRO ENCONTRADO NO FXML]");
            t.printStackTrace();
        }
    }

    public void fechar(){
        try{
            this.stage.close();
        } catch (Exception e){
            e.printStackTrace();
            Alert alerta = new Alert(Alert.AlertType.ERROR);
            alerta.setHeaderText("Erro");
            alerta.setContentText("Falha ao abrir a tela: " + e.getMessage());
            alerta.showAndWait();
        }
    }
}
