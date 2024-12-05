package br.com.livrinhodavovo.api.models;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Entity
public class Receitas implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nomeReceita;

    private String receita;

    private String obsReceita;

    private String categoria; // Coluna saborizacao, já existente

    private Double custoProducao; // Novo campo para custo de produção

    @ManyToOne
    @JoinColumn(name = "pessoa_id")
    @JsonBackReference
    private Pessoa pessoa;  // Cada receita pode ser associada a uma pessoa
}
