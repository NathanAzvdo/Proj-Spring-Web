package dev.Java10x.CadastroMaterias.Professor;

import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class ProfessorService {

    private final ProfessorRepository professorRepository;
    private final ProfessorMapper professorMapper;

    public ProfessorService(ProfessorRepository professorRepository, ProfessorMapper professorMapper){
        this.professorRepository = professorRepository;
        this.professorMapper = professorMapper;
    }

    public List<ProfessorDTO> listarProfessor(){
        List<ProfessorModel> professores = professorRepository.findAll();
        return professores.stream().map(professorMapper::map).collect(Collectors.toList());
    }

    public ProfessorDTO listarPorId(Long id){
        Optional<ProfessorModel> professor = professorRepository.findById(id);
        return professor.map(professorMapper::map).orElse(null);
    }

    public ProfessorDTO insertProfessor(ProfessorDTO professor){
        ProfessorModel professorModel = professorMapper.map(professor);
        professorModel = professorRepository.save(professorModel);
        return professorMapper.map(professorModel);
    }

    public void deletarPorId(Long id){
        professorRepository.deleteById(id);
    }

    public ProfessorDTO atualizarPorId(long id, ProfessorDTO professor){
        if(professorRepository.findById(id).isPresent()){
            ProfessorModel newProfessor = professorMapper.map(professor);
            newProfessor.setId(id);
            ProfessorModel professorSaved = professorRepository.save(newProfessor);
            return professorMapper.map(professorSaved);

        }
        return null;
    }



}
