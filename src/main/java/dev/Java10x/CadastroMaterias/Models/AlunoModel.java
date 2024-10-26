package dev.Java10x.CadastroMaterias.Models;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Set;

@Entity
@Table(name="tb_aluno")
@NoArgsConstructor
@AllArgsConstructor
@Data
public class AlunoModel {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String nome;
    private String matricula;


    @OneToMany(mappedBy = "aluno")
    private Set<InscricaoModel> inscricaoModel;

}
