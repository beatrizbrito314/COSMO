package service;

import java.util.List;
import model.Tarefa;

public class TarefaService {

    private static TarefaService instance;

    private List<Tarefa> tarefas;

    private TarefaDB db = new TarefaDB();
    private DisciplinaService disciplinaService = new DisciplinaService();

    private TarefaService() {
        tarefas = db.carregar(); // carrega tarefas do JSON
    }

    public static TarefaService getInstance() {
        if (instance == null) {
            instance = new TarefaService();
        }
        return instance;
    }

    public void adicionarTarefa(Tarefa tarefa) {
        tarefa.calcularPrioridade();
        tarefas.add(tarefa);
        db.salvar(tarefas);

        // associa à disciplina (se existir)
        if (tarefa.getDisciplinaID() > 0) {
            var disc = disciplinaService.getById(tarefa.getDisciplinaID());
            if (disc != null) {
                // adicionar cópia (ou a própria referência)
                disc.getTarefas().add(tarefa);
                disciplinaService.salvarDisciplinas();
            }
        }
    }

    public void removerTarefa(Tarefa tarefa) {
        tarefas.remove(tarefa);
        db.salvar(tarefas);

        // também remover da disciplina associada (se existir)
        if (tarefa.getDisciplinaID() > 0) {
            var disc = disciplinaService.getById(tarefa.getDisciplinaID());
            if (disc != null) {
                disc.getTarefas().removeIf(t -> t.getTarefaID() == tarefa.getTarefaID());
                disciplinaService.salvarDisciplinas();
            }
        }
    }

    public List<Tarefa> listarTarefas() {
        return tarefas;
    }
}
