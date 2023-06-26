package med.voll.api.domain.consulta;

import med.voll.api.domain.consulta.validacoes.ValidadorAgendamentoConsulta;
import med.voll.api.infra.exception.ValidacaoException;
import med.voll.api.domain.medico.Medico;
import med.voll.api.domain.medico.MedicoRepository;
import med.voll.api.domain.paciente.Paciente;
import med.voll.api.domain.paciente.PacienteRespository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AgendaDeConsulta {
    @Autowired
    private ConsultaRepository consultaRepository;
    @Autowired
    private MedicoRepository medicoRepository;
    @Autowired
    private PacienteRespository pacienteRespository;

    @Autowired
    private List<ValidadorAgendamentoConsulta> validadores ;
    public DadosDetaLhamentoConsulta agendar(DadosAgendamento dados){

        if(!pacienteRespository.existsById(dados.idPaciente())){
            throw new ValidacaoException("ID do paciente informado não existe");
        }

        if(dados.idMedico() != null && !medicoRepository.existsById(dados.idMedico())){
            throw new ValidacaoException("ID do medico informado não existe");
        }

        validadores.forEach(v -> v.validar(dados));
        Paciente paciente = pacienteRespository.getReferenceById(dados.idPaciente());


        Medico medico = escolherMedicos(dados);

        if(medico == null){
            throw new ValidacaoException("Não existe medico disponivel nessa data !");
        }
        Consulta consulta = new Consulta(null,medico,paciente,dados.data());
        consultaRepository.save(consulta);

        return new DadosDetaLhamentoConsulta(consulta);

    }

    private Medico escolherMedicos(DadosAgendamento dados) {
        if(dados.idMedico() != null){
        return  medicoRepository.getReferenceById(dados.idMedico());
        }

        if(dados.especialidade() == null){
            throw new ValidacaoException("Especialidade é obrigatorio");
        }
        return medicoRepository.escolherMedicoAleatorioLivreNaData(dados.especialidade(),dados.data());

    }
}
