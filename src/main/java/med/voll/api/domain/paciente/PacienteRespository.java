package med.voll.api.domain.paciente;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.time.LocalDateTime;

public interface PacienteRespository extends JpaRepository<Paciente, Long> {
    @Query("""
            SELECT m.ativo
            FROM pacientes m
            WHERE
            m.id = :id
            """)
    Boolean findAtivoById(Long id);



}
