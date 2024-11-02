package dev.Java10x.CadastroMaterias.Materia;

import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MateriaService {

    private MateriaRepository materiaRepository;

    public MateriaService(MateriaRepository materiaRepository){
        this.materiaRepository = materiaRepository;
    }

    public List<MateriaModel> listarMaterias(){
        return materiaRepository.findAll();
    }
}
