package com.example.demo;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity // Isso diz ao Spring: "Crie uma tabela chamada 'usuario' no MySQL"
public class Usuario {

    @Id // Define que este campo é a Chave Primária
    @GeneratedValue(strategy = GenerationType.IDENTITY) // O banco gera o ID sozinho (1, 2, 3...)
    private Long id;

    private String nome;
    private String email;

    // Getters e Setters (Necessários para o Spring acessar os dados)
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public String getNome() { return nome; }
    public void setNome(String nome) { this.nome = nome; }

    public String getEmail() { return email; }
    public void setEmail(String email) { this.email = email; }
}