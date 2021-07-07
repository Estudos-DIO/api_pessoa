package dio.API_Pessoa.dto;


import com.sun.istack.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.Valid;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;
import java.util.List;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class PessoaDTO {

    private Long id;

    @NotNull
    @Size( min = 2, max = 50 )
    private String nome;

    @NotNull
    @Size( min = 2, max = 50 )
    private String sobrenome;

    @NotNull
    private String cpf;

    private String dataNascimento;

    @Valid
    @NotEmpty
    private List<TelefoneDTO> telefones;

}
