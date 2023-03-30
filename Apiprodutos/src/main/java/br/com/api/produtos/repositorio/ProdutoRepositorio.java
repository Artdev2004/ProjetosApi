package br.com.api.produtos.repositorio; // pacote repositorio 
import org.springframework.data.repository.CrudRepository; // importando data crud repository
import org.springframework.stereotype.Repository; // importando anotacao repository
import br.com.api.produtos.modelo.ProdutoModelo; // importando classe produto modelo

@Repository // injecao de dependecias, reconhece como repositorio
public interface ProdutoRepositorio extends CrudRepository<ProdutoModelo, Long> { // herança 
    
}
