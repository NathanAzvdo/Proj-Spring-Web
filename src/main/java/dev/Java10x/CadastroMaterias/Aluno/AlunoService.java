package dev.Java10x.CadastroMaterias.Aluno;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AlunoService {

    @Autowired
    private AlunoRepository alunoRepository;

    public List<AlunoModel> listarAlunos(){
        return alunoRepository.findAll();
    }
}
