package service;

import model.Disciplina;
import java.util.List;

public class DisciplinaService {

    private DisciplinaDB db = new DisciplinaDB();
    private List<Disciplina> disciplinasCadastradas;

    public DisciplinaService() {
    	disciplinasCadastradas = db.carregar();
    }

    // add disciplina
    public void adicionar(Disciplina disciplina) {
    	disciplinasCadastradas.add(disciplina);
        db.salvar(disciplinasCadastradas);
    }

    // listar disciplinas
    public void listar() {
        if (disciplinasCadastradas.isEmpty()) {
            System.out.println("Nenhuma disciplina cadastrada.");
            return;
        }
        for (Disciplina disciplina : disciplinasCadastradas) {
            System.out.println(disciplina);
        }
    }

    // rmv disciplinas
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
    // lista de disciplinas
    public List<Disciplina> getDisciplinas() {
        return disciplinasCadastradas;
    }
}
