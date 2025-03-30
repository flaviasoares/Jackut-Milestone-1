package br.ufal.ic.p2.jackut;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

// Classe Usuario que representa um usuário do sistema.
class Usuario {
    private String nome;
    private String login;
    private String senha;

    // Construtor da classe Usuario.
    // @param nome Nome completo.
    // @param login Nome de usuário.
    // @param senha Senha de acesso.
    public Usuario(String nome, String login, String senha) {
        this.nome = nome;
        this.login = login;
        this.senha = senha;
    }

    // Obtém o nome do usuário.
    // @return Nome do usuário.
    public String getNome() {
        return nome;
    }

    // Obtém a senha do usuário.
    // @return Senha do usuário.
    public String getSenha() {
        return senha;
    }
}