package inosystem.climed.climedonboard.dto;




public class TipoTelefoneDTO {
    private Long telt_id; // ou tipo do seu ID
    private String tipo; // Exemplo: "Celular", "Fixo", etc.

    public void setTelt_id(Long telt_id) {
        this.telt_id = telt_id;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public String getTipo() {
        return tipo;
    }

    public Long getTelt_id() {
        return telt_id;
    }
}