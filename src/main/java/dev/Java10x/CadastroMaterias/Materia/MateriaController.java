package dev.Java10x.CadastroMaterias.Materia;

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
@RequestMapping("/materias")
public class MateriaController {

    private final MateriaService materiaService;

    public MateriaController(MateriaService materiaService) {
        this.materiaService = materiaService;
    }

    @Operation(summary = "Listar todas as matérias")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Lista de matérias retornada com sucesso",
                    content = @Content(mediaType = "application/json", schema = @Schema(implementation = MateriaDTO.class)))
    })
    @GetMapping("/listar")
    public ResponseEntity<List<?>> listar() {
        List<MateriaDTO> materias = materiaService.listarMaterias();
        return ResponseEntity.ok().body(materias);
    }

    @Operation(summary = "Listar uma matéria pelo ID")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Matéria encontrada",
                    content = @Content(mediaType = "application/json", schema = @Schema(implementation = MateriaDTO.class))),
            @ApiResponse(responseCode = "404", description = "Matéria não encontrada",
                    content = @Content)
    })
    @GetMapping("/listar/{id}")
    public ResponseEntity<?> listarPorId(@PathVariable Long id) {
        MateriaDTO materia = materiaService.listarPorId(id);
        if (materia != null) {
            return ResponseEntity.ok().body(materia);
        }
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
    }

    @Operation(summary = "Criar uma nova matéria")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "201", description = "Matéria criada com sucesso",
                    content = @Content(mediaType = "application/json", schema = @Schema(implementation = MateriaDTO.class)))
    })
    @PostMapping("/criar")
    public ResponseEntity<MateriaDTO> insertMateria(@RequestBody MateriaDTO materia) {
        MateriaDTO materiaNew = materiaService.insertMateria(materia);
        return ResponseEntity.status(HttpStatus.CREATED).body(materiaNew);
    }

    @Operation(summary = "Deletar uma matéria pelo ID")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Matéria deletada com sucesso"),
            @ApiResponse(responseCode = "404", description = "Matéria não encontrada",
                    content = @Content)
    })
    @DeleteMapping("/deletar/{id}")
    public ResponseEntity<String> deletar(@PathVariable Long id) {
        if (materiaService.listarPorId(id) != null) {
            materiaService.deletarPorId(id);
            return ResponseEntity.ok().body("Matéria excluída com sucesso");
        }
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Matéria não encontrada");
    }

    @Operation(summary = "Atualizar uma matéria pelo ID")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Matéria atualizada com sucesso",
                    content = @Content(mediaType = "application/json", schema = @Schema(implementation = MateriaDTO.class))),
            @ApiResponse(responseCode = "404", description = "Matéria não encontrada",
                    content = @Content)
    })
    @PutMapping("/alterar/{id}")
    public ResponseEntity<?> alterarPorID(@PathVariable Long id, @RequestBody MateriaDTO materia) {
        if (materiaService.listarPorId(id) != null) {
            MateriaDTO newMateria = materiaService.atualizarMateria(id, materia);
            return ResponseEntity.ok().body(newMateria);
        }
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
    }
}
