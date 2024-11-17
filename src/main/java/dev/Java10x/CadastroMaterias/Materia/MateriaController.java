package dev.Java10x.CadastroMaterias.Materia;


import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/materias")
public class MateriaController {

    private final MateriaService materiaService;

    public MateriaController(MateriaService materiaService){
        this.materiaService = materiaService;
    }

    @GetMapping("/listar")
    public ResponseEntity<List<?>> listar(){
        List<MateriaDTO> materias = materiaService.listarMaterias();
        return ResponseEntity.ok().body(materias);
    }

    @GetMapping("/listar/{id}")
    public ResponseEntity<?> listarPorId(@PathVariable Long id){
        MateriaDTO materia = materiaService.listarPorId(id);
        if(materia!=null){
            return ResponseEntity.ok().body(materia);
        }
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
    }

    @PostMapping("/criar")
    public ResponseEntity<MateriaDTO> insertMateria(@RequestBody MateriaDTO materia){
        MateriaDTO materiaNew = materiaService.insertMateria(materia);
        return ResponseEntity.status(HttpStatus.CREATED).body(materiaNew);
    }

    @DeleteMapping("/deletar/{id}")
    public ResponseEntity<String> deletar(@PathVariable Long id){
        if(materiaService.listarPorId(id)!=null){
            materiaService.deletarPorId(id);
            return ResponseEntity.ok().body("Matéria excluida com sucesso");
        }
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Matéria não encontrada");

    }

    @PutMapping("/alterar/{id}")
    public ResponseEntity<?> alterarPorID(@PathVariable Long id, @RequestBody MateriaDTO materia){
        if(materiaService.listarPorId(id)!=null){
            MateriaDTO newMateria = materiaService.atualizarMateria(id, materia);
            return ResponseEntity.ok().body(newMateria);
        }
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
    }




}
