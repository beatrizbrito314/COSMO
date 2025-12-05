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

    @FXML private TextField email;        // campo de email
    @FXML private PasswordField senha;    // campo de senha
    @FXML private ImageView leftImage;    // imagem à esquerda
    @FXML private Label mensagem;         // mensagem de erro/sucesso

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

    // ================== LOGIN ==================
    @FXML
    private void doLogin(ActionEvent event) {
        String emailInput = email.getText();
        String senhaInput = senha.getText();

        Usuario user = usuarioService.login(emailInput, senhaInput);

        if (user != null) {
            System.out.println("[LoginController] Login realizado com sucesso: " + emailInput);
            try {
                Main.changeScene("/view/Home.fxml"); // ou outra tela pós-login
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

    // ================== IR PARA REGISTRO ==================
    @FXML
    private void goToRegister(ActionEvent event) {
        try {
            Main.changeScene("/view/Register.fxml");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @FXML
    private void goToRegister(MouseEvent event) {
        try {
            Main.changeScene("/view/Register.fxml");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
