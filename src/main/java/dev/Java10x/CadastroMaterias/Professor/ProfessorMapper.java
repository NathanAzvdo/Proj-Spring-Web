package dev.Java10x.CadastroMaterias.Professor;

import org.springframework.stereotype.Component;

@Component
public class ProfessorMapper {

    public ProfessorDTO map(ProfessorModel professorModel){
        ProfessorDTO professorDTO = new ProfessorDTO();
        professorDTO.setNome(professorDTO.getNome());
        professorDTO.setId(professorDTO.getId());
        professorDTO.setMaterias(professorDTO.getMaterias());

        return professorDTO;
    }

    public ProfessorModel map(ProfessorDTO professorDTO){
        ProfessorModel professorModel = new ProfessorModel();

        professorModel.setId(professorDTO.getId());
        professorModel.setMaterias(professorDTO.getMaterias());
        professorModel.setNome(professorDTO.getNome());

        return professorModel;
    }
}
