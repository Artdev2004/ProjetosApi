package br.com.api.produtos.servico;
import org.apache.coyote.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import br.com.api.produtos.modelo.ProdutoModelo;
import br.com.api.produtos.modelo.RespostaModelo;
import br.com.api.produtos.repositorio.ProdutoRepositorio;


@Service // injecao de dependencias 
public class ProdutoServico{
    @Autowired // acesso a ações sql do repository
    private ProdutoRepositorio pr;

    @Autowired 
    private RespostaModelo rm;

    // Metodo para cadastrar Produtos
    public ResponseEntity<?>cadastrar(ProdutoModelo pm){

        if(pm.getNome().equals("")){
            rm.setMensagem("O nome do produto é obrigatório!");
            return new ResponseEntity<RespostaModelo>(rm, HttpStatus.BAD_REQUEST);

         }else if(pm.getMarca().equals("")){
            rm.setMensagem("O nome da marca é obrigatório");
            return new ResponseEntity<RespostaModelo>(rm, HttpStatus.BAD_REQUEST);
         }else{
            return new ResponseEntity<ProdutoModelo>(pr.save(pm), HttpStatus.CREATED);
         }
    }


    
    // Metodo para listar todos os produtos
    public Iterable<ProdutoModelo> listar(){ // 
        return pr.findAll();
        
    }
}