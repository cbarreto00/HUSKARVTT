package org.example.controller;

import javafx.geometry.Pos;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.TilePane;
import javafx.scene.shape.Rectangle;
import org.example.model.Mesa;
import org.example.repository.MesaRepository;
import org.example.view.CriarMesaView;
import org.example.view.EntrarMesaView;
import org.example.view.MenuView;
import javafx.fxml.FXML;
import javafx.stage.Stage;
import java.util.List;

public class MenuController {

    private Stage stage;
    private MenuView telaMenu;
    private MesaRepository mesaRepository = new MesaRepository();

    @FXML
    private TilePane painelMestreMesas;

    public void setTelaMenu(MenuView telaMenu){
        this.telaMenu = telaMenu;
    }

    @FXML
    public void clicarCriarMesa() {
        CriarMesaView telaCriarMesa = new CriarMesaView(new Stage());
        CriarMesaController criarMesaController = new CriarMesaController();
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

    @FXML
    public void clicarAtualizarMesas(){
        List<Mesa> listaMesas = mesaRepository.buscarTodas();
        painelMestreMesas.getChildren().clear();
        for (Mesa mesa : listaMesas){
            StackPane card = new StackPane();
            card.setStyle("-fx-alignment: center; -fx-padding: 10;");

            ImageView capa = new ImageView();
            capa.setFitWidth(300);
            capa.setFitHeight(180);
            capa.setImage(new Image(mesa.getCapa()));

            Rectangle molde = new Rectangle(300, 180);
            molde.setArcWidth(20);
            molde.setArcHeight(20);
            capa.setClip(molde);

            Label nomeDaMesa = new Label(mesa.getNome());
            nomeDaMesa.setStyle("-fx-font-weight: bold; -fx-font-size: 18; -fx-effect: dropshadow(one-pass-box, black, 15, 0.0, 0, 0);");
            StackPane.setAlignment(nomeDaMesa, Pos.BOTTOM_LEFT);
            StackPane.setMargin(nomeDaMesa, new javafx.geometry.Insets(0, 0, 15, 20));

            card.getChildren().addAll(capa, nomeDaMesa);
            painelMestreMesas.getChildren().add(card);
        }
    }
}