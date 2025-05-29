package inosystem.climed.climedonboard.repository;

import inosystem.climed.climedonboard.model.Contato;
import inosystem.climed.climedonboard.model.Paciente;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ContatoRepository extends JpaRepository<Contato, Long> {
    List<Contato> findByPaciente(Paciente paciente);
    void deleteByPaciente(Paciente paciente);
}