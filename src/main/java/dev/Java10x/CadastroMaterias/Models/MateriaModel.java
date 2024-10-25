package dev.Java10x.CadastroMaterias.Models;


import jakarta.persistence.*;

import java.util.Set;
import java.util.UUID;

@Entity
@Table(name="tb_materias")
public class MateriaModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private UUID id;
    private String turma;
    private String disciplina;
    private String horario1;
    private String horario2;

    @ManyToOne
    @JoinColumn(name="professor_id")
    private ProfessorModel professor;

    @OneToMany(mappedBy = "materia")
    private Set<InscricaoModel> inscricaoModel;

    public MateriaModel(){

    }

    public MateriaModel(String turma, String disciplina, String horario1, String horario2){
        this.turma = turma;
        this.disciplina = disciplina;
        this.horario1 = horario1;
        this.horario2 = horario2;
    }

    public int getId(){
        return id;
    }

    public String getTurma() {
        return turma;
    }

    public String getDisciplina() {
        return disciplina;
    }

    public String getHorario1() {
        return horario1;
    }

    public String getHorario2() {
        return horario2;
    }

}
