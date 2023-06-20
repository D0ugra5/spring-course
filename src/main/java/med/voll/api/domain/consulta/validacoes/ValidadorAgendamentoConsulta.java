package med.voll.api.domain.consulta.validacoes;

import med.voll.api.domain.consulta.DadosAgendamento;

public interface ValidadorAgendamentoConsulta {
    void validar(DadosAgendamento dados);
}
