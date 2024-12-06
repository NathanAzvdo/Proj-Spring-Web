package dev.Java10x.CadastroMaterias.Professor;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/professor")
public class ProfessorController {

    private final ProfessorService professorService;

    public ProfessorController(ProfessorService professorService) {
        this.professorService = professorService;
    }

    @Operation(summary = "Listar todos os professores")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Lista de professores retornada com sucesso",
                    content = @Content(mediaType = "application/json", schema = @Schema(implementation = ProfessorDTO.class)))
    })
    @GetMapping("/listar")
    public List<ProfessorDTO> listarTodos() {
        return professorService.listarProfessor();
    }

    @Operation(summary = "Listar um professor pelo ID")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Professor encontrado",
                    content = @Content(mediaType = "application/json", schema = @Schema(implementation = ProfessorDTO.class))),
            @ApiResponse(responseCode = "404", description = "Professor não encontrado",
                    content = @Content)
    })
    @GetMapping("/listar/{id}")
    public ResponseEntity<ProfessorDTO> listarPorId(@PathVariable Long id) {
        ProfessorDTO professor = professorService.listarPorId(id);
        if (professor != null) {
            return ResponseEntity.ok().body(professor);
        }
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
    }

    @Operation(summary = "Criar um novo professor")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "201", description = "Professor criado com sucesso",
                    content = @Content(mediaType = "application/json", schema = @Schema(implementation = ProfessorDTO.class)))
    })
    @PostMapping("/criar")
    public ResponseEntity<ProfessorDTO> insertProfessor(@RequestBody ProfessorDTO professor) {
        ProfessorDTO newProfessor = professorService.insertProfessor(professor);
        return ResponseEntity.status(HttpStatus.CREATED).body(newProfessor);
    }

    @Operation(summary = "Deletar um professor pelo ID")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Professor deletado com sucesso"),
            @ApiResponse(responseCode = "404", description = "Professor não encontrado",
                    content = @Content)
    })
    @DeleteMapping("/deletar/{id}")
    public ResponseEntity<String> deletarProfessorPorId(@PathVariable Long id) {
        if (professorService.listarPorId(id) != null) {
            professorService.deletarPorId(id);
            return ResponseEntity.ok().body("Deletado com sucesso");
        }
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Professor não encontrado!");
    }

    @Operation(summary = "Atualizar um professor pelo ID")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Professor atualizado com sucesso",
                    content = @Content(mediaType = "application/json", schema = @Schema(implementation = ProfessorDTO.class))),
            @ApiResponse(responseCode = "404", description = "Professor não encontrado",
                    content = @Content)
    })
    @PutMapping("/alterar/{id}")
    public ResponseEntity<?> atualizarProfessor(@PathVariable Long id, @RequestBody ProfessorDTO newProfessor) {
        if (professorService.listarPorId(id) != null) {
            ProfessorDTO professorSaved = professorService.atualizarPorId(id, newProfessor);
            return ResponseEntity.ok().body(professorSaved);
        }
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Professor não encontrado!");
    }
}
