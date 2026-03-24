package com.example.demo.service;

import com.example.demo.models.TarefaModel;
import com.example.demo.repositories.TarefaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TarefaService {

    @Autowired
    private TarefaRepository tarefaRepository;

    public Optional<TarefaModel> findById(Long id) {
        return tarefaRepository.findById(id);
    }

    public List<TarefaModel> findAll() {
        return tarefaRepository.findAll();
    }

    public void deleteById(Long id) {
        tarefaRepository.deleteById(id);
    }

    public TarefaModel criarLivro(TarefaModel tarefaModel) {
        return tarefaRepository.save(tarefaModel);
    }
}
