package br.com.api.produtos.modelo;
// Usada quando se tem um problemas com requisições(c.r.u.d)

import org.springframework.stereotype.Component;

import lombok.Getter;
import lombok.Setter;

@Component // injecao de dependencias , spring cria objetos relacionados aquela classe
@Getter // lombok
@Setter // lombok
public class RespostaModelo { // mostra uma resposta explicita sobre o erro da api
    private String mensagem;
}
