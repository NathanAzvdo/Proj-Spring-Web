package dev.Java10x.CadastroMaterias.Professor;

import dev.Java10x.CadastroMaterias.Materia.MateriaModel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


import java.util.Set;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ProfessorDTO {

    private Long id;
    private String nome;
    private Set<MateriaModel> materias;

}
