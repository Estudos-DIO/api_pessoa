package dio.API_Pessoa.utils;

import dio.API_Pessoa.dto.TelefoneDTO;
import dio.API_Pessoa.entity.Telefone;
import dio.API_Pessoa.enums.TipoTelefone;

public class TelefoneUtils {
    //-----------------------------------------------------------------------------------
    private static final String NUMERO_TELEFONE = "0122222-3333";
    private static final TipoTelefone TIPO_TELEFONE = TipoTelefone.CELULAR;
    private static final long PHONE_ID = 1L;
    //-----------------------------------------------------------------------------------
    public static TelefoneDTO criarDTO() {
        return TelefoneDTO.builder()
                .numero(NUMERO_TELEFONE)
                .tipoTelefone(TIPO_TELEFONE)
                .build();
    }
    //-----------------------------------------------------------------------------------
    public static Telefone criarEntidade() {
        return Telefone.builder()
                .id(PHONE_ID)
                .numero(NUMERO_TELEFONE)
                .tipoTelefone(TIPO_TELEFONE)
                .build();
    }
    //-----------------------------------------------------------------------------------
}
