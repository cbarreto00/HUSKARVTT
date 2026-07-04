package org.example.controller;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.TilePane;
import javafx.scene.shape.Rectangle;
import org.example.model.Mesa;
import org.example.repository.MesaRepository;
import org.example.repository.TokenRepository;
import org.example.view.CriarMesaView;
import org.example.view.EntrarMesaView;
import org.example.view.MenuView;
import javafx.fxml.FXML;
import javafx.stage.Stage;
import javafx.scene.control.Button;
import java.util.List;
import java.util.Optional;

public class MenuController {

    private Stage stage;
    private MenuView telaMenu;
    private MesaRepository mesaRepository = new MesaRepository();
    private TokenRepository tokenRepository = new TokenRepository();

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

    private void abrirMesa(Mesa mesa) {
        EntrarMesaView telaEntrarMesa = new EntrarMesaView(new Stage(), mesa);
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
            StackPane.setMargin(nomeDaMesa, new Insets(0, 0, 15, 20));

            Button botaoExcluir = new Button("✕");
            botaoExcluir.setStyle("-fx-background-color: rgba(0,0,0,0.6); -fx-text-fill: white; -fx-font-weight: bold; -fx-background-radius: 15;");
            botaoExcluir.setOnMouseClicked(evento -> {
                evento.consume();
                clicarExcluirMesa(mesa);
            });
            StackPane.setAlignment(botaoExcluir, Pos.TOP_RIGHT);
            StackPane.setMargin(botaoExcluir, new Insets(10, 10, 0, 0));

            card.setOnMouseClicked(evento -> abrirMesa(mesa));

            card.getChildren().addAll(capa, nomeDaMesa, botaoExcluir);
            painelMestreMesas.getChildren().add(card);
        }
    }

    private void clicarExcluirMesa(Mesa mesa){
        Alert confirmacao = new Alert(Alert.AlertType.CONFIRMATION);
        confirmacao.setTitle("Excluir Mesa");
        confirmacao.setHeaderText("Excluir a mesa \"" + mesa.getNome() + "\"?");
        confirmacao.setContentText("Essa ação não pode ser desfeita.");

        Optional<ButtonType> resultado = confirmacao.showAndWait();
        if (resultado.isPresent() && resultado.get() == ButtonType.OK){
            try {
                tokenRepository.excluirTodosDaMesa(mesa);
                mesaRepository.excluir(mesa);
                clicarAtualizarMesas();
            } catch (Exception e){
                Alert erro = new Alert(Alert.AlertType.ERROR);
                erro.setTitle("Erro");
                erro.setHeaderText("Não foi possível excluir a mesa.");
                erro.setContentText(e.getMessage());
                erro.showAndWait();
            }
        }
    }
}