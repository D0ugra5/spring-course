package med.voll.api.mapper;

import med.voll.api.paciente.DadosCadastroPaciente;
import med.voll.api.paciente.Paciente;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring")
public abstract class PacienteMapper {
    public static final PacienteMapper INSTANCE = Mappers.getMapper(PacienteMapper.class);
    public abstract Paciente toPaciente(DadosCadastroPaciente dadosCadastroPaciente);

}
