package dev.Java10x.CadastroMaterias.Models;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name="tb_incricao")
@NoArgsConstructor
@AllArgsConstructor
@Data
public class InscricaoModel {

    private Long id;
    private int faltas;
    private Double n1;
    private Double n2;
    private String status;

    @ManyToOne
    @JoinColumn(name="aluno_id")
    private AlunoModel aluno;

    @ManyToOne
    @JoinColumn(name="materia_id")
    private MateriaModel materia;

}
