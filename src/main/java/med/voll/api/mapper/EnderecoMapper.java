package med.voll.api.mapper;

import med.voll.api.domain.endereco.DadosEndereco;
import med.voll.api.domain.endereco.Endereco;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring")
public abstract class EnderecoMapper {
    public static final  EnderecoMapper INSTANCE = Mappers.getMapper(EnderecoMapper.class);
    public abstract DadosEndereco toEndereco(Endereco endereco);

}
