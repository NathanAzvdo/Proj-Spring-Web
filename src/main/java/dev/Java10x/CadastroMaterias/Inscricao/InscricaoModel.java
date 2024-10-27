package dev.Java10x.CadastroMaterias.Inscricao;

import dev.Java10x.CadastroMaterias.Aluno.AlunoModel;
import dev.Java10x.CadastroMaterias.Materia.MateriaModel;
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

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
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
