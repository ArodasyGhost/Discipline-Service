package br.ucsal.disciplina_service.dto;

import lombok.Data;

@Data
public class DisciplinaDTO {

    private Long id;
    private String nome;
    private String descricao;
    private String codigo;
    private Integer cargaHoraria;
    private boolean ativa;
    private Long professorId;
}
