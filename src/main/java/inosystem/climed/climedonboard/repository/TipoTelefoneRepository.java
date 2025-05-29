package inosystem.climed.climedonboard.repository;

import inosystem.climed.climedonboard.model.TipoTelefone;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface TipoTelefoneRepository extends JpaRepository<TipoTelefone, Long> {
    Optional<TipoTelefone> findByTipo(String tipo);
}