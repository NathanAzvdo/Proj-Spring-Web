package dev.Java10x.CadastroMaterias.Professor;


import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/professor")
public class ProfessorController{

    private ProfessorService professorService;

    public ProfessorController(ProfessorService professorService){
        this.professorService = professorService;
    }

    @GetMapping("/listarProfessores")
    public List<ProfessorModel> listarTodos(){
        return professorService.listarProfessores();
    }



}
