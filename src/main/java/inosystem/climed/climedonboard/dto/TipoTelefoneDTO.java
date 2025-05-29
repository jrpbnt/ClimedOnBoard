package inosystem.climed.climedonboard.dto;

public class TipoTelefoneDTO {
    private Long telt_id;       // ou tipo do seu ID
    private String tipo;   // Exemplo: "Celular", "Fixo", etc.


    public Long gettelt_id() {
        return telt_id;
    }
    public void settelt_id(Long id) {
        this.telt_id = telt_id;
    }
    public String getTipo() {
        return tipo;
    }
    public void setTipo(String tipo) {
        this.tipo = tipo;
    }
}