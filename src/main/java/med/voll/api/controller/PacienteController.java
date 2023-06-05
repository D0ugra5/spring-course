package med.voll.api.controller;

import jakarta.validation.Valid;
import med.voll.api.mapper.PacienteMapper;
import med.voll.api.paciente.DadosCadastroPaciente;
import med.voll.api.paciente.DadosDetalhamentoPaciente;
import med.voll.api.paciente.Paciente;
import med.voll.api.paciente.PacienteRespository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import java.net.URI;

@RestController
@RequestMapping("pacientes")
public class PacienteController {
    @Autowired
    private PacienteRespository repository;
    @PostMapping
    @Transactional
    public ResponseEntity cadastroDePaciente(@RequestBody @Valid DadosCadastroPaciente dados, UriComponentsBuilder uriComponentsBuilder){
        Paciente paciente = PacienteMapper.INSTANCE.toPaciente(dados);

        URI uri = uriComponentsBuilder.path("/pacientes/{id}").buildAndExpand(paciente.getId()).toUri();
        repository.save(paciente);

        return ResponseEntity.created(uri).body(new DadosDetalhamentoPaciente(paciente));

    }

    @GetMapping
    public Page<DadosListaPaciente> listPaciente(Pageable paginacao){

        return repository.findAll(paginacao).map(DadosListaPaciente::new);
    }

}
