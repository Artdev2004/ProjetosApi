package br.com.api.produtos.modelo;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

// entidade no banco  de dados e nome da tabela
@Entity
@Table(name = "produtos")
@Getter
@Setter
public class ProdutoModelo {

    @Id // chave primária 
    @GeneratedValue(strategy = GenerationType.IDENTITY) //auto incremento
    private Long codigo;
    private String nome;
    private String marca;

}
