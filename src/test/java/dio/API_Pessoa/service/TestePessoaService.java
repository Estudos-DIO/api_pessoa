package dio.API_Pessoa.service;

import dio.API_Pessoa.dto.MensagemRespostaDTO;
import dio.API_Pessoa.mapper.PessoaMapper;
import dio.API_Pessoa.repository.PessoaRepository;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
public class TestePessoaService {
    //-----------------------------------------------------------------------------------
    @Mock
    private PessoaRepository repositorioPessoa;

    @Mock
    private PessoaMapper mapperPessoa;

    @InjectMocks
    private PessoaService servicoPessoa;
    //-----------------------------------------------------------------------------------
    /*
    @Test
    void testeDadoPessoaDTOEntaoRetorneMensagemSucesso() {
        PessoaDTO pessoaDTO = PessoaUtils.criarDTO();
        Pessoa entidadePessoaEsperada = PessoaUtils.criarEntidade();

        when(mapperPessoa.toModel(pessoaDTO)).thenReturn(entidadePessoaEsperada);
        when(repositorioPessoa.save(any(Pessoa.class))).thenReturn(entidadePessoaEsperada);

        MensagemRespostaDTO mensagemSucessoEsperada = criarMensagemSucesso(entidadePessoaEsperada.getId());
        RespostaDTO respPessoaDTO = servicoPessoa.criarPessoa(pessoaDTO);

        MensagemRespostaDTO mensagemSucesso = new MensagemRespostaDTO( respPessoaDTO.getMensagem() );

        assertEquals(mensagemSucessoEsperada, mensagemSucesso);
    }
    */
    //-----------------------------------------------------------------------------------
    private MensagemRespostaDTO criarMensagemSucesso(Long idPessoa) {
        return MensagemRespostaDTO.builder()
                .mensagem("> Pessoa de ID <"+ idPessoa +"> criada com sucesso!")
                .build();
    }
    //-----------------------------------------------------------------------------------
}
