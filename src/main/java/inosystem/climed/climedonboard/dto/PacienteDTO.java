package inosystem.climed.climedonboard.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;


@NoArgsConstructor
@AllArgsConstructor
public class    PacienteDTO {
    private Long pacId;
    private String pacNome;
    private LocalDate pacNasc;
    private String pacProf;
    private String pacEstcivil;
    private String pacResp;
    private String pacEmail;
    private Long pacConv;
    private String pacCart;
    private String pacObs;
    private LocalDateTime pacUltatend;
    private String pacIndicacao;
    private LocalDate pacPriConsulta;
    private String pacEp;
    private String pacHd;
    private String pacCd;
    private String pacQD;
    private boolean pacInfantil;
    private String pacHPMA;
    private String pacOBSmed;
    private Float pacConsulta;
    private boolean pacEmailInfo;
    private boolean pacCorreioInfo;
    private boolean pacSmsInfo;
    private boolean pacWhatsappInfo;
    private boolean pacTodosInfo;
    private boolean pacNenhumInfo;
    private boolean pacCadConfirmado;
    private String pacienteEscol;
    private boolean pacAptoCetamina;
    private String pacCpf;
    private LocalDateTime pacUltimaAlteracao;
    private Integer pacIdade;
    List<ContatoDTO> contatos;
   String telefone;
   @NotBlank String tipoTelefone;
   @Email String email;
   @NotBlank String tipoEmail;

    public Long getPacId() {
        return pacId;
    }

    public void setPacId(Long pacId) {
        this.pacId = pacId;
    }

    public String getTipoEmail() {
        return tipoEmail;
    }

    public void setTipoEmail(String tipoEmail) {
        this.tipoEmail = tipoEmail;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getTipoTelefone() {
        return tipoTelefone;
    }

    public void setTipoTelefone(String tipoTelefone) {
        this.tipoTelefone = tipoTelefone;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public List<ContatoDTO> getContatos() {
        return contatos;
    }

    public void setContatos(List<ContatoDTO> contatos) {
        this.contatos = contatos;
    }

    public Integer getPacIdade() {
        return pacIdade;
    }

    public void setPacIdade(Integer pacIdade) {
        this.pacIdade = pacIdade;
    }

    public LocalDateTime getPacUltimaAlteracao() {
        return pacUltimaAlteracao;
    }

    public void setPacUltimaAlteracao(LocalDateTime pacUltimaAlteracao) {
        this.pacUltimaAlteracao = pacUltimaAlteracao;
    }

    public String getPacCpf() {
        return pacCpf;
    }

    public void setPacCpf(String pacCpf) {
        this.pacCpf = pacCpf;
    }

    public boolean isPacAptoCetamina() {
        return pacAptoCetamina;
    }

    public void setPacAptoCetamina(boolean pacAptoCetamina) {
        this.pacAptoCetamina = pacAptoCetamina;
    }

    public boolean isPacCadConfirmado() {
        return pacCadConfirmado;
    }

    public void setPacCadConfirmado(boolean pacCadConfirmado) {
        this.pacCadConfirmado = pacCadConfirmado;
    }

    public String getPacienteEscol() {
        return pacienteEscol;
    }

    public void setPacienteEscol(String pacienteEscol) {
        this.pacienteEscol = pacienteEscol;
    }

    public boolean isPacNenhumInfo() {
        return pacNenhumInfo;
    }

    public void setPacNenhumInfo(boolean pacNenhumInfo) {
        this.pacNenhumInfo = pacNenhumInfo;
    }

    public boolean isPacTodosInfo() {
        return pacTodosInfo;
    }

    public void setPacTodosInfo(boolean pacTodosInfo) {
        this.pacTodosInfo = pacTodosInfo;
    }

    public boolean isPacSmsInfo() {
        return pacSmsInfo;
    }

    public void setPacSmsInfo(boolean pacSmsInfo) {
        this.pacSmsInfo = pacSmsInfo;
    }

    public boolean isPacWhatsappInfo() {
        return pacWhatsappInfo;
    }

    public void setPacWhatsappInfo(boolean pacWhatsappInfo) {
        this.pacWhatsappInfo = pacWhatsappInfo;
    }

    public boolean isPacCorreioInfo() {
        return pacCorreioInfo;
    }

    public void setPacCorreioInfo(boolean pacCorreioInfo) {
        this.pacCorreioInfo = pacCorreioInfo;
    }

    public boolean isPacEmailInfo() {
        return pacEmailInfo;
    }

    public void setPacEmailInfo(boolean pacEmailInfo) {
        this.pacEmailInfo = pacEmailInfo;
    }

    public Float getPacConsulta() {
        return pacConsulta;
    }

    public void setPacConsulta(Float pacConsulta) {
        this.pacConsulta = pacConsulta;
    }

    public String getPacOBSmed() {
        return pacOBSmed;
    }

    public void setPacOBSmed(String pacOBSmed) {
        this.pacOBSmed = pacOBSmed;
    }

    public String getPacHPMA() {
        return pacHPMA;
    }

    public void setPacHPMA(String pacHPMA) {
        this.pacHPMA = pacHPMA;
    }

    public String getPacQD() {
        return pacQD;
    }

    public void setPacQD(String pacQD) {
        this.pacQD = pacQD;
    }

    public boolean isPacInfantil() {
        return pacInfantil;
    }

    public void setPacInfantil(boolean pacInfantil) {
        this.pacInfantil = pacInfantil;
    }

    public String getPacCd() {
        return pacCd;
    }

    public void setPacCd(String pacCd) {
        this.pacCd = pacCd;
    }

    public String getPacHd() {
        return pacHd;
    }

    public void setPacHd(String pacHd) {
        this.pacHd = pacHd;
    }

    public String getPacEp() {
        return pacEp;
    }

    public void setPacEp(String pacEp) {
        this.pacEp = pacEp;
    }

    public LocalDate getPacPriConsulta() {
        return pacPriConsulta;
    }

    public void setPacPriConsulta(LocalDate pacPriConsulta) {
        this.pacPriConsulta = pacPriConsulta;
    }

    public String getPacIndicacao() {
        return pacIndicacao;
    }

    public void setPacIndicacao(String pacIndicacao) {
        this.pacIndicacao = pacIndicacao;
    }

    public LocalDateTime getPacUltatend() {
        return pacUltatend;
    }

    public void setPacUltatend(LocalDateTime pacUltatend) {
        this.pacUltatend = pacUltatend;
    }

    public Long getPacConv() {
        return pacConv;
    }

    public void setPacConv(Long pacConv) {
        this.pacConv = pacConv;
    }

    public String getPacObs() {
        return pacObs;
    }

    public void setPacObs(String pacObs) {
        this.pacObs = pacObs;
    }

    public String getPacCart() {
        return pacCart;
    }

    public void setPacCart(String pacCart) {
        this.pacCart = pacCart;
    }

    public String getPacEmail() {
        return pacEmail;
    }

    public void setPacEmail(String pacEmail) {
        this.pacEmail = pacEmail;
    }

    public String getPacEstcivil() {
        return pacEstcivil;
    }

    public void setPacEstcivil(String pacEstcivil) {
        this.pacEstcivil = pacEstcivil;
    }

    public String getPacProf() {
        return pacProf;
    }

    public void setPacProf(String pacProf) {
        this.pacProf = pacProf;
    }

    public LocalDate getPacNasc() {
        return pacNasc;
    }

    public void setPacNasc(LocalDate pacNasc) {
        this.pacNasc = pacNasc;
    }

    public String getPacNome() {
        return pacNome;
    }

    public void setPacNome(String pacNome) {
        this.pacNome = pacNome;
    }

    public String getPacResp() {
        return pacResp;
    }

    public void setPacResp(String pacResp) {
        this.pacResp = pacResp;
    }

    public PacienteDTO(Long pacId, String pacNome, LocalDate pacNasc, String pacProf, String pacEstcivil, String pacResp, String pacEmail, Long pacConv, String pacCart, String pacObs, LocalDateTime pacUltatend, String pacIndicacao, LocalDate pacPriConsulta, String pacEp, String pacHd, String pacCd, String pacQD, boolean pacInfantil, String pacHPMA, String pacOBSmed, Float pacConsulta, boolean pacEmailInfo, boolean pacCorreioInfo, boolean pacSmsInfo, boolean pacWhatsappInfo, boolean pacTodosInfo, boolean pacNenhumInfo, boolean pacCadConfirmado, String pacienteEscol, boolean pacAptoCetamina, String pacCpf, LocalDateTime pacUltimaAlteracao, Integer pacIdade) {
    }
}