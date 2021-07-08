package dio.API_Pessoa.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
@AllArgsConstructor
public class MensagemRespostaDTO {

    private String mensagem;

}
