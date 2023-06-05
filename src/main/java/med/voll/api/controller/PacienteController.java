package med.voll.api.controller;

import jakarta.validation.Valid;
import med.voll.api.mapper.PacienteMapper;
import med.voll.api.paciente.DadosCadastroPaciente;
import med.voll.api.paciente.PacienteRespository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("pacientes")
public class PacienteController {
    @Autowired
    private PacienteRespository repository;
    @PostMapping
    @Transactional
    public void cadastroDePaciente(@RequestBody @Valid DadosCadastroPaciente dados){
        repository.save(PacienteMapper.INSTANCE.toPaciente(dados));

    }

    @GetMapping
    public Page<DadosListaPaciente> listPaciente(Pageable paginacao){

        return repository.findAll(paginacao).map(DadosListaPaciente::new);
    }

}
