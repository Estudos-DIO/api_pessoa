package dio.API_Pessoa.service;

import dio.API_Pessoa.dto.PessoaDTO;
import dio.API_Pessoa.dto.RespostaDTO;
import dio.API_Pessoa.entity.Pessoa;
import dio.API_Pessoa.mapper.PessoaMapper;
import dio.API_Pessoa.repository.PessoaRepository;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor(onConstructor = @__(@Autowired))
public class PessoaService {
    //-----------------------------------------------------------------------------------
    @Autowired
    private PessoaRepository repositorioPessoa;

    @Autowired
    private PessoaMapper pessoaMapper;
    //-----------------------------------------------------------------------------------
    public RespostaDTO criarPessoa(PessoaDTO pessoaDTO)
    {
        Pessoa pessoa =  pessoaMapper.toModel( pessoaDTO );

        Pessoa novaPessoa = repositorioPessoa.save( pessoa );

        return RespostaDTO
                .builder()
                .mensagem( "> Pessoa com ID <"+ novaPessoa.getId() +"> criada!" )
                .build();
    }
    //-----------------------------------------------------------------------------------
    public List<PessoaDTO> listarTodasPessoas() {

        List<Pessoa> lstPessoas = repositorioPessoa.findAll();

        List<PessoaDTO> lstPessoasDTO = lstPessoas
                                            .stream()
                                            .map( pessoaMapper::toDTO )
                                            .collect(Collectors.toList() );

        return lstPessoasDTO;
    }
    //-----------------------------------------------------------------------------------

}
