package inosystem.climed.climedonboard.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Optional;

@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "especialidades")
public class Especialidade {
    // Getters e Setters
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String tipoEspecialidade;

    @ManyToMany(mappedBy = "especialidades", fetch = FetchType.LAZY)
    @JsonIgnoreProperties("especialidades") // Evita exibir especialidades dentro de médicos
    private List<Medico> medicos;






    // Getters e Setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTipoEspecialidade() {
        return tipoEspecialidade;
    }

    public void setTipoEspecialidade(String tipoEspecialidade) {
        this.tipoEspecialidade = tipoEspecialidade;
    }

    public List<Medico> getMedicos() {
        return medicos;
    }

    public void setMedicos(List<Medico> medicos) {
        this.medicos = medicos;
    }
}

