package inosystem.climed.climedonboard.model;

import jakarta.persistence.*;

@Entity
@Table(name = "contato")

public class Contato {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "cont_id")
    private Long contId;

    @ManyToOne
    @JoinColumn(name = "pac_id", nullable = true)
    private Paciente paciente;

    @ManyToOne
    @JoinColumn(name = "med_id", nullable = true)
    private Medico medico;

    @Column(length = 20)
    private String telefone;

    @ManyToOne
    @JoinColumn(name = "tipo_telefone")
    private TipoTelefone tipoTelefone;

    @Column(length = 100)
    private String email;

    @ManyToOne
    @JoinColumn(name = "tipo_email")
    private TipoEmail tipoEmail;

    public Long getContId() {
        return contId;
    }

    public void setContId(Long contId) {
        this.contId = contId;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Medico getMedico() {
        return medico;
    }

    public void setMedico(Medico medico) {
        this.medico = medico;
    }

    public Paciente getPaciente() {
        return paciente;
    }

    public void setPaciente(Paciente paciente) {
        this.paciente = paciente;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public TipoEmail getTipoEmail() {
        return tipoEmail;
    }

    public void setTipoEmail(TipoEmail tipoEmail) {
        this.tipoEmail = tipoEmail;
    }

    public TipoTelefone getTipoTelefone() {
        return tipoTelefone;
    }

    public void setTipoTelefone(TipoTelefone tipoTelefone) {
        this.tipoTelefone = tipoTelefone;
    }
}
