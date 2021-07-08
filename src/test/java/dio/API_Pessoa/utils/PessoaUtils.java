package dio.API_Pessoa.utils;

import dio.API_Pessoa.dto.PessoaDTO;
import dio.API_Pessoa.entity.Pessoa;

import java.time.LocalDate;
import java.util.Collections;

public class PessoaUtils {
    //-----------------------------------------------------------------------------------
    private static final String NOME = "Joao";
    private static final String SOBRENOME = "Da Silva";
    private static final String CPF = "123.333.444-00";
    private static final long ID_PESSOA = 1L;
    public static final LocalDate DATA_NASCIMENTO = LocalDate.of(1987, 03, 03);
    //-----------------------------------------------------------------------------------
    public static PessoaDTO criarDTO() {
        return PessoaDTO.builder()
                .nome(NOME)
                .sobrenome(SOBRENOME)
                .cpf(CPF)
                .dataNascimento("03-03-1987")
                .telefones(Collections.singletonList(TelefoneUtils.criarDTO()))
                .build();
    }
    //-----------------------------------------------------------------------------------
    public static Pessoa criarEntidade() {
        return Pessoa.builder()
                .id(ID_PESSOA)
                .nome(NOME)
                .sobrenome(SOBRENOME)
                .cpf(CPF)
                .dataNascimento(DATA_NASCIMENTO)
                .telefones(Collections.singletonList(TelefoneUtils.criarEntidade()))
                .build();
    }
    //-----------------------------------------------------------------------------------
}
