package br.ucsal.disciplina_service.controller;

import br.ucsal.disciplina_service.dto.DisciplinaDTO;
import br.ucsal.disciplina_service.model.service.DisciplinaService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/disciplinas")
@RequiredArgsConstructor
public class DisciplinaController {

    private final DisciplinaService service;

    @PostMapping
    public DisciplinaDTO criar(@RequestBody DisciplinaDTO dto) {
        return service.criar(dto);
    }

    @GetMapping
    public List<DisciplinaDTO> listar() {
        return service.listar();
    }

    @GetMapping("/{id}")
    public DisciplinaDTO buscar(@PathVariable Long id) {
        return service.buscar(id);
    }

    @PutMapping("/{id}")
    public DisciplinaDTO atualizar(@PathVariable Long id, @RequestBody DisciplinaDTO dto) {
        return service.atualizar(id, dto);
    }

    @DeleteMapping("/{id}")
    public void excluir(@PathVariable Long id) {
        service.excluir(id);
    }
}
