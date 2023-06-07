package med.voll.api.medico;

import jakarta.validation.Valid;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import lombok.Builder;
import med.voll.api.endereco.DadosEndereco;
import med.voll.api.endereco.Endereco;
import med.voll.api.mapper.EnderecoMapper;
import org.springframework.boot.context.properties.bind.DefaultValue;

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
