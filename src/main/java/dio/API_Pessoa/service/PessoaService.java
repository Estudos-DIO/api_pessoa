package dio.API_Pessoa.service;

import dio.API_Pessoa.dto.RespostaDTO;
import dio.API_Pessoa.entity.Pessoa;
import dio.API_Pessoa.repository.PessoaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PessoaService {

    @Autowired
    private PessoaRepository repositorioPessoa;

    public RespostaDTO criarPessoa(Pessoa pessoa)
    {
        Pessoa novaPessoa = repositorioPessoa.save( pessoa );

        return RespostaDTO
                .builder()
                .mensagem( "> Pessoa com ID<"+ novaPessoa.getId() +"> criada!" )
                .build();
    }

}
