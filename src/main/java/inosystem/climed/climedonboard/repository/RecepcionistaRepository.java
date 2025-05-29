package inosystem.climed.climedonboard.repository;


import inosystem.climed.climedonboard.model.Recepcionista;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RecepcionistaRepository extends JpaRepository<Recepcionista, Long> {
}