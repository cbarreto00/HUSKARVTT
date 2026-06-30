package org.example.controller;

import java.util.Optional;

import org.example.model.Token;
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

    @FXML
    private void adicionarTokenAleatorio() {

        TextInputDialog dialog = new TextInputDialog("Novo Guerreiro");
        dialog.setTitle("Criar Novo Token");
        dialog.setHeaderText("Configuração do Personagem");
        dialog.setContentText("Digite o nome do Token:");

        Optional<String> resultado = dialog.showAndWait();

        if (resultado.isPresent() && !resultado.get().trim().isEmpty()) {
            
            String nomeEscolhido = resultado.get();
            Token novoToken = new Token(nomeEscolhido, 25, 25, "");
            Circle visualToken = new Circle(20, Color.RED);
            visualToken.setCenterX(novoToken.posXProperty().get());
            visualToken.setCenterY(novoToken.posYProperty().get());
            visualToken.centerXProperty().bindBidirectional(novoToken.posXProperty());
            visualToken.centerYProperty().bindBidirectional(novoToken.posYProperty());
            visualToken.setOnMouseClicked(me -> {
            lblNomeToken.setText(novoToken.nomeProperty().get());
            visualToken.setStroke(Color.WHITE);
            visualToken.setStrokeWidth(3);
        });


        visualToken.setOnMouseDragged(me -> {
            novoToken.posXProperty().set(me.getX());
            novoToken.posYProperty().set(me.getY());
        });

        visualToken.setOnMouseReleased(me -> {
            //novoToken.posXProperty().set(Math.round((me.getX()/TAMANHO_GRID))*TAMANHO_GRID);
            //novoToken.posYProperty().set(Math.round((me.getY()/TAMANHO_GRID))*TAMANHO_GRID);
            double xAtual = novoToken.posXProperty().get();
            double yAtual = novoToken.posYProperty().get();

            // Descobre em qual coluna e linha do grid o mouse está
            double coluna = Math.floor(xAtual / TAMANHO_GRID);
            double linha = Math.floor(yAtual / TAMANHO_GRID);

            // Calcula o centro exato daquele quadrado do grid
            double novoX = (coluna * TAMANHO_GRID) + (TAMANHO_GRID / 2.0);
            double novoY = (linha * TAMANHO_GRID) + (TAMANHO_GRID / 2.0);

            // Proteção para não jogar o token para fora da tela (valores negativos)
            if (novoX < 0) novoX = TAMANHO_GRID / 2.0;
            if (novoY < 0) novoY = TAMANHO_GRID / 2.0;

            // Atualiza o Model, e a View se ajustará sozinha por conta do Bind
            novoToken.posXProperty().set(novoX);
            novoToken.posYProperty().set(novoY);
        });

        painelMesa.getChildren().add(visualToken);
    }else{
        System.out.println("Criação de token cancelada pelo usuário.");
    }
    }

    @FXML
    private void limparMesa() {
        painelMesa.getChildren().clear();
        lblNomeToken.setText("Nenhum");
    }
}