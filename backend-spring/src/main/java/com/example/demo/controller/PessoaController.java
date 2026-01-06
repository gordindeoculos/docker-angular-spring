package com.example.demo.controller;

import com.example.demo.model.Pessoa;
import com.example.demo.repository.PessoaRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/pessoas")
@RequiredArgsConstructor
@CrossOrigin(origins = "*")
public class PessoaController {

    private final PessoaRepository repository;

    @GetMapping("/teste")
    public String teste() {
        return "Spring Boot funcionando dentro do Docker!";
    }

    @GetMapping
    public List<Pessoa> listar() {
        return repository.findAll();
    }

    @PostMapping
    public Pessoa criar(@RequestBody Pessoa pessoa) {
        return repository.save(pessoa);
    }

    @GetMapping("/{id}")
    public Pessoa buscar(@PathVariable Long id) {
        return repository.findById(id).orElse(null);
    }

    @PutMapping("/{id}")
    public Pessoa atualizar(@PathVariable Long id, @RequestBody Pessoa dados) {
        Pessoa pessoa = repository.findById(id).orElse(null);
        if (pessoa == null)
            return null;

        pessoa.setNome(dados.getNome());
        pessoa.setEmail(dados.getEmail());
        return repository.save(pessoa);
    }

    @DeleteMapping("/{id}")
    public void deletar(@PathVariable Long id) {
        repository.deleteById(id);
    }
}
