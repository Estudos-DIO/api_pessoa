package dio.API_Pessoa.mapper;

import dio.API_Pessoa.dto.PessoaDTO;
import dio.API_Pessoa.dto.TelefoneDTO;
import dio.API_Pessoa.entity.Pessoa;
import dio.API_Pessoa.entity.Telefone;
import dio.API_Pessoa.utils.PessoaUtils;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
public class TestePessoaMapper {
    //-----------------------------------------------------------------------------------
    @Autowired
    private PessoaMapper pessoaMapper;
    //-----------------------------------------------------------------------------------
    @Test
    void testarPessoaDTOERetornarEntidadePessoa() {
        PessoaDTO pessoaDTO = PessoaUtils.criarDTO();
        Pessoa pessoa = pessoaMapper.toModel(pessoaDTO);

        assertEquals(pessoaDTO.getNome(), pessoa.getNome());
        assertEquals(pessoaDTO.getSobrenome(), pessoa.getSobrenome());
        assertEquals(pessoaDTO.getCpf(), pessoa.getCpf());

        Telefone telefone = pessoa.getTelefones().get(0);
        TelefoneDTO telefoneDTO = pessoaDTO.getTelefones().get(0);

        assertEquals(telefoneDTO.getTipoTelefone(), telefone.getTipoTelefone());
        assertEquals(telefoneDTO.getNumero(), telefone.getNumero());
    }
    //-----------------------------------------------------------------------------------
    @Test
    void testarEntidadePessoaERetornarPessoaDTO() {
        Pessoa pessoa = PessoaUtils.criarEntidade();
        PessoaDTO pessoaDTO = pessoaMapper.toDTO(pessoa);

        assertEquals(pessoa.getNome(), pessoaDTO.getNome());
        assertEquals(pessoa.getSobrenome(), pessoaDTO.getSobrenome());
        assertEquals(pessoa.getCpf(), pessoaDTO.getCpf());

        Telefone telefone = pessoa.getTelefones().get(0);
        TelefoneDTO telefoneDTO = pessoaDTO.getTelefones().get(0);

        assertEquals(telefone.getTipoTelefone(), telefoneDTO.getTipoTelefone());
        assertEquals(telefone.getNumero(), telefoneDTO.getNumero());
    }
    //-----------------------------------------------------------------------------------
}
