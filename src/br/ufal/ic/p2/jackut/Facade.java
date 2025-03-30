package br.ufal.ic.p2.jackut;

import java.util.HashMap;
import java.util.Map;

import easyaccept.EasyAccept;

 // Classe Facade que gerencia a criação e manipulação de usuários.
 // Utiliza um HashMap para armazenar usuários e mantém um controle
 // do usuário atualmente logado.
public class Facade {
    private Map<String, Usuario> usuarios;
    private String usuarioLogado;

    // Construtor da classe Facade.
    // Inicializa a estrutura de dados para armazenar usuários.
    public Facade() {
        this.usuarios = new HashMap<>();
        this.usuarioLogado = null;
    }

    // Cria um novo usuário no sistema.
    // @param login Nome de usuário único.
    // @param senha Senha de acesso.
    // @param nome Nome completo do usuário.
    // @throws IllegalArgumentException Se os parâmetros forem inválidos.
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
            throw new IllegalArgumentException("Uma conta com esse login já existe.");
        }
        usuarios.put(login, new Usuario(nome, login, senha));
    }

    // Realiza login no sistema.
    // @param login Nome de usuário.
    // @param senha Senha de acesso.
    // @throws IllegalArgumentException Se as credenciais forem inválidas.
    public void abrirSessao(String login, String senha) {
        if (!usuarios.containsKey(login) || !usuarios.get(login).getSenha().equals(senha)) {
            throw new IllegalArgumentException("Login ou senha inválidos.");
        }
        usuarioLogado = login;
    }

    // Remove todos os usuários e redefine o estado do sistema.
    public void zerarSistema() {
        usuarios.clear();
        usuarioLogado = null;
    }

    // Finaliza a execução do sistema.
    public void encerrarSistema() {
        usuarios = null;
        usuarioLogado = null;
    }

     // Retorna um atributo específico de um usuário.
     // @param login Nome de usuário.
     // @param atributo Nome do atributo desejado ("nome" ou "senha").
     // @return O valor do atributo.
     // @throws IllegalArgumentException Se o atributo for inválido.

    public String getAtributoUsuario(String login, String atributo) {
        Usuario usuario = getUsuario(login);
        return switch (atributo.toLowerCase()) {
            case "nome" -> usuario.getNome();
            case "senha" -> usuario.getSenha();
            default -> throw new IllegalArgumentException("Atributo inválido.");
        };
    }

    // Obtém um usuário cadastrado.
    // @param login Nome de usuário.
    // @return O objeto Usuario correspondente.
    // @throws IllegalArgumentException Se o usuário não existir.
    private Usuario getUsuario(String login) {
        if (!usuarios.containsKey(login)) {
            throw new IllegalArgumentException("Usuário não cadastrado.");
        }
        return usuarios.get(login);
    }
}