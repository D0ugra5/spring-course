package med.voll.api.domain.consulta.validacoes;

import med.voll.api.domain.consulta.DadosAgendamento;
import med.voll.api.infra.exception.ValidacaoException;
import org.springframework.stereotype.Component;

import java.time.DayOfWeek;
import java.time.LocalDateTime;
@Component
public class ValidadorHorarioFuncionamenoClinica implements ValidadorAgendamentoConsulta{

    public void validar(DadosAgendamento dados){
        LocalDateTime dataConsulta = dados.data();

        boolean domingo = dataConsulta.getDayOfWeek().equals(DayOfWeek.SUNDAY);
        boolean antesDaAberturaDaClinica = dataConsulta.getHour() < 7 ;
        boolean deopisDoEncerramentoDaClinica= dataConsulta.getHour()>18;

        if(domingo || antesDaAberturaDaClinica || deopisDoEncerramentoDaClinica){
            throw new ValidacaoException("Consulta fora do horario de funcionamento da clinica");
        }
    }
}
