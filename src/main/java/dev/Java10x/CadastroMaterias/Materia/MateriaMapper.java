package dev.Java10x.CadastroMaterias.Materia;


import org.springframework.stereotype.Component;

@Component
public class MateriaMapper {

    MateriaDTO map(MateriaModel materiaModel){
        MateriaDTO materiaDTO = new MateriaDTO();

        materiaDTO.setId(materiaDTO.getId());
        materiaDTO.setHorario1(materiaDTO.getHorario1());
        materiaDTO.setHorario2(materiaDTO.getHorario2());
        materiaDTO.setTurma(materiaDTO.getTurma());
        materiaDTO.setProfessor(materiaDTO.getProfessor());
        materiaDTO.setDisciplina(materiaDTO.getDisciplina());
        materiaDTO.setInscricaoModel(materiaDTO.getInscricaoModel());

        return materiaDTO;
    }

    public MateriaModel map(MateriaDTO materiaDTO){
        MateriaModel materiaModel = new MateriaModel();

        materiaModel.setId(materiaDTO.getId());
        materiaModel.setHorario1(materiaDTO.getHorario1());
        materiaModel.setHorario2(materiaDTO.getHorario2());
        materiaModel.setTurma(materiaDTO.getTurma());
        materiaModel.setProfessor(materiaDTO.getProfessor());
        materiaDTO.setDisciplina(materiaDTO.getDisciplina());
        materiaDTO.setInscricaoModel(materiaModel.getInscricaoModel());

        return materiaModel;
    }

}
