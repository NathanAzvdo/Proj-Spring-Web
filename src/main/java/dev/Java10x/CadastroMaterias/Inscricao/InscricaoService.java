package dev.Java10x.CadastroMaterias.Inscricao;

import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class InscricaoService {

    private InscricaoRepository inscricaoRepository;
    private InscricaoMapper inscricaoMapper;

    public InscricaoService(InscricaoRepository inscricaoRepository, InscricaoMapper inscricaoMapper){
        this.inscricaoRepository =  inscricaoRepository;
        this.inscricaoMapper = inscricaoMapper;
    }

    public List<InscricaoDTO> listarTodos(){
        List<InscricaoModel> inscricao = inscricaoRepository.findAll();
        return inscricao.stream().map(inscricaoMapper::map).collect(Collectors.toList());
    }

    public InscricaoDTO listarPorId(Long id){
        Optional<InscricaoModel> inscricao = inscricaoRepository.findById(id);
        return inscricao.map(inscricaoMapper::map).orElse(null);
    }

    public InscricaoDTO insertInscricao(InscricaoDTO inscricaoDTO){
        InscricaoModel inscricaoModel = inscricaoMapper.map(inscricaoDTO);
        inscricaoModel = inscricaoRepository.save(inscricaoModel);
        return inscricaoMapper.map(inscricaoModel);
    }

    public void deletarPorid(Long id){
        inscricaoRepository.deleteById(id);
    }

    public InscricaoDTO atualizarInscricao(Long id, InscricaoDTO inscricao){
        Optional<InscricaoModel> inscricaoExists = inscricaoRepository.findById(id);
        if(inscricaoExists.isPresent()){
            InscricaoModel newInscricao = inscricaoMapper.map(inscricao);
            newInscricao.setId(id);
            InscricaoModel inscricaoSalva = inscricaoRepository.save(newInscricao);
            return inscricaoMapper.map(inscricaoSalva);
        }
        return null;
    }

}
