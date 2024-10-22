package dev.Java10x.CadastroMaterias.Controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping
public class AlunoController {

    @GetMapping("/alunos/")
    public String paginaInicial(){
        return "Página inicial aluno";
    }
}
