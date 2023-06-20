package med.voll.api.domain.consulta.validacoes;

import med.voll.api.domain.consulta.DadosAgendamento;
import med.voll.api.domain.medico.MedicoRepository;
import med.voll.api.infra.exception.ValidacaoException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class ValidadorMedicoAtivo implements ValidadorAgendamentoConsulta {
    @Autowired
    private MedicoRepository repository;
    public void validar (DadosAgendamento dados){
        if (dados.idMedico() == null){
            return;
        }

        boolean medicoEstaAtivo = repository.findAtivoById(dados.idMedico());
        if(!medicoEstaAtivo){
            throw new ValidacaoException("a consulta não pode ser agendado!!! pois o medico está" +
                    "Inativo");
        }
    }


}
