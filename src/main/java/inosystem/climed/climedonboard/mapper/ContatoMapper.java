package inosystem.climed.climedonboard.mapper;

import inosystem.climed.climedonboard.dto.ContatoDTO;
import inosystem.climed.climedonboard.dto.TipoEmailDTO;
import inosystem.climed.climedonboard.dto.TipoTelefoneDTO;
import inosystem.climed.climedonboard.model.Contato;
import inosystem.climed.climedonboard.model.TipoEmail;
import inosystem.climed.climedonboard.model.TipoTelefone;
import org.springframework.stereotype.Component;

@Component
public class ContatoMapper {

    public ContatoDTO toDTO(Contato contato) {
        ContatoDTO dto = new ContatoDTO();
        dto.setContId(contato.getContId());
        dto.setTelefone(contato.getTelefone());
        dto.setEmail(contato.getEmail());

        // Mapear TipoTelefone para DTO
        if (contato.getTipoTelefone() != null) {
            TipoTelefoneDTO tipoTelefoneDTO = new TipoTelefoneDTO();
            tipoTelefoneDTO.setTelt_id(contato.getTipoTelefone().getTeltId());

            dto.setTipoTelefone(tipoTelefoneDTO);
        }

        // Mapear TipoEmail para DTO
        if (contato.getTipoEmail() != null) {
            TipoEmailDTO tipoEmailDTO = new TipoEmailDTO();
            tipoEmailDTO.settipoe_id(contato.getTipoEmail().getTipoeId());

            dto.setTipoEmail(tipoEmailDTO);
        }

        return dto;
    }

    public Contato toEntity(ContatoDTO dto) {
        Contato entity = new Contato();
        entity.setContId(dto.getContId());
        entity.setTelefone(dto.getTelefone());
        entity.setEmail(dto.getEmail());

        // Aqui criamos instâncias de TipoTelefone e TipoEmail apenas com o ID (associados depois no service)
        if (dto.getTipoTelefone() != null && dto.getTipoTelefone().getTelt_id() != null) {
            TipoTelefone tipoTelefone = new TipoTelefone();
            tipoTelefone.setTeltId(dto.getTipoTelefone().getTelt_id());
            entity.setTipoTelefone(tipoTelefone);
        }

        if (dto.getTipoEmail() != null && dto.getTipoEmail().gettipoe_id() != null) {
            TipoEmail tipoEmail = new TipoEmail();
            tipoEmail.setTipoeId(dto.getTipoEmail().gettipoe_id());
            entity.setTipoEmail(tipoEmail);
        }

        return entity;
    }
}