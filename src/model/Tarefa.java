package model;


import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

public class Tarefa {
	private static int tempID = 0;
	
	private int tarefaID;
	private String nome;
	private String dataEntrega;
	private int peso;
	private int complexidade;
	private double prioridade;
	private boolean concluida;
	
	//construtor para criar
	public Tarefa(String nome, String dataEntrega, int peso,int complexidade, int prioridade) {
	    this.tarefaID =++tempID;
	    this.nome = nome;
	    this.dataEntrega = dataEntrega;
	    this.peso = peso;
	    this.complexidade = complexidade;
	    this.prioridade = prioridade;
	    this.concluida = false;
}
	//construtor para acessar
	 public Tarefa(int id, String nome, String dataEntrega, int peso, int complexidade, int prioridade, boolean concluida) {
	        this.tarefaID = id;
	        this.nome = nome;
	        this.dataEntrega = dataEntrega;
	        this.peso = peso;
	        this.complexidade = complexidade;
	        this.prioridade = prioridade;
	        this.concluida = concluida;

	        if (id > tempID) {
	            tempID = id;
	        }
	    }
	
	public String getNome() {
		return nome;
	}
	
	public String getDataEntrega() {
		return dataEntrega;
	}
	
	public int getPeso() {
		return peso;
	}

	public int getComplexidade() {
		return complexidade;
	}

	public int getTarefaID() {
		return tarefaID;
	}
	
	public double getPrioridade() {
		return prioridade;
	}

	public void setTarefaID(int tarefaID) {
		this.tarefaID = tarefaID;
	}
	 public void calcularPrioridade() {
	        LocalDate hoje = LocalDate.now();
	        LocalDate entrega = LocalDate.parse(dataEntrega); 

	        long diasRestantes = ChronoUnit.DAYS.between(hoje, entrega);

	        if (diasRestantes < 0){
	        	diasRestantes=0;
	        }

	        this.prioridade= (peso * 2) + (complexidade * 1.5) + (100 - diasRestantes);
	    }

}
