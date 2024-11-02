package dev.Java10x.CadastroMaterias.Materia;


import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/materias")
public class MateriaController {

    private MateriaService materiaService;

    public MateriaController(MateriaService materiaService){
        this.materiaService = materiaService;
    }

    @GetMapping("/listar")
    public List<MateriaModel> PaginaInicial(){
        return materiaService.listarMaterias();
    }

}
