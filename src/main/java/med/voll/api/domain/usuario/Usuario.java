package med.voll.api.domain.usuario;

import jakarta.persistence.*;
import lombok.*;

@Table(name="usuario")
@Entity(name="Usuario")
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@EqualsAndHashCode(of ="id")
public class Usuario {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String login;
    private String senha;
}
