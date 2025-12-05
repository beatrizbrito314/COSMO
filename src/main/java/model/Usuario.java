package model;

import java.util.List;

public class Usuario {

    private static int tempID = 0;
    private int userID;
    private String nome;
    private String email;
    private String senha;

    // Criar novo usuário
    public Usuario(String nome, String email, String senha) {
        this.userID = ++tempID;
        this.nome = nome;
        this.email = email;
        this.senha = senha;
    }

    // Carregar usuário do JSON
    public Usuario(int userID, String nome, String email, String senha) {
        this.userID = userID;
        this.nome = nome;
        this.email = email;
        this.senha = senha;

        if (userID > tempID) {
            tempID = userID;
        }
    }

    // Atualiza o tempID com base na lista carregada do JSON
    public static void atualizarTempID(List<Usuario> usuarios) {
        int maior = 0;
        for (Usuario u : usuarios) {
            if (u.getUserID() > maior) {
                maior = u.getUserID();
            }
        }
        tempID = maior;
    }

    public int getUserID() {
        return userID;
    }

    public String getNome() {
        return nome;
    }

    public String getEmail() {
        return email;
    }

    public String getSenha() {
        return senha;
    }
}
