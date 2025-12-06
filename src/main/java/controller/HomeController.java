package controller;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.event.ActionEvent;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.fxml.FXMLLoader;
import java.net.URL;
import java.util.ResourceBundle;
import java.io.IOException;

import service.Session; 
import model.Usuario;

public class HomeController implements Initializable {

    @FXML private Label saudacaoLabel; 

    @Override
    public void initialize(URL location, ResourceBundle resources) {
      
        Usuario usuarioLogado = Session.getUsuarioLogado();
        if (usuarioLogado != null) {
            saudacaoLabel.setText("Olá, " + usuarioLogado.getNome() + "!");
        }
    }

    private Stage getStage(ActionEvent event) {
        return (Stage) ((Node) event.getSource()).getScene().getWindow();
    }

    private void trocarCena(ActionEvent event, String caminhoFXML) {
        try {
            Parent root = FXMLLoader.load(getClass().getResource(caminhoFXML));
            Stage stage = getStage(event);
            stage.setScene(new Scene(root));
            stage.show();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @FXML
    private void openDisciplina(ActionEvent event) {
        trocarCena(event, "/view/ListaDisciplinas.fxml");
    }

    @FXML
    private void openTarefas(ActionEvent event) {
        trocarCena(event, "/view/TarefaCadastro.fxml");
    }

    @FXML
    private void logout(ActionEvent event) {
      
        Session.setUsuarioLogado(null);
        trocarCena(event, "/view/Login.fxml");
    }
}

