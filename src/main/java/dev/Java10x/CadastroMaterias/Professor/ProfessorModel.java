package dev.Java10x.CadastroMaterias.Professor;

import dev.Java10x.CadastroMaterias.Materia.MateriaModel;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Set;

@Entity
@Table(name="tb_professor")
@AllArgsConstructor
@NoArgsConstructor
@Data
public class ProfessorModel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nome;

    @OneToMany(mappedBy = "professor")
    private Set<MateriaModel> materias;


}
