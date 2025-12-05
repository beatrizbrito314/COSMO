package controller;

import javafx.fxml.FXML;
import javafx.scene.control.*;
import model.Tarefa;
import model.Disciplina;
import service.TarefaService;
import service.DisciplinaService;

public class CadastroTarefaController {

    @FXML private TextField txtNome;
    @FXML private TextField txtData;
    @FXML private TextField txtUrgencia;
    @FXML private TextField txtDificuldade;
    @FXML private ComboBox<Disciplina> cbDisciplina;

    private DisciplinaService disciplinaService = new DisciplinaService();

    @FXML
    public void initialize() {
        // popula combobox com disciplinas (toString() de Disciplina retorna nome)
        cbDisciplina.getItems().clear();
        cbDisciplina.getItems().addAll(disciplinaService.getDisciplinas());
    }

    @FXML
    private void salvarTarefa() {
        try {
            String nome = txtNome.getText().trim();
            String dataEntrega = txtData.getText().trim();
            int urgencia = Integer.parseInt(txtUrgencia.getText().trim());
            int dificuldade = Integer.parseInt(txtDificuldade.getText().trim());

            if (nome.isEmpty()) {
                mostrarMensagem("O nome da tarefa não pode estar vazio.");
                return;
            }

            if (dataEntrega.isEmpty()) {
                mostrarMensagem("A data de entrega não pode estar vazia.");
                return;
            }

            try {
                java.time.LocalDate.parse(dataEntrega); // valida formato
            } catch (Exception e) {
                mostrarMensagem("Data inválida! Use o formato AAAA-MM-DD.");
                return;
            }

            int disciplinaID = 0;
            Disciplina sel = cbDisciplina.getSelectionModel().getSelectedItem();
            if (sel != null) disciplinaID = sel.getDiscID();

            // Criar tarefa com disciplina associada
            Tarefa tarefa = new Tarefa(
                    nome,
                    dataEntrega,
                    urgencia,      // peso
                    dificuldade,   // complexidade
                    0,             // prioridade inicial (será recalculada)
                    disciplinaID
            );

            tarefa.calcularPrioridade();
            TarefaService.getInstance().adicionarTarefa(tarefa);

            mostrarMensagem("Tarefa salva com sucesso!");
            limparCampos();

        } catch (NumberFormatException e) {
            mostrarMensagem("Urgência e dificuldade devem ser números inteiros.");
        } catch (Exception e) {
            mostrarMensagem("Erro ao salvar: " + e.getMessage());
        }
    }

    @FXML
    private void voltar() {
        Navigation.goTo("/view/Home.fxml");
    }

    private void limparCampos() {
        txtNome.clear();
        txtData.clear();
        txtUrgencia.clear();
        txtDificuldade.clear();
        cbDisciplina.getSelectionModel().clearSelection();
    }

    private void mostrarMensagem(String texto) {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setHeaderText(null);
        alert.setContentText(texto);
        alert.showAndWait();
    }
}
