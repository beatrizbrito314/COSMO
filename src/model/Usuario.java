package model;

public class Usuario {

	 private static int tempID = 0;
	private int userID;
	private String nome;
	private String email;
	private String senha;

	//criar user
    public Usuario(String nome, String email, String senha) {
    	this.userID = ++tempID;
    	this.nome = nome;
        this.email = email;
        this.senha = senha;
    }
    //pegar do json
    public Usuario(int id, String nome, String email, String senha) {
        this.userID = id;
        this.nome = nome;
        this.email = email;
        this.senha = senha;

        if (id > tempID) {
            tempID = id;
        }
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
