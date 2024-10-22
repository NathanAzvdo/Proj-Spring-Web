package dev.Java10x.CadastroMaterias.Models;

import jakarta.persistence.*;

import java.util.Set;

@Entity
@Table(name="tb_professor")
public class ProfessorModel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nome;

    @OneToMany(mappedBy = "professor")
    private Set<MateriaModel> materias;


}
