package org.example.controller;

import java.util.List;
import java.util.Optional;

import org.example.model.Mesa;
import org.example.model.Token;
import org.example.model.TokenEntity;
import org.example.repository.TokenRepository;
import org.example.view.CriarMesaView;
import org.example.view.EntrarMesaView;

import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TextInputDialog;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.stage.Stage;

public class MesaController {

    private Stage stage;
    private CriarMesaView telaMesa;
    private EntrarMesaView telaEntrarMesa;

    private Mesa mesa;
    private final TokenRepository tokenRepository = new TokenRepository();

    @FXML
    private Pane painelMesa;

    @FXML
    private Label lblNomeToken;

    private final double TAMANHO_GRID = 50.0;

    @FXML
    public void initialize() {
    }

    public void setTelaMesa(CriarMesaView telaMesa){
        this.telaMesa = telaMesa;
    }

    public void setTelaEntrarMesa(EntrarMesaView telaEntrarMesa){
        this.telaEntrarMesa = telaEntrarMesa;
    }

    public void setMesa(Mesa mesa) {
        this.mesa = mesa;
        carregarTokensSalvos();
    }

    private void carregarTokensSalvos() {
        painelMesa.getChildren().clear();
        lblNomeToken.setText("Nenhum");

        if (mesa == null) {
            return;
        }

        List<TokenEntity> tokensSalvos = tokenRepository.buscarPorMesa(mesa);
        for (TokenEntity tokenSalvo : tokensSalvos) {
            criarTokenNaTela(tokenSalvo);
        }
    }

    @FXML
    private void adicionarTokenAleatorio() {

        TextInputDialog dialog = new TextInputDialog("Novo Guerreiro");
        dialog.setTitle("Criar Novo Token");
        dialog.setHeaderText("Configuração do Personagem");
        dialog.setContentText("Digite o nome do Token:");

        Optional<String> resultado = dialog.showAndWait();

        if (resultado.isPresent() && !resultado.get().trim().isEmpty()) {

            String nomeEscolhido = resultado.get();

            TokenEntity novoTokenEntity = new TokenEntity(mesa, nomeEscolhido, 25, 25, "");
            tokenRepository.salvar(novoTokenEntity);

            criarTokenNaTela(novoTokenEntity);
        } else {
            System.out.println("Criação de token cancelada pelo usuário.");
        }
    }

    private void criarTokenNaTela(TokenEntity tokenEntity) {

        Token token = new Token(
                tokenEntity.getNome(),
                tokenEntity.getPosX(),
                tokenEntity.getPosY(),
                tokenEntity.getUrlImagem()
        );

        Circle visualToken = new Circle(20, Color.RED);
        visualToken.setCenterX(token.posXProperty().get());
        visualToken.setCenterY(token.posYProperty().get());
        visualToken.centerXProperty().bindBidirectional(token.posXProperty());
        visualToken.centerYProperty().bindBidirectional(token.posYProperty());

        visualToken.setOnMouseClicked(me -> {
            lblNomeToken.setText(token.nomeProperty().get());
            visualToken.setStroke(Color.WHITE);
            visualToken.setStrokeWidth(3);
        });

        visualToken.setOnMouseDragged(me -> {
            token.posXProperty().set(me.getX());
            token.posYProperty().set(me.getY());
        });

        visualToken.setOnMouseReleased(me -> {
            double xAtual = token.posXProperty().get();
            double yAtual = token.posYProperty().get();

            double coluna = Math.floor(xAtual / TAMANHO_GRID);
            double linha = Math.floor(yAtual / TAMANHO_GRID);

            double novoX = (coluna * TAMANHO_GRID) + (TAMANHO_GRID / 2.0);
            double novoY = (linha * TAMANHO_GRID) + (TAMANHO_GRID / 2.0);

            if (novoX < 0) novoX = TAMANHO_GRID / 2.0;
            if (novoY < 0) novoY = TAMANHO_GRID / 2.0;

            token.posXProperty().set(novoX);
            token.posYProperty().set(novoY);

            tokenEntity.setPosX(novoX);
            tokenEntity.setPosY(novoY);
            tokenRepository.salvar(tokenEntity);
        });

        painelMesa.getChildren().add(visualToken);
    }

    @FXML
    private void limparMesa() {
        painelMesa.getChildren().clear();
        lblNomeToken.setText("Nenhum");

        if (mesa != null) {
            tokenRepository.excluirTodosDaMesa(mesa);
        }
    }
}