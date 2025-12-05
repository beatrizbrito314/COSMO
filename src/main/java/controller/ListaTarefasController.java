package controller;

import javafx.fxml.FXML;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.util.Callback;
import model.Tarefa;
import service.TarefaService;
import service.DisciplinaService;
import model.Disciplina;

public class ListaTarefasController {

    @FXML
    private TableView<Tarefa> tabelaTarefas;

    @FXML
    private TableColumn<Tarefa, Void> colAcao;

    @FXML
    private TableColumn<Tarefa, String> colDisciplina;

    private ObservableList<Tarefa> lista;
    private TarefaService tarefaService = TarefaService.getInstance();
    private DisciplinaService disciplinaService = new DisciplinaService();

    @FXML
    public void initialize() {

        lista = FXCollections.observableArrayList(
                tarefaService.listarTarefas()
        );

        // Ordena por prioridade (maior primeiro)
        lista.sort((t1, t2) -> Double.compare(t2.getPrioridade(), t1.getPrioridade()));
        tabelaTarefas.setItems(lista);

        configurarColunaDisciplina();
        configurarColunaRemover();
    }

    private void configurarColunaDisciplina() {
        colDisciplina.setCellValueFactory(cellData -> {
            Tarefa t = cellData.getValue();
            int id = t.getDisciplinaID();
            if (id <= 0) {
                return javafx.beans.property.SimpleStringProperty.stringExpression(javafx.beans.binding.Bindings.createStringBinding(() -> "—"));
            }
            Disciplina d = disciplinaService.getById(id);
            String nome = (d != null) ? d.getNome() : "—";
            return new javafx.beans.property.SimpleStringProperty(nome);
        });
    }

    private void configurarColunaRemover() {
        Callback<TableColumn<Tarefa, Void>, TableCell<Tarefa, Void>> cellFactory = new Callback<>() {
            @Override
            public TableCell<Tarefa, Void> call(final TableColumn<Tarefa, Void> param) {
                return new TableCell<>() {

                    private final Button btn = new Button("Excluir");

                    {
                        btn.setStyle("-fx-background-color: #d9534f; -fx-text-fill: white;");
                        btn.setOnAction(event -> {
                            Tarefa tarefa = getTableView().getItems().get(getIndex());

                            // Remove do serviço (que salva no JSON)
                            tarefaService.removerTarefa(tarefa);

                            // Remove da tabela
                            lista.remove(tarefa);
                        });
                    }

                    @Override
                    public void updateItem(Void item, boolean empty) {
                        super.updateItem(item, empty);

                        if (empty) {
                            setGraphic(null);
                        } else {
                            setGraphic(btn);
                        }
                    }
                };
            }
        };

        colAcao.setCellFactory(cellFactory);
    }

    @FXML
    private void voltarParaCadastro() {
        Navigation.goTo("/view/CadastroTarefa.fxml");
    }
}
