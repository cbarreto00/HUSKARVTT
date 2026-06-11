package org.example.controller;

import org.example.view.CriarMesaView;
import org.example.view.EntrarMesaView;
import org.example.view.MenuView;

import javafx.fxml.FXML;
import javafx.stage.Stage;

public class MenuController {

    private Stage stage;
    private MenuView telaMenu;

    public void setTelaMenu(MenuView telaMenu){
        this.telaMenu = telaMenu;
    }

    @FXML
    public void clicarCriarMesa() {
        CriarMesaView telaCriarMesa = new CriarMesaView(new Stage());
        telaCriarMesa.exibir();
    }

    @FXML
    public void clicarEntrarMesa() {
        EntrarMesaView telaEntrarMesa = new EntrarMesaView(new Stage());
        telaEntrarMesa.exibir();
    }

    @FXML
    public void usuarioSair() {
        if (telaMenu != null)
            telaMenu.fechar();
    }

}