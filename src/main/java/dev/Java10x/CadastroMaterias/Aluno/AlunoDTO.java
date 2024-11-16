package dev.Java10x.CadastroMaterias.Aluno;

import dev.Java10x.CadastroMaterias.Inscricao.InscricaoModel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Set;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class AlunoDTO {

    private Long id;
    private String nome;
    private String matricula;
    private Set<InscricaoModel> inscricaoModel;

}
