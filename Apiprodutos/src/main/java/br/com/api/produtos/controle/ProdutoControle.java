package br.com.api.produtos.controle;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import br.com.api.produtos.modelo.ProdutoModelo;
import br.com.api.produtos.modelo.RespostaModelo;
import br.com.api.produtos.servico.ProdutoServico;

@RestController // 
@CrossOrigin(origins = "*") // libera api para qualquer porta acessar
public class ProdutoControle{

    @Autowired
    private ProdutoServico ps;

    @PostMapping("/cadastrar")
    public ResponseEntity<?> cadastrar(@RequestBody ProdutoModelo pm ){
        return ps.cadastrarAlterar(pm, "cadastrar");  
    }
    
    @PutMapping("/alterar")
    public ResponseEntity<?> alterar(@RequestBody ProdutoModelo pm){
        return ps.cadastrarAlterar(pm, "alterar");

    }

    @GetMapping("/listar")
    public Iterable<ProdutoModelo> listar(){// Iterable é uma interface que fornece um método que lista de forma não ordenada elementos de um indice
        return ps.listar();
        
    }
    @DeleteMapping("/deletar/{codigo}")
    public ResponseEntity<RespostaModelo> deletar(@PathVariable long codigo){
        return ps.deletar(codigo);
    }

    @GetMapping("/")// tipo de requisição que usará para exibir essa mensagem
    public String rota(){
        return "Api funfando";
    }
}