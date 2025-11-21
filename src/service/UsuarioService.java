package service;

import model.Usuario;
import java.util.List;

public class UsuarioService {
	private UsuarioDB db= new UsuarioDB();
	private List<Usuario> usuariosCadastrados; 

	public UsuarioService() {
		usuariosCadastrados = db.carregarUsuarios(); //carregar a lista de usuarios no construtor
	}
	
	//função para realizar cadastro
	public boolean verificarCadastro(String nome, String email, String senha) {
		for(Usuario user: usuariosCadastrados) {
			if(user.getEmail().equals(email)) {
				return false;
			}
		}
	//caso não exista cadastra um novo usuario
		usuariosCadastrados.add(new Usuario(nome, email, senha));
		return true;
		}
	//função para realizar login
	public Usuario login (String email, String senha) {
		for (Usuario user: usuariosCadastrados) {
			if(user.getEmail().equals(email) && user.getSenha().equals(senha)) {
				return user;
			}
		}
		return null;

	}

}
