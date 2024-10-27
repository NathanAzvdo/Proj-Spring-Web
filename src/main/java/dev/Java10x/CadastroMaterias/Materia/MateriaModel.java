package dev.Java10x.CadastroMaterias.Materia;


import dev.Java10x.CadastroMaterias.Inscricao.InscricaoModel;
import dev.Java10x.CadastroMaterias.Professor.ProfessorModel;
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
    private long id;

    @Column(unique = true)
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
