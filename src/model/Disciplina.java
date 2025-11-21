package model;
import java.util.ArrayList;

public class Disciplina {
	private static int tempID = 0;

	private int discID;
	private String nome;
	private ArrayList<Tarefa> tarefas;
	public int getDiscID() {
		return discID;
	}

	//construtor para criar nova disc
	public Disciplina( String nome) {
	        this.discID = ++tempID;
	        this.nome = nome;
	        this.tarefas = new ArrayList<>();
	}
	//construtor para pegar disc do json
	public Disciplina(int id, String nome) {
	    this.discID = id; 
	    this.nome = nome;

	    if (id > tempID) {
	        tempID = id;  
	    }
	}
	
	public void setDiscID(int discID) {
		this.discID = discID;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public ArrayList<Tarefa> getTarefas() {
		return tarefas;
	}
	public void setTarefas(ArrayList<Tarefa> tarefas) {
		this.tarefas = tarefas;
	}
}
