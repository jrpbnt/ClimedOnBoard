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
        // mapeie os outros campos...
        return dto;
    }

    public Paciente toEntity(PacienteDTO dto) {
        Paciente entity = new Paciente();
        entity.setPacId(dto.getPacId());
        entity.setPacNome(dto.getPacNome());
        entity.setPacNasc(dto.getPacNasc());
        // mapeie os outros campos...
        return entity;
    }
}
