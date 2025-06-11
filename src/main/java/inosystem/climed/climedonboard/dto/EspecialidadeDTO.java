package inosystem.climed.climedonboard.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;


@Data
@NoArgsConstructor
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonDeserialize
public class EspecialidadeDTO<T>
{
    private Long id;
    private String tipoEspecialidade;
    private List<T> medicos;

    // Construtor específico para os valores
    public EspecialidadeDTO(Long id, String tipoEspecialidade) {
        this.id = id;
        this.tipoEspecialidade = tipoEspecialidade;


    }
    // Construtor adicional para deserializar quando só existe "id"
    public EspecialidadeDTO(Long id) {
        this.id = id;
    }
}



