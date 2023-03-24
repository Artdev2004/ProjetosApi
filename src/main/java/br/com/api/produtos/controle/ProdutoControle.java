package br.com.api.produtos.controle;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.api.produtos.modelo.ProdutoModelo;
import br.com.api.produtos.servico.ProdutoServico;

@RestController
public class ProdutoControle{
    @Autowired
    private ProdutoServico ps;

    @GetMapping("/listar")
    public Iterable<ProdutoModelo> listar(){// Iterable é uma interface que fornece um método que lista de forma não ordenada elementos de um indice
        return ps.listar();
        
    }

    @GetMapping("/")// tipo de requisição que usará para exibir essa mensagem
    public String rota(){
        return "Api funfando";
    }
}