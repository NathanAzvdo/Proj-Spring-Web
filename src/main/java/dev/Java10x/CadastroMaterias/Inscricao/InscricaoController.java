package dev.Java10x.CadastroMaterias.Inscricao;

import org.apache.coyote.Response;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/inscricao")
public class InscricaoController {

    private final InscricaoService inscricaoService;

    public InscricaoController(InscricaoService inscricaoService){
        this.inscricaoService = inscricaoService;
    }

    @GetMapping("/listarTodos")
    public ResponseEntity<List<?>> listarTodos(){
        List<InscricaoDTO> inscricoes = inscricaoService.listarTodos();
        return ResponseEntity.ok().body(inscricoes);
    }

    @GetMapping("/listar/{id}")
    public ResponseEntity<?> listarPorId(@PathVariable Long id){
        InscricaoDTO inscricao = inscricaoService.listarPorId(id);
        if(inscricao!=null){
            return ResponseEntity.ok().body(inscricao);
        }
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
    }

    @PostMapping("/criar")
    public ResponseEntity<InscricaoDTO> insertInscricao(@RequestBody InscricaoDTO inscricaoDTO){
        InscricaoDTO newInscricao = inscricaoService.insertInscricao(inscricaoDTO);
        return ResponseEntity.status(HttpStatus.CREATED).body(newInscricao);
    }

    @PutMapping("/alterar/{id}")
    public ResponseEntity<?> alterarporId(@PathVariable Long id, @RequestBody InscricaoDTO inscricao){
        if(inscricaoService.listarPorId(id)!=null){
            InscricaoDTO newInscricao = inscricaoService.atualizarInscricao(id, inscricao);
            return ResponseEntity.ok().body(newInscricao);
        }
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Inscrição não encontrada!");
    }

    @DeleteMapping("/deletar/{id}")
    public ResponseEntity<String> deletarPorId(@PathVariable Long id){
        if(inscricaoService.listarPorId(id)!=null){
            inscricaoService.deletarPorid(id);
            ResponseEntity.ok().body("Deletado com sucesso!");
        }
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Inscrição não encontrada!");
    }
}
