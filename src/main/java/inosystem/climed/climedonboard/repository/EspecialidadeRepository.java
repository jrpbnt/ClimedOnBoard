package inosystem.climed.climedonboard.repository;

import inosystem.climed.climedonboard.model.Especialidade;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface EspecialidadeRepository extends JpaRepository<Especialidade, Long> {
    @Query("SELECT e FROM Especialidade e LEFT JOIN FETCH e.medicos WHERE e.id = :id")
    Optional<Especialidade> findByIdWithMedicos(@Param("id") Long id);
}


