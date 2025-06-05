package inosystem.climed.climedonboard.mapper;

import inosystem.climed.climedonboard.dto.ContatoDTO;
import inosystem.climed.climedonboard.dto.TipoEmailDTO;
import inosystem.climed.climedonboard.dto.TipoTelefoneDTO;
import inosystem.climed.climedonboard.model.Contato;
import inosystem.climed.climedonboard.model.TipoEmail;
import inosystem.climed.climedonboard.model.TipoTelefone;
import inosystem.climed.climedonboard.repository.TipoEmailRepository;
import inosystem.climed.climedonboard.repository.TipoTelefoneRepository;
import org.springframework.stereotype.Component;

@Component
public class ContatoMapper {

    public Contato toEntity(ContatoDTO dto, TipoEmailRepository tipoEmailRepository, TipoTelefoneRepository tipoTelefoneRepository) {
        Contato entity = new Contato();
        entity.setContId(dto.getContId());
        entity.setTelefone(dto.getTelefone());
        entity.setEmail(dto.getEmail());

        // Mapear tipoTelefone
        if (dto.getTipoTelefone() != null && dto.getTipoTelefone().getTelt_id() != null) {
            TipoTelefone tipoTelefone = tipoTelefoneRepository.findById(dto.getTipoTelefone().getTelt_id())
                    .orElseThrow(() -> new IllegalArgumentException("TipoTelefone com ID " + dto.getTipoTelefone().getTelt_id() + " não encontrado"));
            entity.setTipoTelefone(tipoTelefone);
        }

        // Mapear tipoEmail
        if (dto.getTipoEmail() != null && dto.getTipoEmail().gettipoe_id() != null) {
            TipoEmail tipoEmail = tipoEmailRepository.findById(dto.getTipoEmail().gettipoe_id())
                    .orElseThrow(() -> new IllegalArgumentException("TipoEmail com ID " + dto.getTipoEmail().gettipoe_id() + " não encontrado"));
            entity.setTipoEmail(tipoEmail);
        }

        return entity;
    }
}