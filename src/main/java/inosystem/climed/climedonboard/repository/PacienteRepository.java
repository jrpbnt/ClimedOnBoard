package inosystem.climed.climedonboard.repository;

import inosystem.climed.climedonboard.model.Paciente;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PacienteRepository extends JpaRepository<Paciente, Long> {
}