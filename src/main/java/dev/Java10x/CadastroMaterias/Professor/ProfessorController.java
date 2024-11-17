package dev.Java10x.CadastroMaterias.Professor;


import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/professor")
public class ProfessorController{

    private final ProfessorService professorService;

    public ProfessorController(ProfessorService professorService){
        this.professorService = professorService;
    }

    @GetMapping("/listar")
    public List<ProfessorDTO> listarTodos(){
        return professorService.listarProfessor();
    }

    @GetMapping("/listar/{id}")
    public ResponseEntity<ProfessorDTO> listarPorId(@PathVariable Long id){
        ProfessorDTO professor = professorService.listarPorId(id);
        if(professor!=null){
            return ResponseEntity.ok().body(professor);
        }
        return null;
    }

    @PostMapping("/criar")
    public ResponseEntity<ProfessorDTO> insertProfessor(ProfessorDTO professor){
        ProfessorDTO newProfessor = professorService.insertProfessor(professor);
        return ResponseEntity.status(HttpStatus.CREATED).body(newProfessor);
    }

    @DeleteMapping("/deletar/{id}")
    public ResponseEntity<String> deletarProfessorPorId(@PathVariable Long id){
        if(professorService.listarPorId(id)!=null){
            professorService.deletarPorId(id);
            return ResponseEntity.ok().body("Deletado com sucesso");
        }
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Professor não encontrado!");
    }

    @PutMapping("/alterar/{id}")
    public ResponseEntity<?> atualizarProfessor(@PathVariable Long id, @RequestBody ProfessorDTO newProfessor){
        if(professorService.listarPorId(id)!=null){
            ProfessorDTO professorSaved = professorService.atualizarPorId(id, newProfessor);
            return ResponseEntity.ok().body(professorSaved);
        }
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Professor não encontrado!");
    }



}
