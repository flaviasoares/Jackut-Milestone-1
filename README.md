# System Design Report

## Introdução
O sistema desenvolvido tem como objetivo gerenciar usuários através de uma estrutura simples de autenticação. O design foca na modularidade e na segurança básica de armazenamento de credenciais.

## Estrutura e Design
O sistema segue o padrão de **Facade**, encapsulando a lógica principal em uma única classe chamada `Facade`. Essa abordagem facilita o uso da API e isola a lógica interna de gerenciamento de usuários.

### Componentes Principais
#### 1. **Facade**
- Responsável por gerenciar o ciclo de vida dos usuários.
- Oferece métodos para criação, autenticação e recuperação de dados.
- Mantém um dicionário de usuários para acesso rápido.

#### 2. **Usuario**
- Representa um usuário do sistema.
- Armazena nome, login e senha.
- Permite acesso controlado aos atributos do usuário.

## Decisões de Design
1. **Uso de HashMap:** Escolhemos essa estrutura para permitir busca eficiente por login.
2. **Encapsulamento:** A classe `Facade` oculta os detalhes de implementação, tornando o código mais modular.
3. **Validação de Entrada:** Métodos lançam exceções para prevenir estados inválidos.
4. **Isolamento da Autenticação:** A senha é acessível apenas dentro do escopo necessário.

## Diagrama de Classes
Abaixo está um diagrama representando a estrutura do sistema:

```mermaid
title Diagrama de Classes
classDiagram
    class Facade {
        - Map usuarios
        - usuarioLogado
        + criarUsuario()
        + abrirSessao()
        + getAtributoUsuario()
    }
    class Usuario {
        - nome
        - login
        - senha
        + getNome()
        + getSenha()
    }
    Facade --> Usuario
```

Esse diagrama ilustra a relação entre a `Facade` e os objetos `Usuario`.

## Conclusão
O design proposto garante um gerenciamento simples e eficaz de usuários, com foco na segurança e modularidade. Para futuras melhorias, poderíamos integrar um banco de dados para persistência e implementar uma criptografia para as senhas armazenadas.