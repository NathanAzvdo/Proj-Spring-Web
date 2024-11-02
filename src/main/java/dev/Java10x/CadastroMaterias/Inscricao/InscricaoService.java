package dev.Java10x.CadastroMaterias.Inscricao;

import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class InscricaoService {
    private InscricaoRepository inscricaoRepository;

    public InscricaoService(InscricaoRepository inscricaoRepository){
        this.inscricaoRepository =  inscricaoRepository;
    }

    public List<InscricaoModel> listarTodos(){
        return inscricaoRepository.findAll();
    }

}
