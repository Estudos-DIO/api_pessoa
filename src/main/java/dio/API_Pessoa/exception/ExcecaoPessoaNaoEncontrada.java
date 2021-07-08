package dio.API_Pessoa.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class ExcecaoPessoaNaoEncontrada extends Exception {
    //-----------------------------------------------------------------------------------
    public ExcecaoPessoaNaoEncontrada(Long idPessoa) {
        super( "> Pessoa de ID <"+ idPessoa +"> não encontrada!" );
    }
    //-----------------------------------------------------------------------------------
}
