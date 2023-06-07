package med.voll.api.domain.medico;

import jakarta.validation.Valid;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import med.voll.api.domain.endereco.DadosEndereco;

public record DadosCadastroMedico(

        @NotBlank
        String nome,
        @NotBlank
        @Email
        String email,
        @NotBlank

        String crm,
        @NotBlank
        String telefone,

        @NotNull
        Especialidade especialidade,

       @NotNull @Valid DadosEndereco endereco,
        boolean ativo


){
        public DadosCadastroMedico(@NotBlank
                                   String nome, @NotBlank
                                   @Email
                                   String email, @NotBlank

                                   String crm, @NotBlank
                                   String telefone, @NotNull
                                   Especialidade especialidade, @NotNull @Valid DadosEndereco endereco, boolean ativo) {
                this.ativo = true;
                this.nome = nome;
                this.email = email;
                this.crm = crm;
                this.telefone = telefone;
                this.especialidade = especialidade;
                this.endereco = endereco;
        }

}
