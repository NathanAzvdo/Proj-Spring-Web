package dev.Java10x.CadastroMaterias.Materia;


import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping
public class MateriaController {

    @GetMapping("/materias/")
    public String PaginaInicial(){
        return "Página matérias";
    }

}
