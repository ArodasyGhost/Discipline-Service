package br.ucsal.disciplina_service.model.entity;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Disciplina {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nome;
    private String descricao;
    private String codigo;
    private Integer cargaHoraria;

    private boolean ativa = true;

    // Relacionamento com professor-service (apenas ID)
    private Long professorId;
}
