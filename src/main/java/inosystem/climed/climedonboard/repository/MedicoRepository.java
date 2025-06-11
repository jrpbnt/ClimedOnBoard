package inosystem.climed.climedonboard.repository;


import inosystem.climed.climedonboard.model.Medico;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface MedicoRepository extends JpaRepository<Medico, Long> {
    @Query("SELECT DISTINCT m FROM Medico m LEFT JOIN FETCH m.especialidades")
    List<Medico> findAllWithEspecialidades();
    @Modifying
    @Query(value = "DELETE FROM medico_especialidades WHERE medico_id = :medicoId", nativeQuery = true)
    void deleteEspecialidadesByMedicoId(@Param("medicoId") Long medicoId);

}

