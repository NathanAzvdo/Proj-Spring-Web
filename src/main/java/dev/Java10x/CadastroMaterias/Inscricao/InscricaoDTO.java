package dev.Java10x.CadastroMaterias.Inscricao;

import dev.Java10x.CadastroMaterias.Aluno.AlunoModel;
import dev.Java10x.CadastroMaterias.Materia.MateriaModel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@AllArgsConstructor
@NoArgsConstructor
@Data
public class InscricaoDTO {

    private Long id;
    private int faltas;
    private Double n1;
    private Double n2;
    private String status;
    private AlunoModel aluno;
    private MateriaModel materia;

}
