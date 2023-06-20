package med.voll.api.domain.consulta.validacoes;

import med.voll.api.domain.consulta.ConsultaRepository;
import med.voll.api.domain.consulta.DadosAgendamento;
import med.voll.api.domain.paciente.PacienteRespository;
import med.voll.api.infra.exception.ValidacaoException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
@Component
public class ValidadorPacienteSemOutraConsultaNoDia implements ValidadorAgendamentoConsulta{
    @Autowired
    private ConsultaRepository respository;
    public void validar (DadosAgendamento dados){
        LocalDateTime primeiroHorario = dados.data().withHour(7);
        LocalDateTime ultimoHorario = dados.data().withHour(18);
        boolean pacientePossuiOutraConsultaNoMesmoHorario = respository.existsByPacienteIdAndDataBetween(dados.idMedico(),primeiroHorario,ultimoHorario);
        if(pacientePossuiOutraConsultaNoMesmoHorario){
            throw new ValidacaoException("Paciente Já Possui Outra Consuta agendada nesse horário");
        }

    }
}
