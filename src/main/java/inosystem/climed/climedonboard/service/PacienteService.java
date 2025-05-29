package inosystem.climed.climedonboard.service;

import inosystem.climed.climedonboard.dto.ContatoDTO;
import inosystem.climed.climedonboard.dto.PacienteDTO;
import inosystem.climed.climedonboard.dto.TipoEmailDTO;
import inosystem.climed.climedonboard.dto.TipoTelefoneDTO;
import inosystem.climed.climedonboard.mapper.PacienteMapper;
import inosystem.climed.climedonboard.model.Contato;
import inosystem.climed.climedonboard.model.Paciente;
import inosystem.climed.climedonboard.model.TipoEmail;
import inosystem.climed.climedonboard.model.TipoTelefone;
import inosystem.climed.climedonboard.repository.PacienteRepository;
import inosystem.climed.climedonboard.repository.TipoEmailRepository;
import inosystem.climed.climedonboard.repository.TipoTelefoneRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class PacienteService {

    private final PacienteRepository pacienteRepository;
    private final TipoEmailRepository tipoEmailRepository;
    private final TipoTelefoneRepository tipoTelefoneRepository;

    public PacienteDTO salvar(PacienteDTO dto) {
        Paciente paciente = new Paciente();
        setPacienteFields(paciente, dto);

        List<Contato> contatos = mapContatos(dto.getContatos(), paciente);
        paciente.setContatos(contatos);

        pacienteRepository.save(paciente);
        return convertToDTO(paciente);
    }

    public PacienteDTO buscarPorId(Long id) {
        Paciente paciente = pacienteRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Paciente não encontrado: " + id));
        return convertToDTO(paciente);
    }

    public PacienteDTO atualizar(Long id, PacienteDTO dto) {
        Paciente paciente = pacienteRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Paciente não encontrado: " + id));

        setPacienteFields(paciente, dto);

        // Atualiza contatos
        paciente.getContatos().clear();
        List<Contato> contatos = mapContatos(dto.getContatos(), paciente);
        paciente.setContatos(contatos);

        pacienteRepository.save(paciente);
        return convertToDTO(paciente);
    }

    public void deletar(Long id) {
        if (!pacienteRepository.existsById(id)) {
            throw new RuntimeException("Paciente não encontrado: " + id);
        }
        pacienteRepository.deleteById(id);
    }

    // --- Métodos auxiliares ---

    private void setPacienteFields(Paciente paciente, PacienteDTO dto) {
        paciente.setPacNome(dto.getPacNome());
        paciente.setPacNasc(dto.getPacNasc());
        paciente.setPacProf(dto.getPacProf());
        paciente.setPacEstcivil(dto.getPacEstcivil());
        paciente.setPacResp(dto.getPacResp());
        paciente.setPacEmail(dto.getPacEmail());
        paciente.setPacConv(dto.getPacConv());
        paciente.setPacCart(dto.getPacCart());
        paciente.setPacObs(dto.getPacObs());
        paciente.setPacUltatend(dto.getPacUltatend());
        paciente.setPacIndicacao(dto.getPacIndicacao());
        paciente.setPacPriConsulta(dto.getPacPriConsulta());
        paciente.setPacEp(dto.getPacEp());
        paciente.setPacHd(dto.getPacHd());
        paciente.setPacCd(dto.getPacCd());
        paciente.setPacQD(dto.getPacQD());
        paciente.setPacInfantil(dto.isPacInfantil());
        paciente.setPacHPMA(dto.getPacHPMA());
        paciente.setPacOBSmed(dto.getPacOBSmed());
        paciente.setPacConsulta(dto.getPacConsulta());
        paciente.setPacEmailInfo(dto.isPacEmailInfo());
        paciente.setPacCorreioInfo(dto.isPacCorreioInfo());
        paciente.setPacSmsInfo(dto.isPacSmsInfo());
        paciente.setPacWhatsappInfo(dto.isPacWhatsappInfo());
        paciente.setPacTodosInfo(dto.isPacTodosInfo());
        paciente.setPacNenhumInfo(dto.isPacNenhumInfo());
        paciente.setPacCadConfirmado(dto.isPacCadConfirmado());
        paciente.setPacienteEscol(dto.getPacienteEscol());
        paciente.setPacAptoCetamina(dto.isPacAptoCetamina());
        paciente.setPacCpf(dto.getPacCpf());
        paciente.setPacUltimaAlteracao(dto.getPacUltimaAlteracao());
        paciente.setPacIdade(dto.getPacIdade());
    }

    private List<Contato> mapContatos(List<ContatoDTO> contatoDTOs, Paciente paciente) {
        if (contatoDTOs == null) return Collections.emptyList();

        List<Contato> contatos = new ArrayList<>();

        for (ContatoDTO contatoDTO : contatoDTOs) {
            Contato contato = new Contato();
            contato.setTelefone(contatoDTO.getTelefone());
            contato.setEmail(contatoDTO.getEmail());
            contato.setPaciente(paciente);

            if (contatoDTO.getTipoTelefone() != null && contatoDTO.getTipoTelefone().gettelt_id() != null) {
                TipoTelefone tipoTelefone = tipoTelefoneRepository.findById(contatoDTO.getTipoTelefone().gettelt_id())
                        .orElseThrow(() -> new RuntimeException("TipoTelefone não encontrado: " + contatoDTO.getTipoTelefone().gettelt_id()));
                contato.setTipoTelefone(tipoTelefone);
            }

            if (contatoDTO.getTipoEmail() != null && contatoDTO.getTipoEmail().gettipoe_id() != null) {
                TipoEmail tipoEmail = tipoEmailRepository.findById(contatoDTO.getTipoEmail().gettipoe_id())
                        .orElseThrow(() -> new RuntimeException("TipoEmail não encontrado: " + contatoDTO.getTipoEmail().gettipoe_id()));
                contato.setTipoEmail(tipoEmail);
            }

            contatos.add(contato);
        }

        return contatos;
    }

    private PacienteDTO convertToDTO(Paciente paciente) {
        PacienteDTO dto = new PacienteDTO();
        dto.setPacId(paciente.getPacId());
        dto.setPacNome(paciente.getPacNome());
        dto.setPacNasc(paciente.getPacNasc());
        dto.setPacProf(paciente.getPacProf());
        dto.setPacEstcivil(paciente.getPacEstcivil());
        dto.setPacResp(paciente.getPacResp());
        dto.setPacEmail(paciente.getPacEmail());
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

        // Mapear contatos
        if (paciente.getContatos() != null) {
            List<ContatoDTO> contatosDTO = paciente.getContatos().stream().map(contato -> {
                ContatoDTO cDTO = new ContatoDTO();
                cDTO.setContId(contato.getContId());
                cDTO.setTelefone(contato.getTelefone());
                cDTO.setEmail(contato.getEmail());

                if (contato.getTipoTelefone() != null) {
                    TipoTelefoneDTO tptDTO = new TipoTelefoneDTO();
                    tptDTO.settelt_id(contato.getTipoTelefone().getTeltId());
                    tptDTO.setTipo(contato.getTipoTelefone().getTipo());
                    cDTO.setTipoTelefone(tptDTO);
                }

                if (contato.getTipoEmail() != null) {
                    TipoEmailDTO tpeDTO = new TipoEmailDTO();
                    tpeDTO.settipoe_id(contato.getTipoEmail().getTipoeId());
                    tpeDTO.setTipo(contato.getTipoEmail().getTipo());
                    cDTO.setTipoEmail(tpeDTO);
                }

                return cDTO;
            }).toList();
            dto.setContatos(contatosDTO);
        }

        return dto;
    }
    public List<PacienteDTO> listarTodos() {
        List<Paciente> pacientes = pacienteRepository.findAll();
        return pacientes.stream()
                .map(PacienteMapper::toDTO)
                .collect(Collectors.toList());
    }

}