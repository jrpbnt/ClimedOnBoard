package inosystem.climed.climedonboard.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ContatoDTO {
    private Long contId;
    private String telefone;
    private TipoTelefoneDTO tipoTelefone;
    private String email;
    private TipoEmailDTO tipoEmail;

    public Long getContId() {
        return contId;
    }

    public void setContId(Long contId) {
        this.contId = contId;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public TipoTelefoneDTO getTipoTelefone() {
        return tipoTelefone;
    }

    public void setTipoTelefone(TipoTelefoneDTO tipoTelefone) {
        this.tipoTelefone = tipoTelefone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public TipoEmailDTO getTipoEmail() {
        return tipoEmail;
    }

    public void setTipoEmail(TipoEmailDTO tipoEmail) {
        this.tipoEmail = tipoEmail;
    }
}

