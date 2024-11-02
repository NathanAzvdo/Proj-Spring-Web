package dev.Java10x.CadastroMaterias.Professor;

import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProfessorService {

    private ProfessorRepository professorRepository;

    public ProfessorService(ProfessorRepository professorRepository){
        this.professorRepository = professorRepository;
    }

    public List<ProfessorModel> listarProfessores(){
        return professorRepository.findAll();
    }
}
