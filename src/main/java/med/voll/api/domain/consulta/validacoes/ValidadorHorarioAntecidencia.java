package med.voll.api.domain.consulta.validacoes;

import med.voll.api.domain.consulta.DadosAgendamento;
import med.voll.api.infra.exception.ValidacaoException;
import org.springframework.stereotype.Component;

import java.time.Duration;
import java.time.LocalDateTime;


@Component
public class ValidadorHorarioAntecidencia implements  ValidadorAgendamentoConsulta {
    public void validar(DadosAgendamento dados){
        LocalDateTime dataConsulta = dados.data();
         LocalDateTime agora = LocalDateTime.now();
        Long  diferencaEmMinutos = Duration.between(agora, dataConsulta).toMinutes();
            if(diferencaEmMinutos < 30){
                throw  new ValidacaoException("Consulta com antecedencia, a consulta necessita de 30 minutos minimos de antecedencia!!!" +
                        "a sua com consulta tem "+ diferencaEmMinutos+ "de antecedencia ");
            }
    }
}
