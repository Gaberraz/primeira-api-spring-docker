package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import java.util.List;

@RestController
public class HelloController {

    @Autowired
    private UsuarioRepository repository;

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
        return repository.findAll();
    }

    // UPDATE: Atualiza o e-mail de um ID existente
    @GetMapping("/atualizar")
    public String atualizar(@RequestParam Long id, @RequestParam String novoEmail) {
        return repository.findById(id).map(usuario -> {
            usuario.setEmail(novoEmail);
            repository.save(usuario);
            return "Sucesso! O usuário " + usuario.getNome() + " agora tem o e-mail: " + novoEmail;
        }).orElse("Erro: Usuário com ID " + id + " não encontrado.");
    }

    // DELETE REFINADO: Com tratamento de erro caso o ID não exista
    @GetMapping("/deletar")
    public String deletar(@RequestParam Long id) {
        if (repository.existsById(id)) {
            repository.deleteById(id);
            return "Usuário com ID " + id + " removido com sucesso!";
        }
        return "Erro: Não foi possível deletar. O ID " + id + " não existe no banco.";
    }
}