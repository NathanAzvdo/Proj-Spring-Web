package dev.Java10x.CadastroMaterias.Materia;

import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class MateriaService {

    private MateriaRepository materiaRepository;
    private MateriaMapper materiaMapper;

    public MateriaService(MateriaRepository materiaRepository, MateriaMapper materiaMapper){
        this.materiaRepository = materiaRepository;
        this.materiaMapper = materiaMapper;
    }

    public List<MateriaDTO> listarMaterias(){
        List<MateriaModel> materias = materiaRepository.findAll();
        return materias.stream().map(materiaMapper::map).collect(Collectors.toList());
    }

    public MateriaDTO listarPorId(Long id){
        Optional<MateriaModel> materia = materiaRepository.findById(id);
        return materia.map(materiaMapper::map).orElse(null);
    }

    public MateriaDTO insertMateria(MateriaDTO materia){
        MateriaModel materiaModel = materiaMapper.map(materia);
        materiaModel = materiaRepository.save(materiaModel);
        return materiaMapper.map(materiaModel);
    }

    public void deletarPorId(Long id){
        materiaRepository.deleteById(id);
    }

    public MateriaDTO atualizarMateria(Long id, MateriaDTO materia){
        Optional<MateriaModel> materiaExists = materiaRepository.findById(id);
        if(materiaExists.isPresent()){
             MateriaModel newMateria = materiaMapper.map(materia);
             newMateria.setId(id);
             MateriaModel materiaSaved = materiaRepository.save(newMateria);
             return materiaMapper.map(materiaSaved);
        }
        return null;
    }


}
