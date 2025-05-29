package inosystem.climed.climedonboard.repository;

import inosystem.climed.climedonboard.model.TipoEmail;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface TipoEmailRepository extends JpaRepository<TipoEmail, Long> {
    Optional<TipoEmail> findByTipo(String tipo);
}
