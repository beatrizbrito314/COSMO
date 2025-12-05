package controller;

import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import model.Disciplina;

public class DetalhesDisciplinaController {

    @FXML
    private Label lblNome;

    @FXML
    private ListView<String> listaTarefas;

    private static Disciplina disciplinaSelecionada;

    public static void setDisciplinaSelecionada(Disciplina d) {
        disciplinaSelecionada = d;
    }

    @FXML
    public void initialize() {
        lblNome.setText(disciplinaSelecionada.getNome());

        disciplinaSelecionada.getTarefas().forEach(t ->
            listaTarefas.getItems().add(t.getNome() + " - entrega: " + t.getDataEntrega())
        );
    }

    @FXML
    private void voltar() {
        Navigation.goTo("/view/ListaDisciplinas.fxml");
    }
}

