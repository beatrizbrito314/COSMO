package controller;

import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.TextField;
import model.Disciplina;
import service.DisciplinaService;

public class CadastroDisciplinaController {

    @FXML
    private TextField txtNome;

    private DisciplinaService service = new DisciplinaService();

    @FXML
    private void salvar() {
        String nome = txtNome.getText().trim();

        if (nome.isEmpty()) {
            msg("O nome não pode estar vazio");
            return;
        }

        service.adicionar(new Disciplina(nome));
        msg("Disciplina cadastrada com sucesso!");
        txtNome.clear();
    }

    @FXML
    private void voltar() {
        Navigation.goTo("/view/ListaDisciplinas.fxml");
    }

    private void msg(String t) {
        Alert a = new Alert(Alert.AlertType.INFORMATION);
        a.setHeaderText(null);
        a.setContentText(t);
        a.showAndWait();
    }
}
