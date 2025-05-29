package inosystem.climed.climedonboard.dto;

public class TipoEmailDTO {
    private Long tipoe_id;       // ou tipo do seu ID
    private String tipo;   // Exemplo: "Pessoal", "Trabalho", etc.

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