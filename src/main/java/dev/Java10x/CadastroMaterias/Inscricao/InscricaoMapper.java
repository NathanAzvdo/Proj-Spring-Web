package dev.Java10x.CadastroMaterias.Inscricao;

import dev.Java10x.CadastroMaterias.Aluno.AlunoModel;
import org.springframework.stereotype.Component;

@Component
public class InscricaoMapper {

    public InscricaoModel map(InscricaoDTO inscricaoDTO){
        InscricaoModel inscricaoModel = new InscricaoModel();

        inscricaoModel.setId(inscricaoDTO.getId());
        inscricaoModel.setN2(inscricaoDTO.getN2());
        inscricaoModel.setN1(inscricaoDTO.getN1());
        inscricaoModel.setFaltas(inscricaoDTO.getFaltas());
        inscricaoModel.setMateria(inscricaoDTO.getMateria());
        inscricaoModel.setAluno(inscricaoDTO.getAluno());
        inscricaoModel.setStatus(inscricaoDTO.getStatus());

        return inscricaoModel;
    }

    public InscricaoDTO map(InscricaoModel inscricaoModel){
        InscricaoDTO inscricaoDTO = new InscricaoDTO();

        inscricaoDTO.setAluno(inscricaoModel.getAluno());
        inscricaoDTO.setId(inscricaoModel.getId());
        inscricaoDTO.setN1(inscricaoDTO.getN2());
        inscricaoDTO.setN2(inscricaoDTO.getN2());
        inscricaoDTO.setStatus(inscricaoDTO.getStatus());
        inscricaoDTO.setFaltas(inscricaoDTO.getFaltas());
        inscricaoDTO.setMateria(inscricaoDTO.getMateria());

        return inscricaoDTO;
    }

}
