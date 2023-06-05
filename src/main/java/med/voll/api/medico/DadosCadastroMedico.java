package med.voll.api.medico;

import jakarta.validation.Valid;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import med.voll.api.endereco.DadosEndereco;
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

        @DefaultValue(value = "true")
        boolean ativo


){


}
