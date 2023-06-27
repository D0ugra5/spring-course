package med.voll.api.mapper;

import med.voll.api.domain.paciente.DadosCadastroPaciente;
import med.voll.api.domain.paciente.Paciente;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring")
public abstract class PacienteMapper {
    public static final PacienteMapper INSTANCE = Mappers.getMapper(PacienteMapper.class);

    @Mapping(target = "id", ignore = true)
    @Mapping(target = "ativo", ignore = true)
    public abstract Paciente toPaciente(DadosCadastroPaciente dadosCadastroPaciente);

}
