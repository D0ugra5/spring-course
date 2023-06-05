package med.voll.api.controller;

import med.voll.api.paciente.Paciente;

public record DadosListaPaciente(String nome, String email, String cpf) {

    public DadosListaPaciente(Paciente paciente){
        this(paciente.getNome(), paciente.getEmail(), paciente.getCpf());
    }
}
