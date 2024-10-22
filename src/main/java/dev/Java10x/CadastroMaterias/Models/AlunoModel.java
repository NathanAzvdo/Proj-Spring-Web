package dev.Java10x.CadastroMaterias.Models;

import jakarta.persistence.*;

import java.util.Set;

@Entity
@Table(name="tb_aluno")
public class AlunoModel {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String nome;
    private String matricula;

    public AlunoModel(){

    }

    @OneToMany(mappedBy = "aluno")
    private Set<InscricaoModel> inscricaoModel;

    public AlunoModel(String nome, String matricula){
        this.nome = nome;
        this.matricula = matricula;
    }

    public Long getId(){
        return id;
    }
    public String getNome(){
        return nome;
    }
    public String getMatricula(){
        return matricula;
    }
}
