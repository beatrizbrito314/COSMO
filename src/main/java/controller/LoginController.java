package controller;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TextField;
import javafx.scene.control.PasswordField;
import javafx.scene.control.Label;
import javafx.scene.input.MouseEvent;
import javafx.event.ActionEvent;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import application.Main;
import service.UsuarioService;
import model.Usuario;

import java.net.URL;
import java.util.ResourceBundle;

public class LoginController implements Initializable {

    @FXML private TextField email;        
    @FXML private PasswordField senha;    
    @FXML private ImageView leftImage;    
    @FXML private Label mensagem;        

    private UsuarioService usuarioService = new UsuarioService();

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        try {
            URL imgUrl = getClass().getResource("/images/login.png");
            if (imgUrl == null) {
                System.err.println("[LoginController] imagem /images/login.png NÃO encontrada.");
            } else {
                leftImage.setImage(new Image(imgUrl.toExternalForm()));
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    
    @FXML
    private void doLogin(ActionEvent event) {
        String emailInput = email.getText();
        String senhaInput = senha.getText();

        Usuario user = usuarioService.login(emailInput, senhaInput);

        if (user != null) {
            System.out.println("[LoginController] Login realizado com sucesso: " + emailInput);
            try {
                Main.changeScene("/view/Home.fxml"); 
            } catch (Exception e) {
                e.printStackTrace();
            }
        } else {
            System.out.println("[LoginController] Login falhou: " + emailInput);
            if (mensagem != null) {
                mensagem.setText("Email ou senha incorretos!");
            }
        }
    }

    @FXML
    private void goToRegister(ActionEvent event) {
        try {
            Main.changeScene("/view/Register.fxml");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
