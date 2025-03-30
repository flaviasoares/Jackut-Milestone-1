package br.ufal.ic.p2.jackut;

import java.util.HashMap;
import java.util.Map;

import easyaccept.EasyAccept;

public class Facade {
    private Map<String, Usuario> usuarios;
    private String usuarioLogado;

    public Facade() {
        this.usuarios = new HashMap<>();
        this.usuarioLogado = null;
    }

    // 1. Criar usuário
    public void criarUsuario(String login, String senha, String nome) {
        if (login == null || login.trim().isEmpty()) {
            throw new IllegalArgumentException("Login inválido.");
        }
        if (senha == null || senha.trim().isEmpty()) {
            throw new IllegalArgumentException("Senha inválida.");
        }
        if (nome == null || nome.trim().isEmpty()) {
            throw new IllegalArgumentException("Nome inválido.");
        }
        if (usuarios.containsKey(login)) {
            throw new IllegalArgumentException("Conta com esse nome já existe.");
        }
        usuarios.put(login, new Usuario(nome, login, senha));
    }    

    // 2. Abrir sessão
    public void abrirSessao(String login, String senha) {
        if (!usuarios.containsKey(login) || !usuarios.get(login).getSenha().equals(senha)) {
            throw new IllegalArgumentException("Login ou senha inválidos.");
        }
        usuarioLogado = login;
    }

    // 3. Zerar sistema
    public void zerarSistema() {
        usuarios.clear();
        usuarioLogado = null;
    }

    // 4. Encerrar sistema
    public void encerrarSistema() {
        usuarios = null;
        usuarioLogado = null;
    }

    // 5. Obter atributo do usuário
    public String getAtributoUsuario(String login, String atributo) {
        Usuario usuario = getUsuario(login);
        return switch (atributo.toLowerCase()) {
            case "nome" -> usuario.getNome();
            case "senha" -> usuario.getSenha();
            default -> throw new IllegalArgumentException("Atributo inválido.");
        };
    }

    // Método auxiliar para obter usuário e lançar erro se não encontrado
    private Usuario getUsuario(String login) {
        if (!usuarios.containsKey(login)) {
            throw new IllegalArgumentException("Usuário não cadastrado.");
        }
        return usuarios.get(login);
    }    
}