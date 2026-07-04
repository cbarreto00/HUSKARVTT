package org.example.view;

import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.scene.Parent;

import org.example.controller.CadastroController;

public class CadastroView
{
    private Stage stage;
    
    public CadastroView(Stage stage) {
         this.stage = stage;
    }
        
    public void exibir(){
        try{
            FXMLLoader fxmlloader = new FXMLLoader(getClass().getResource("/org/example/view/cadastro.fxml"));
            Parent root = fxmlloader.load();

            CadastroController controller = fxmlloader.getController();
            controller.setTelaCadastro(this);

            Scene scene = new Scene(root);
            this.stage.setScene(scene);
            this.stage.setTitle("Cadastro");
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