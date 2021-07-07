package dio.API_Pessoa.service;

import dio.API_Pessoa.dto.PessoaDTO;
import dio.API_Pessoa.dto.RespostaDTO;
import dio.API_Pessoa.entity.Pessoa;
import dio.API_Pessoa.mapper.PessoaMapper;
import dio.API_Pessoa.repository.PessoaRepository;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor(onConstructor = @__(@Autowired))
public class PessoaService {

    @Autowired
    private PessoaRepository repositorioPessoa;

    @Autowired
    private PessoaMapper pessoaMapper;

    public RespostaDTO criarPessoa(PessoaDTO pessoaDTO)
    {
        Pessoa pessoa =  pessoaMapper.toModel( pessoaDTO );

        Pessoa novaPessoa = repositorioPessoa.save( pessoa );

        return RespostaDTO
                .builder()
                .mensagem( "> Pessoa com ID <"+ novaPessoa.getId() +"> criada!" )
                .build();
    }

}
