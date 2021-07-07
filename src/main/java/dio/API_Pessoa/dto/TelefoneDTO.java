package dio.API_Pessoa.dto;

import com.sun.istack.NotNull;
import dio.API_Pessoa.enums.TipoTelefone;
import lombok.*;

import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.validation.constraints.Size;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class TelefoneDTO {

    private Long id;

    @Enumerated(EnumType.STRING)
    private TipoTelefone tipoTelefone;

    @NotNull
    @Size(min=13, max=14)
    private String numero;

}
