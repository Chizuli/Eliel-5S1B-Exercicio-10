package com.example.demo.controller;

import com.example.demo.models.TarefaModel;
import com.example.demo.service.TarefaService;
import jakarta.persistence.Entity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(path = "/tarefa")
public class TarefaController {

    @Autowired
    private TarefaService tarefaService;

    @GetMapping
    public List<TarefaModel> findAll() {
        return tarefaService.findAll();
    }

    @GetMapping("/{id}")
    public Optional<TarefaModel> findById(@PathVariable Long id) {
        return tarefaService.findById(id);
    }

    @DeleteMapping
    public void deleteById(@RequestParam Long id) {
        tarefaService.deleteById(id);
    }

    @PostMapping
    public ResponseEntity<TarefaModel> criarTarefa(@RequestBody TarefaModel tarefaModel){
        TarefaModel request = tarefaService.criarTarefa(tarefaModel);
        URI uri = ServletUriComponentsBuilder.fromCurrentRequestUri().path("/{id}").buildAndExpand(tarefaModel.getId()).toUri();
        return  ResponseEntity.created(uri).body(request);
    }
}
