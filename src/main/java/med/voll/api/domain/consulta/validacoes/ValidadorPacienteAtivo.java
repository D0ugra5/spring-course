package med.voll.api.domain.consulta.validacoes;

import med.voll.api.domain.consulta.DadosAgendamento;
import med.voll.api.domain.paciente.PacienteRespository;
import med.voll.api.infra.exception.ValidacaoException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class ValidadorPacienteAtivo  implements ValidadorAgendamentoConsulta{
   @Autowired
    private PacienteRespository pacienteRespository;
    public void validar (DadosAgendamento dados){
        if (dados.idMedico() == null){
            return;
        }

        boolean pacienteEstaAtivo = pacienteRespository.findAtivoById(dados.idPaciente());
        if(!pacienteEstaAtivo){
            throw new ValidacaoException("a consulta não pode ser agendado!!! pois o Pacienteestá" +
                    "Inativo");
        }
    }

}
