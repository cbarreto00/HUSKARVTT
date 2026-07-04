package org.example.controller;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.control.PasswordField;
import javafx.stage.Stage;
import javafx.scene.control.Label;
import java.util.List;

import org.example.view.LoginView;
import org.example.view.MenuView;
import org.example.model.Usuario;
import org.example.repository.UsuarioRepository;
import org.example.view.CadastroView;

public class LoginController
{
    @FXML
    private Button entrarButton;
    @FXML
    private Button cadastrarButton;
    @FXML
    private TextField usuarioTextField;
    @FXML
    private PasswordField senhaTextField;
    @FXML
    private Label falhaLoginLabel;
    @FXML
    private Label sucessoLoginLabel;
    
    private LoginView loginView;
    private Stage stage;
    private UsuarioRepository usrDb = new UsuarioRepository();
    
    public void setLoginTela(LoginView loginView) {
        this.loginView = loginView;
    }
    
    @FXML
    public void onEntrarButton(){
        
        List<Usuario> usuarios = usrDb.buscarPorUsuario(usuarioTextField.getText());
        
        Usuario usuario = new Usuario();

        int flag = 0;
        if(usuarios.size() == 0){
            flag++;
        }else{
            usuario = usuarios.get(0);         
            if(!usuario.getSenha().equals(senhaTextField.getText())) flag++;
        }
        
        if(flag == 0){
            this.falhaLoginLabel.setVisible(false);
            this.sucessoLoginLabel.setVisible(true);
            this.sucessoLoginLabel.setText("Login reilizado com sucesso!");
            MenuView menuView = new MenuView(new Stage());
            MenuController menuController = new MenuController();
            menuController.setUsuario(usuario);
            menuView.exibir();
            this.loginView.stop();
        }else{
            this.falhaLoginLabel.setVisible(true);
            this.sucessoLoginLabel.setVisible(false);
            this.falhaLoginLabel.setText("Usuario e/ou senha incorretos!");
        }
    }
    
    @FXML
    public void onCadastrarButton(){
        CadastroView telaCadastro = new CadastroView(new Stage());
        CadastroController cadastroController = new CadastroController();
        telaCadastro.exibir();
    }
}