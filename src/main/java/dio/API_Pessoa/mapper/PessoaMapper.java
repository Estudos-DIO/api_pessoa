package dio.API_Pessoa.mapper;

import dio.API_Pessoa.dto.PessoaDTO;
import dio.API_Pessoa.entity.Pessoa;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface PessoaMapper {

    @Mapping(target = "dataNascimento", source = "dataNascimento", dateFormat = "dd-MM-yyyy")
    Pessoa toModel(PessoaDTO dto);

    PessoaDTO toDTO(Pessoa dto);

}
