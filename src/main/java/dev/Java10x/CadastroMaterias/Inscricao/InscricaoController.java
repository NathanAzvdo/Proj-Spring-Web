package dev.Java10x.CadastroMaterias.Inscricao;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/inscricao")
public class InscricaoController {

    private InscricaoService inscricaoService;

    public InscricaoController(InscricaoService inscricaoService){
        this.inscricaoService = inscricaoService;
    }

    @GetMapping("/listarTodos")
    public List<InscricaoModel> listarTodos(){
        return inscricaoService.listarTodos();
    }
}
