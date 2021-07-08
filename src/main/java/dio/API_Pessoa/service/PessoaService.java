package dio.API_Pessoa.service;

import dio.API_Pessoa.dto.MensagemRespostaDTO;
import dio.API_Pessoa.dto.PessoaDTO;
import dio.API_Pessoa.dto.RespostaDTO;
import dio.API_Pessoa.entity.Pessoa;
import dio.API_Pessoa.exception.ExcecaoPessoaNaoEncontrada;
import dio.API_Pessoa.mapper.PessoaMapper;
import dio.API_Pessoa.repository.PessoaRepository;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor(onConstructor = @__(@Autowired))
public class PessoaService {
    //-----------------------------------------------------------------------------------
    private final PessoaRepository repositorioPessoa;
    private final PessoaMapper pessoaMapper;
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
    public PessoaDTO pesquisarPorID(Long idPessoa) throws ExcecaoPessoaNaoEncontrada {

        /*
        Optional<Pessoa> pessoa = repositorioPessoa.findById( idPessoa );

        if( pessoa.isEmpty() ) {
            throw new ExcecaoPessoaNaoEncontrada( idPessoa );
        }

        PessoaDTO pessoaDTO = pessoaMapper.toDTO( pessoa.get() );
        */

        Pessoa pessoa = verificarSePessoaExiste(idPessoa);

        PessoaDTO pessoaDTO = pessoaMapper.toDTO( pessoa );

        return pessoaDTO;
    }
    //-----------------------------------------------------------------------------------
    private Pessoa verificarSePessoaExiste(Long idPessoa) throws ExcecaoPessoaNaoEncontrada {
        return repositorioPessoa.findById(idPessoa)
                .orElseThrow(() -> new ExcecaoPessoaNaoEncontrada(idPessoa));
    }

    //-----------------------------------------------------------------------------------
    public void removerDadoPessoaPorID(Long idPessoa) throws ExcecaoPessoaNaoEncontrada {
        Pessoa pessoa = verificarSePessoaExiste(idPessoa);
        repositorioPessoa.deleteById( pessoa.getId() );
    }
    //-----------------------------------------------------------------------------------
    public MensagemRespostaDTO atualizarPessoaPorID(Long idPessoa, PessoaDTO pessoaDTO) throws ExcecaoPessoaNaoEncontrada {

        verificarSePessoaExiste( idPessoa );

        Pessoa dadoPessoa = pessoaMapper.toModel( pessoaDTO );
        Pessoa novaPessoa = repositorioPessoa.save( dadoPessoa );

        return MensagemRespostaDTO
                    .builder()
                    .mensagem( "> Pessoa de ID <" + novaPessoa.getId() +"> atualizada!" )
                    .build();
    }
    //-----------------------------------------------------------------------------------

}
