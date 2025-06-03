package inosystem.climed.climedonboard.mapper;

import inosystem.climed.climedonboard.dto.PacienteDTO;
import inosystem.climed.climedonboard.model.Paciente;
import org.springframework.stereotype.Component;
@Component
public class PacienteMapper {

    public static PacienteDTO toDTO(Paciente paciente) {
        PacienteDTO dto = new PacienteDTO();
        dto.setPacId(paciente.getPacId());
        dto.setPacNome(paciente.getPacNome());
        dto.setPacNasc(paciente.getPacNasc());
        dto.setPacProf(paciente.getPacProf());
        dto.setPacEstcivil(paciente.getPacEstcivil());
        dto.setPacResp(paciente.getPacResp());
        dto.setPacConv(paciente.getPacConv());
        dto.setPacCart(paciente.getPacCart());
        dto.setPacObs(paciente.getPacObs());
        dto.setPacUltatend(paciente.getPacUltatend());
        dto.setPacIndicacao(paciente.getPacIndicacao());
        dto.setPacPriConsulta(paciente.getPacPriConsulta());
        dto.setPacEp(paciente.getPacEp());
        dto.setPacHd(paciente.getPacHd());
        dto.setPacCd(paciente.getPacCd());
        dto.setPacQD(paciente.getPacQD());
        dto.setPacInfantil(paciente.isPacInfantil());
        dto.setPacHPMA(paciente.getPacHPMA());
        dto.setPacOBSmed(paciente.getPacOBSmed());
        dto.setPacConsulta(paciente.getPacConsulta());
        dto.setPacEmailInfo(paciente.isPacEmailInfo());
        dto.setPacCorreioInfo(paciente.isPacCorreioInfo());
        dto.setPacSmsInfo(paciente.isPacSmsInfo());
        dto.setPacWhatsappInfo(paciente.isPacWhatsappInfo());
        dto.setPacTodosInfo(paciente.isPacTodosInfo());
        dto.setPacNenhumInfo(paciente.isPacNenhumInfo());
        dto.setPacCadConfirmado(paciente.isPacCadConfirmado());
        dto.setPacienteEscol(paciente.getPacienteEscol());
        dto.setPacAptoCetamina(paciente.isPacAptoCetamina());
        dto.setPacCpf(paciente.getPacCpf());
        dto.setPacUltimaAlteracao(paciente.getPacUltimaAlteracao());
        dto.setPacIdade(paciente.getPacIdade());
        // Se necessário, mapear também os contatos
        // dto.setContatos(paciente.getContatos()); // se usar lista de DTOs

        return dto;
    }

    public Paciente toEntity(PacienteDTO dto) {
        Paciente entity = new Paciente();
        entity.setPacId(dto.getPacId());
        entity.setPacNome(dto.getPacNome());
        entity.setPacNasc(dto.getPacNasc());
        entity.setPacProf(dto.getPacProf());
        entity.setPacEstcivil(dto.getPacEstcivil());
        entity.setPacResp(dto.getPacResp());
        entity.setPacConv(dto.getPacConv());
        entity.setPacCart(dto.getPacCart());
        entity.setPacObs(dto.getPacObs());
        entity.setPacUltatend(dto.getPacUltatend());
        entity.setPacIndicacao(dto.getPacIndicacao());
        entity.setPacPriConsulta(dto.getPacPriConsulta());
        entity.setPacEp(dto.getPacEp());
        entity.setPacHd(dto.getPacHd());
        entity.setPacCd(dto.getPacCd());
        entity.setPacQD(dto.getPacQD());
        entity.setPacInfantil(dto.isPacInfantil());
        entity.setPacHPMA(dto.getPacHPMA());
        entity.setPacOBSmed(dto.getPacOBSmed());
        entity.setPacConsulta(dto.getPacConsulta());
        entity.setPacEmailInfo(dto.isPacEmailInfo());
        entity.setPacCorreioInfo(dto.isPacCorreioInfo());
        entity.setPacSmsInfo(dto.isPacSmsInfo());
        entity.setPacWhatsappInfo(dto.isPacWhatsappInfo());
        entity.setPacTodosInfo(dto.isPacTodosInfo());
        entity.setPacNenhumInfo(dto.isPacNenhumInfo());
        entity.setPacCadConfirmado(dto.isPacCadConfirmado());
        entity.setPacienteEscol(dto.getPacienteEscol());
        entity.setPacAptoCetamina(dto.isPacAptoCetamina());
        entity.setPacCpf(dto.getPacCpf());
        entity.setPacUltimaAlteracao(dto.getPacUltimaAlteracao());
        entity.setPacIdade(dto.getPacIdade());

        return entity;
    }
}
