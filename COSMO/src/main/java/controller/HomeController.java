package controller;

import java.io.IOException;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.event.ActionEvent;

public class HomeController {

    private Stage getStage(ActionEvent event) {
        return (Stage) ((Node) event.getSource()).getScene().getWindow();
    }

    // =============== TROCA DE CENA ===============

    private void trocarCena(ActionEvent event, String caminhoFXML) {
        try {
            System.out.println("[HomeController] Tentando carregar: " + caminhoFXML);

            // Tentando localizar o arquivo no classpath
            var url = getClass().getResource(caminhoFXML);

            if (url == null) {
                System.err.println("[ERRO] Arquivo NÃO encontrado: " + caminhoFXML);
                System.err.println("Verifique se o arquivo está em: src/main/resources" + caminhoFXML);
                return;
            }

            Parent root = FXMLLoader.load(url);

            Stage stage = getStage(event);
            stage.setScene(new Scene(root));
            stage.show();

            System.out.println("[HomeController] Cena carregada com sucesso!");

        } catch (IOException e) {
            System.err.println("[ERRO] Falha ao carregar FXML: " + caminhoFXML);
            e.printStackTrace();
        } catch (Exception e) {
            System.err.println("[ERRO] Erro inesperado ao trocar cena.");
            e.printStackTrace();
        }
    }

    // =============== BOTÕES DO MENU ===============

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
        trocarCena(event, "/view/Login.fxml");
    }
}
