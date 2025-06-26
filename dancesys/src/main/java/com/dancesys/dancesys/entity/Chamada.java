package com.dancesys.dancesys.entity;

import com.dancesys.dancesys.entity.IdsCompostos.ChamadaId;
import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "Chamada")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Chamada {

    @EmbeddedId
    private ChamadaId id;

    @ManyToOne
    @MapsId("idAulaOcorrencia")
    @JoinColumn(name = "id_Aula_Ocorrencia", nullable = false)
    @JsonIgnore
    private AulaOcorrencia idAulaOcorrencia;

    @ManyToOne
    @MapsId("idAluno")
    @JoinColumn(name = "id_Aluno", nullable = false)
    private Aluno idAluno;

    @Column(name = "presenca")
    private Integer presenca;
    public static final Integer presente = 1;
    public static final Integer faltante = 0;
}
