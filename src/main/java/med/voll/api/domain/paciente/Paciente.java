package med.voll.api.domain.paciente;

import jakarta.persistence.*;
import lombok.*;
import med.voll.api.domain.endereco.Endereco;

@Table(name="pacientes")
@Entity(name="pacientes")
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Data
@EqualsAndHashCode(of ="id")
public class Paciente {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String nome;
    private String email;
    private String cpf;
    private String telefone ;
    @Embedded
    private Endereco endereco;


}
