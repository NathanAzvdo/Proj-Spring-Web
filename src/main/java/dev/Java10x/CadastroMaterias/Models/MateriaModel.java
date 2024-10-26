package dev.Java10x.CadastroMaterias.Models;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Set;
import java.util.UUID;

@Entity
@Table(name="tb_materias")
@NoArgsConstructor
@AllArgsConstructor
@Data
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

}
