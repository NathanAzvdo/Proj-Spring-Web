package dev.Java10x.CadastroMaterias.Aluno;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class AlunoService {

    private AlunoRepository alunoRepository;
    private AlunoMapper alunoMapper;

    public AlunoService(AlunoRepository alunoRepository, AlunoMapper alunoMapper){
        this.alunoRepository = alunoRepository;
        this.alunoMapper = alunoMapper;
    }

    public List<AlunoDTO> listarAlunos(){
        List<AlunoModel> alunos = alunoRepository.findAll();
        return alunos.stream().map(alunoMapper::map).collect(Collectors.toList());
    }

    public AlunoDTO listarAlunoPorId(Long id){
        Optional<AlunoModel> alunoModel = alunoRepository.findById(id);
        return alunoModel.map(alunoMapper::map).orElse(null);
    }

    public AlunoDTO insertAluno(AlunoDTO aluno){
        AlunoModel alunoModel = alunoMapper.map(aluno);
        alunoModel = alunoRepository.save(alunoModel);
        return alunoMapper.map(alunoModel);
    }

    public void deletarAlunoId(Long id){
        alunoRepository.deleteById(id);
    }

    public AlunoDTO atualizarPorID(Long id, AlunoDTO alunoDTO){
        Optional<AlunoModel> alunoExists = alunoRepository.findById(id);
        if(alunoExists.isPresent()){
            AlunoModel newAluno = alunoMapper.map(alunoDTO);
            newAluno.setId(id);
            AlunoModel alunoSaved = alunoRepository.save(newAluno);
            return alunoMapper.map(alunoSaved);
        }
        return null;
    }

}
