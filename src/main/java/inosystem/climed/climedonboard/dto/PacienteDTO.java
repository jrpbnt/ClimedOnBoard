package inosystem.climed.climedonboard.dto;


import lombok.AllArgsConstructor;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

@Setter

@Getter
@NoArgsConstructor
@AllArgsConstructor
public class  PacienteDTO {
    private Long pacId;
    private String pacNome;
    private LocalDate pacNasc;
    private String pacProf;
    private String pacEstcivil;
    private String pacResp;

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

    public PacienteDTO(Long pacId, String pacNome, LocalDate pacNasc, String pacProf, String pacEstcivil, String pacResp, Long pacConv, String pacCart, String pacObs, LocalDateTime pacUltatend, String pacIndicacao, LocalDate pacPriConsulta, String pacEp, String pacHd, String pacCd, String pacQD, boolean pacInfantil, String pacHPMA, String pacOBSmed, Float pacConsulta, boolean pacEmailInfo, boolean pacCorreioInfo, boolean pacSmsInfo, boolean pacWhatsappInfo, boolean pacTodosInfo, boolean pacNenhumInfo, boolean pacCadConfirmado, String pacienteEscol, boolean pacAptoCetamina, String pacCpf, LocalDateTime pacUltimaAlteracao, Integer pacIdade) {
    }
}