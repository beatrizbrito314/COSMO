package service;
import model.Tarefa;

import java.util.Comparator;
import java.util.List;

//(Ainda vou implementar a funcionalidade de listar de acordo com a prioridade)
public class TarefaService {
	private TarefaDB db= new TarefaDB();
	private List<Tarefa> tarefasCadastradas;
	
	 public TarefaService() {
		 tarefasCadastradas = db.carregar();
	    }
	 
	 //adicionar tarefa
	 public void addTarefa(Tarefa tarefa) {
		    // adiciona normalmente
		    tarefasCadastradas.add(tarefa);

		    // organiza pela urgência (maior prioridade primeiro)
		    tarefasCadastradas.sort(
		    	    Comparator.comparing(Tarefa::getPrioridade).reversed()
		    	);

		    // salva no JSON
		    db.salvar(tarefasCadastradas);
		}
	 //listar tarefas 
	 public void listarTarefas() {
		 if(tarefasCadastradas.isEmpty()) {
			 System.out.println("Nenhuma tarefa cadastrada.");
	         return;
		 }
		 for (Tarefa tarefa:tarefasCadastradas) {
			 System.out.println(tarefa.getNome());
		 }
	 }
	 //remover tarefas
	 public boolean remover(int id) {
		    for (int i = 0; i < tarefasCadastradas.size(); i++) {
		        if (tarefasCadastradas.get(i).getTarefaID() == id) {
		        	tarefasCadastradas.remove(i);
		            db.salvar(tarefasCadastradas);
		            return true;
		        }
		    }
		    return false;
		}

}
