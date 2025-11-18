package br.ucsal.disciplina_service.model.repository;

import br.ucsal.disciplina_service.model.entity.Disciplina;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DisciplinaRepository extends JpaRepository<Disciplina, Long> {
}
