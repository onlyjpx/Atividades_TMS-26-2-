package com.atividades;

public class Usuario {
    private String nome;
    private String email;

    public Usuario(String nome, String email) {
        setNome(nome);
        setEmail(email);
    }

    public String getNome() { return nome; }
    public String getEmail() { return email; }

    public void setNome(String nome) {
        if(nome == null || nome.isBlank()){
            throw new IllegalArgumentException("Nomes não podem ser vazios");
        }
        if(!nome.matches("\\p{L}+( \\p{L}+)*")){
            throw new IllegalArgumentException("Nome Invalido");
        }

        this.nome = nome;
    }

    public void setEmail(String email) {
        if(email == null || email.isBlank()){
            throw new IllegalArgumentException("Email não pode ser vazio");
        }

        if(!email.matches("[A-Za-z0-9._]+@[A-Za-z0-9.]+")){
            throw new IllegalArgumentException("Email Invalido");
        }

        this.email = email;
    }


}
