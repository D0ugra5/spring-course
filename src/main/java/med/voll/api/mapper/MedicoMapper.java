package med.voll.api.mapper;

import med.voll.api.domain.medico.DadosCadastroMedico;
import med.voll.api.domain.medico.Medico;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring")
public abstract class MedicoMapper {
    public static final  MedicoMapper INSTANCE = Mappers.getMapper(MedicoMapper.class);

    @Mapping(target = "id", ignore = true)

    public abstract Medico toMedico( DadosCadastroMedico dadosCadastroMedico);



}
