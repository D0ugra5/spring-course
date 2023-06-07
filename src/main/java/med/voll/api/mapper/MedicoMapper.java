package med.voll.api.mapper;

import med.voll.api.medico.DadosCadastroMedico;
import med.voll.api.medico.Medico;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring")
public abstract class MedicoMapper {
    public static final  MedicoMapper INSTANCE = Mappers.getMapper(MedicoMapper.class);

    public abstract Medico toMedico( DadosCadastroMedico dadosCadastroMedico);



}
