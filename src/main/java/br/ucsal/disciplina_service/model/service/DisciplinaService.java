package br.ucsal.disciplina_service.model.service;

import br.ucsal.disciplina_service.dto.DisciplinaDTO;
import br.ucsal.disciplina_service.exception.NotFoundException;
import br.ucsal.disciplina_service.model.entity.Disciplina;
import br.ucsal.disciplina_service.model.repository.DisciplinaRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class DisciplinaService {

    private final DisciplinaRepository repo;

    public DisciplinaDTO criar(DisciplinaDTO dto) {
        Disciplina disciplina = toEntity(dto);
        repo.save(disciplina);
        return toDTO(disciplina);
    }

    public List<DisciplinaDTO> listar() {
        return repo.findAll().stream().map(this::toDTO).toList();
    }

    public DisciplinaDTO buscar(Long id) {
        Disciplina disciplina = repo.findById(id)
                .orElseThrow(() -> new NotFoundException("Disciplina não encontrada"));
        return toDTO(disciplina);
    }

    public DisciplinaDTO atualizar(Long id, DisciplinaDTO dto) {
        Disciplina disciplina = repo.findById(id)
                .orElseThrow(() -> new NotFoundException("Disciplina não encontrada"));

        disciplina.setNome(dto.getNome());
        disciplina.setDescricao(dto.getDescricao());
        disciplina.setCodigo(dto.getCodigo());
        disciplina.setCargaHoraria(dto.getCargaHoraria());
        disciplina.setAtiva(dto.isAtiva());
        disciplina.setProfessorId(dto.getProfessorId());

        repo.save(disciplina);
        return toDTO(disciplina);
    }

    public void excluir(Long id) {
        repo.deleteById(id);
    }

    // ---------------------------
    // Conversões
    // ---------------------------

    private DisciplinaDTO toDTO(Disciplina d) {
        DisciplinaDTO dto = new DisciplinaDTO();
        dto.setId(d.getId());
        dto.setNome(d.getNome());
        dto.setDescricao(d.getDescricao());
        dto.setCodigo(d.getCodigo());
        dto.setCargaHoraria(d.getCargaHoraria());
        dto.setAtiva(d.isAtiva());
        dto.setProfessorId(d.getProfessorId());
        return dto;
    }

    private Disciplina toEntity(DisciplinaDTO dto) {
        Disciplina d = new Disciplina();
        d.setNome(dto.getNome());
        d.setDescricao(dto.getDescricao());
        d.setCodigo(dto.getCodigo());
        d.setCargaHoraria(dto.getCargaHoraria());
        d.setAtiva(dto.isAtiva());
        d.setProfessorId(dto.getProfessorId());
        return d;
    }
}
