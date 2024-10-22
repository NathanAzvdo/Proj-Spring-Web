package dev.Java10x.CadastroMaterias.Models;

import jakarta.persistence.*;

@Entity
@Table(name="tb_incricao")
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

    public Long getId(){
        return id;
    }

    public int getFaltas(){
        return faltas;
    }

    public Double getN1(){
        return n1;
    }
    public Double getN2(){
        return n2;
    }
    public String status(){
        return status;
    }


}
