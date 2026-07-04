package org.example.controller;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.control.PasswordField;
import javafx.scene.control.Alert.AlertType;
import javafx.stage.Stage;
import javafx.scene.control.Alert;

import org.example.view.CadastroView;
import org.example.model.Usuario;
import org.example.repository.UsuarioRepository;

public class CadastroController
{
    @FXML
    private Button cancelarButton;
    @FXML
    private Button cadastrarButton;
    @FXML
    private TextField nomeField;
    @FXML
    private TextField usuarioField;
    @FXML
    private Label usuarioErroLabel;
    @FXML
    private TextField emailField;
    @FXML
    private Label emailErroLabel;
    @FXML
    private PasswordField senhaField;
    @FXML
    private Label senhaErroLabel;
    @FXML
    private PasswordField confirmarSenhaField;
    
    private CadastroView cadastroView;
    private Stage stage;
    private UsuarioRepository usrDb = new UsuarioRepository();
    
    public void setTelaCadastro(CadastroView cadastroView){
        this.cadastroView = cadastroView;
    }
    
    @FXML
    public void onCadastrarButton(){

        int flag = 0;
        if(usrDb.buscarPorUsuario(usuarioField.getText()).size() != 0){
            this.usuarioErroLabel.setText("Este nome de usuário já está em uso!");
            this.usuarioErroLabel.setVisible(true);
            flag++;
        }else{
            this.usuarioErroLabel.setVisible(false);
        }
    
        if(usrDb.buscarPorEmail(emailField.getText()).size() != 0){
            this.emailErroLabel.setVisible(true);
            this.emailErroLabel.setText("Este e-mail já está em uso!");
            flag++;
        }else{
            this.emailErroLabel.setVisible(false);
        }
        
        if(!senhaField.getText().equals(confirmarSenhaField.getText())){
            this.senhaErroLabel.setVisible(true);
            this.senhaErroLabel.setText("A senha está diferente!");
            flag++;
        }else{
            this.senhaErroLabel.setVisible(false);
        }
        
        try{
            if(flag == 0){
                Usuario usuario = new Usuario();
                usuario.setNomeCompleto(nomeField.getText());
                usuario.setEnderecoEmail(emailField.getText());
                usuario.setNomeUsuario(usuarioField.getText());
                usuario.setSenha(senhaField.getText());
            
                this.usrDb.cadastrar(usuario);
                cadastroView.stop();
            }
            
        }catch(Exception e) {
            new Alert(AlertType.ERROR, "Erro ao salvar: "+e.getMessage()).show();
        }
    }
    
    @FXML
    public void onCancelarButton(){
        cadastroView.stop();
    }
}