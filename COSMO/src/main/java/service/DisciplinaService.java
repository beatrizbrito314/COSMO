package service;

import model.Disciplina;
import java.util.List;

public class DisciplinaService {

    private DisciplinaDB db = new DisciplinaDB();
    private List<Disciplina> disciplinasCadastradas;

    public DisciplinaService() {
        disciplinasCadastradas = db.carregar();
    }

    public void adicionar(Disciplina disciplina) {
        disciplinasCadastradas.add(disciplina);
        db.salvar(disciplinasCadastradas);
    }

    public Disciplina getById(int id) {
        return disciplinasCadastradas.stream()
                .filter(d -> d.getDiscID() == id)
                .findFirst()
                .orElse(null);
    }

    public boolean remover(int id) {
        Disciplina disciplinaRmv=null;

        for (Disciplina disciplina : disciplinasCadastradas) {
            if (disciplina.getDiscID() == id) {
                disciplinaRmv = disciplina;
                break;
            }
        }

        if (disciplinaRmv != null) {
            disciplinasCadastradas.remove(disciplinaRmv);
            db.salvar(disciplinasCadastradas);
            return true;
        }
        return false;
    }

    public List<Disciplina> getDisciplinas() {
        return disciplinasCadastradas;
    }

    // salva a lista atual no DB (útil quando alteramos tarefas dentro da disciplina)
    public void salvarDisciplinas() {
        db.salvar(disciplinasCadastradas);
    }
}
