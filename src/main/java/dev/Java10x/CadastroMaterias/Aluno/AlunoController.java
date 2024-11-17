package dev.Java10x.CadastroMaterias.Aluno;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/alunos")
public class AlunoController{

    private final AlunoService alunoService;

    public AlunoController(AlunoService alunoService) {
        this.alunoService = alunoService;
    }

    @GetMapping("/listar")
    public ResponseEntity<List<AlunoDTO>> listarAlunos(){
        List<AlunoDTO> alunos =  alunoService.listarAlunos();
        return ResponseEntity.ok().body(alunos);
    }

    @GetMapping("/listar/{id}")
    public ResponseEntity<?> listarAluno(@PathVariable Long id){
        AlunoDTO aluno = alunoService.listarAlunoPorId(id);
        if(aluno!=null){
            return ResponseEntity.ok().body(aluno);
        }
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Aluno não encontrado!");
    }

    @PostMapping("/criar")
    public ResponseEntity<?> criarAluno(@RequestBody AlunoDTO newAluno){
        AlunoDTO aluno = alunoService.insertAluno(newAluno);
        return ResponseEntity.ok().body(aluno);
    }

    @DeleteMapping("/deletar/{id}")
    public ResponseEntity<String> deletar(@PathVariable Long id){
        if(alunoService.listarAlunoPorId(id)!=null){
            alunoService.deletarAlunoId(id);
            return ResponseEntity.ok().body("Aluno deletado com sucesso!");
        }
        return ResponseEntity.ok().body("Aluno não encontrado!");
    }

    @PutMapping("/alterar/{id}")
    public ResponseEntity<?> alterar(@PathVariable Long id, @RequestBody AlunoDTO aluno){
        if(alunoService.listarAlunoPorId(id)!=null){
            AlunoDTO newAluno = alunoService.atualizarPorID(id, aluno);
            return ResponseEntity.ok().body(newAluno);
        }
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Aluno não encontrado!");
    }
}
