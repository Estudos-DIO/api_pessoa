package dio.API_Pessoa.service;

import dio.API_Pessoa.dto.MensagemRespostaDTO;
import dio.API_Pessoa.dto.PessoaDTO;
import dio.API_Pessoa.dto.RespostaDTO;
import dio.API_Pessoa.entity.Pessoa;
import dio.API_Pessoa.mapper.PessoaMapper;
import dio.API_Pessoa.repository.PessoaRepository;
import dio.API_Pessoa.utils.PessoaUtils;
import org.junit.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.any;
import static org.mockito.Mockito.when;

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
    @Test
    public void testeDadoPessoaDTOEntaoRetorneMensagemSucesso() {
        PessoaDTO pessoaDTO = PessoaUtils.criarDTO();
        Pessoa entidadePessoaEsperada = PessoaUtils.criarEntidade();

        when(mapperPessoa.toModel(pessoaDTO)).thenReturn(entidadePessoaEsperada);
        when(repositorioPessoa.save(any(Pessoa.class))).thenReturn(entidadePessoaEsperada);

        MensagemRespostaDTO mensagemSucessoEsperada = criarMensagemSucesso(entidadePessoaEsperada.getId());
        RespostaDTO respPessoaDTO = servicoPessoa.criarPessoa(pessoaDTO);

        MensagemRespostaDTO mensagemSucesso = new MensagemRespostaDTO( respPessoaDTO.getMensagem() );

        assertEquals(mensagemSucessoEsperada, mensagemSucesso);
    }
    //-----------------------------------------------------------------------------------
    private MensagemRespostaDTO criarMensagemSucesso(Long idPessoa) {
        return MensagemRespostaDTO.builder()
                .mensagem("> Pessoa de ID <"+ idPessoa +"> criada com sucesso!")
                .build();
    }
    //-----------------------------------------------------------------------------------
}
