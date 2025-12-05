package controller;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TextField;
import javafx.scene.control.PasswordField;
import javafx.scene.input.MouseEvent;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import application.Main;
import service.UsuarioService;

import java.net.URL;
import java.util.ResourceBundle;

public class RegisterController implements Initializable {

    @FXML private TextField email;
    @FXML private TextField usuario;
    @FXML private PasswordField senha;
    @FXML private ImageView leftImage;

    private UsuarioService usuarioService = new UsuarioService();

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        try {
            URL imgUrl = getClass().getResource("/images/conta.jpg");
            if (imgUrl == null) {
                System.err.println("[RegisterController] imagem /images/conta.jpg NÃO encontrada.");
            } else {
                leftImage.setImage(new Image(imgUrl.toExternalForm()));
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    // ================== CADASTRAR ==================
    @FXML
    private void createAccount() {
        String nomeInput = usuario.getText();
        String emailInput = email.getText();
        String senhaInput = senha.getText();

        boolean sucesso = usuarioService.verificarCadastro(nomeInput, emailInput, senhaInput);

        if (sucesso) {
            System.out.println("[RegisterController] Usuário cadastrado: " + emailInput);
            try {
                Main.changeScene("/view/Login.fxml");
            } catch (Exception e) {
                e.printStackTrace();
            }
        } else {
            System.out.println("[RegisterController] Falha no cadastro.");
        }
    }

    // ================== VOLTAR PARA LOGIN ==================
    @FXML
    private void goToLogin(MouseEvent event) {
        try {
            Main.changeScene("/view/Login.fxml");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
