package dev.Java10x.CadastroMaterias.Materia;

import dev.Java10x.CadastroMaterias.Inscricao.InscricaoModel;
import dev.Java10x.CadastroMaterias.Professor.ProfessorModel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Set;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class MateriaDTO {

    private long id;
    private String turma;
    private String disciplina;
    private String horario1;
    private String horario2;
    private ProfessorModel professor;
    private Set<InscricaoModel> inscricaoModel;

}
