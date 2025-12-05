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

    // novo: associação
    private int disciplinaID; // 0 = sem disciplina

    // Construtor para criar nova tarefa
    public Tarefa(String nome, String dataEntrega, int peso, int complexidade, double prioridade, int disciplinaID) {
        this.tarefaID = ++tempID;
        this.nome = nome;
        this.dataEntrega = dataEntrega;
        this.peso = peso;
        this.complexidade = complexidade;
        this.prioridade = prioridade;
        this.concluida = false;
        this.disciplinaID = disciplinaID;
    }

    // Construtor para carregar tarefa existente
    public Tarefa(int id, String nome, String dataEntrega, int peso, int complexidade, double prioridade, boolean concluida, int disciplinaID) {
        this.tarefaID = id;
        this.nome = nome;
        this.dataEntrega = dataEntrega;
        this.peso = peso;
        this.complexidade = complexidade;
        this.prioridade = prioridade;
        this.concluida = concluida;
        this.disciplinaID = disciplinaID;

        if (id > tempID) {
            tempID = id;
        }
    }

    // Getters
    public int getTarefaID() { return tarefaID; }
    public String getNome() { return nome; }
    public String getDataEntrega() { return dataEntrega; }
    public int getPeso() { return peso; }
    public int getComplexidade() { return complexidade; }
    public double getPrioridade() { return prioridade; }
    public boolean isConcluida() { return concluida; }
    public int getDisciplinaID() { return disciplinaID; }

    // Setters
    public void setTarefaID(int tarefaID) { this.tarefaID = tarefaID; }
    public void setConcluida(boolean concluida) { this.concluida = concluida; }
    public void setDisciplinaID(int disciplinaID) { this.disciplinaID = disciplinaID; }

    // Cálculo da prioridade
    public void calcularPrioridade() {
        try {
            LocalDate hoje = LocalDate.now();
            LocalDate entrega = LocalDate.parse(dataEntrega);

            long diasRestantes = ChronoUnit.DAYS.between(hoje, entrega);
            if (diasRestantes < 0) diasRestantes = 0;

            this.prioridade = (peso * 2) + (complexidade * 1.5) + (100 - diasRestantes);
        } catch (Exception e) {
            // Se a data estiver inválida, calcula prioridade simples
            this.prioridade = (peso * 2) + (complexidade * 1.5);
        }
    }

    // opcional para exibição
    @Override
    public String toString() {
        return nome;
    }
}
