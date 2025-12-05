package controller;

import javafx.fxml.FXML;
import javafx.scene.control.ListView;
import model.Disciplina;
import service.DisciplinaService;

public class ListaDisciplinasController {

    @FXML
    private ListView<Disciplina> listaDisciplinas;

    private DisciplinaService disciplinaService = new DisciplinaService();

    @FXML
    public void initialize() {
        listaDisciplinas.getItems().addAll(disciplinaService.getDisciplinas());

        listaDisciplinas.setOnMouseClicked(event -> {
            if (event.getClickCount() == 2) {
                Disciplina d = listaDisciplinas.getSelectionModel().getSelectedItem();
                if (d != null) {
                    DetalhesDisciplinaController.setDisciplinaSelecionada(d);
                    Navigation.goTo("/view/DetalhesDisciplina.fxml");
                }
            }
        });
    }

    @FXML
    private void irParaCadastro() {
        Navigation.goTo("/view/CadastroDisciplina.fxml");
    }

    @FXML
    private void voltarHome() {
        Navigation.goTo("/view/Home.fxml");
    }
}
