package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam; // <-- ADICIONE ESTA LINHA
import org.springframework.web.bind.annotation.RestController;
import java.util.List;

@RestController
public class HelloController {

    @Autowired
    private UsuarioRepository repository; // "Injeta" a ponte para o banco

    @GetMapping("/hello")
    public String hello() {
        return "Seu app Spring está rodando e conectado!";
    }

    @GetMapping("/criar")
    public String criarDinamico(@RequestParam String nome, @RequestParam String email) {
        Usuario novo = new Usuario();
        novo.setNome(nome);
        novo.setEmail(email);

        repository.save(novo);

        return "Sucesso! O usuário " + nome + " foi salvo com o e-mail " + email;
    }

    @GetMapping("/listar")
    public List<Usuario> listar() {
        return repository.findAll(); // BUSCA TUDO DO BANCO!
    }
    @GetMapping("/deletar")
    public String deletar(@RequestParam Long id) {
        if (repository.existsById(id)) {
            repository.deleteById(id);
            return "Usuário com ID " + id + " foi removido com sucesso!";
        }
        return "Erro: Usuário com ID " + id + " não encontrado.";
    }
}