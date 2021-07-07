package dio.API_Pessoa.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum TipoTelefone {

    RESIDENCIAL("Residencial"),
    CELULAR("Celular"),
    COMMERCIAL("Commercial");

    private final String description;
}
