package inosystem.climed.climedonboard.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor // Gera um construtor sem argumentos
@AllArgsConstructor

public class TipoEmailDTO {
    private Long tipoe_id;       // ou tipo do seu ID
    private String tipo;   // Exemplo: "Pessoal", "Trabalho", etc.

    public TipoEmailDTO(Long tipoeId) {
    }

    public Long gettipoe_id() {
        return tipoe_id;
    }
    public void settipoe_id(Long id) {
        this.tipoe_id = id;
    }
    public String getTipo() {
        return tipo;
    }
    public void setTipo(String tipo) {
        this.tipo = tipo;
    }
}