package org.example.controller;

import java.io.File;
import java.text.Normalizer;

import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.shape.Rectangle;
import javafx.stage.FileChooser;
import javafx.stage.Stage;
import org.example.model.Mesa;
import org.example.repository.MesaRepository;
import org.example.view.CriarMesaView;

public class CriarMesaController {

    private Stage stage;
    private CriarMesaView view;
    private String imagePath;

    private final MesaRepository mesaRepository = new MesaRepository();

    @FXML private TextField nomeTextField;
    @FXML private PasswordField senhaPasswordField;
    @FXML private Label nomeDaMesaPreview;
    @FXML private Label idDaMesaPreview;
    @FXML private ImageView imagemPreview;
    @FXML private Label labelErroNome;
    @FXML private Label labelErroSenha;
    @FXML private Label labelErroCapa;

    @FXML
    public void initialize(){
        nomeDaMesaPreview.textProperty().bind(nomeTextField.textProperty());
        nomeTextField.textProperty().addListener((observable, valorAntigo, valorNovo) -> {
            idDaMesaPreview.setText("#" + Normalizer.normalize(valorNovo.replace(" ", ""), Normalizer.Form.NFD).replaceAll("\\p{M}", ""));
        });

        labelErroNome.managedProperty().bind(labelErroNome.visibleProperty());
        labelErroNome.setVisible(false);
        labelErroSenha.managedProperty().bind(labelErroSenha.visibleProperty());
        labelErroSenha.setVisible(false);
        labelErroCapa.managedProperty().bind(labelErroCapa.visibleProperty());
        labelErroCapa.setVisible(false);
    }

    @FXML
    public void clicarImagemDeCapa(){
        FileChooser explorer = new FileChooser();
        explorer.getExtensionFilters().add(new FileChooser.ExtensionFilter("Arquivos de Imagem", "*.png", "*.jpg", "*.jpeg"));

        File imagem = explorer.showOpenDialog(null);

        if (imagem != null){
            String path = imagem.toURI().toString();
            System.out.println(path);
            Image imagemSelecionada = new Image(path);
            imagePath = path;

            imagemPreview.setImage(imagemSelecionada);
            imagemPreview.setFitWidth(300);
            imagemPreview.setFitHeight(180);
            imagemPreview.setPreserveRatio(false);

            Rectangle mask = new Rectangle(299, 179);
            mask.setArcWidth(20);
            mask.setArcHeight(20);
            imagemPreview.setClip(mask);
        }
    }

    @FXML
    public void clicarCriarMesa(){
        try {
            String nome = null;
            String senha = null;
            String capa = null;
            nome = nomeTextField.getText();
            senha = senhaPasswordField.getText();
            capa = imagePath;
            if(nome.trim().isEmpty()){
                labelErroNome.setVisible(true);
            }else{
                labelErroNome.setVisible(false);
            }

            if(senha.trim().isEmpty()){
                labelErroSenha.setVisible(true);
            }else{
                labelErroSenha.setVisible(false);
            }

            if(capa == null){
                labelErroCapa.setVisible(true);
            }else{
                labelErroCapa.setVisible(false);
            }

            if(!nome.trim().isEmpty() && !senha.trim().isEmpty() && capa != null){
                Mesa mesa = new Mesa(nome, senha, capa);
                mesaRepository.salvar(mesa);

                Alert alerta = new Alert(Alert.AlertType.INFORMATION);
                alerta.setTitle("Mesa criada!");
                alerta.setHeaderText(null);
                alerta.setContentText("Mesa criada e salva com sucesso!");
                alerta.showAndWait();

                Stage stageAtual = (Stage) nomeTextField.getScene().getWindow();
                stageAtual.close();
            }
        } catch (Exception e) {
            e.printStackTrace();
            throw new RuntimeException(e);
        }
    }

    @FXML
    public void clicarCancelarMesa(){
        Stage stageAtual = (Stage) nomeTextField.getScene().getWindow();
        stageAtual.close();
    }
}
