package service;

import model.Usuario;
import java.util.List;

public class UsuarioService {
    private UsuarioDB db = new UsuarioDB();
    private List<Usuario> usuariosCadastrados;

    public UsuarioService() {
        // Carrega a lista de usuários do JSON
        usuariosCadastrados = db.carregarUsuarios();
        // Atualiza tempID para que novos IDs sejam únicos
        Usuario.atualizarTempID(usuariosCadastrados);
    }

    // Cadastro de usuário
    public boolean verificarCadastro(String nome, String email, String senha) {
        if (nome == null || nome.isBlank() ||
            email == null || email.isBlank() ||
            senha == null || senha.isBlank()) {
            return false;
        }

        // Verifica se já existe usuário com o mesmo email
        for (Usuario user : usuariosCadastrados) {
            if (user.getEmail().equals(email)) {
                return false;
            }
        }

        // Cria novo usuário
        Usuario novoUsuario = new Usuario(nome, email, senha);
        usuariosCadastrados.add(novoUsuario);

        // Salva no JSON
        db.salvarUsuarios(usuariosCadastrados);

        return true;
    }

    // Login de usuário
    public Usuario login(String email, String senha) {
        if (email == null || senha == null) return null;

        for (Usuario user : usuariosCadastrados) {
            if (user.getEmail().equals(email) && user.getSenha().equals(senha)) {
                return user;
            }
        }

        return null;
    }
}
