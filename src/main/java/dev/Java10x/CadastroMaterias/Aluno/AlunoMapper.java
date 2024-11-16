package dev.Java10x.CadastroMaterias.Aluno;

import org.springframework.stereotype.Component;

@Component
public class AlunoMapper {

    public AlunoModel map(AlunoDTO alunoDTO){
        AlunoModel alunoModel = new AlunoModel();
        alunoModel.setId(alunoDTO.getId());
        alunoModel.setInscricaoModel(alunoDTO.getInscricaoModel());
        alunoModel.setNome(alunoDTO.getNome());
        alunoModel.setMatricula(alunoDTO.getMatricula());

        return alunoModel;
    }

    public AlunoDTO map(AlunoModel alunoModel){
        AlunoDTO alunoDTO = new AlunoDTO();
        alunoDTO.setId(alunoModel.getId());
        alunoDTO.setMatricula(alunoModel.getMatricula());
        alunoDTO.setNome(alunoModel.getNome());
        alunoDTO.setInscricaoModel(alunoModel.getInscricaoModel());

        return alunoDTO;
    }

}
