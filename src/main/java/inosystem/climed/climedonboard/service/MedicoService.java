package inosystem.climed.climedonboard.service;

import inosystem.climed.climedonboard.dto.ContatoDTO;
import inosystem.climed.climedonboard.dto.MedicoDTO;
import inosystem.climed.climedonboard.dto.TipoEmailDTO;
import inosystem.climed.climedonboard.dto.TipoTelefoneDTO;
import inosystem.climed.climedonboard.exceptions.ResourceCreatedException;
import inosystem.climed.climedonboard.exceptions.ResourceDeleteNoContentException;
import inosystem.climed.climedonboard.exceptions.ResourceNotFoundException;
import inosystem.climed.climedonboard.exceptions.ResourceUpdateNoContentException;
import inosystem.climed.climedonboard.model.Contato;
import inosystem.climed.climedonboard.model.Medico;
import inosystem.climed.climedonboard.model.TipoEmail;
import inosystem.climed.climedonboard.model.TipoTelefone;
import inosystem.climed.climedonboard.repository.MedicoRepository;
import inosystem.climed.climedonboard.repository.TipoEmailRepository;
import inosystem.climed.climedonboard.repository.TipoTelefoneRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class MedicoService {
    private final MedicoRepository repository;
    private final MedicoRepository medicoRepository;
    private final TipoTelefoneRepository tipoTelefoneRepository;
    private final TipoEmailRepository tipoEmailRepository;

    @Autowired
    public MedicoService(MedicoRepository repository, MedicoRepository medicoRepository, TipoTelefoneRepository tipoTelefoneRepository, TipoEmailRepository tipoEmailRepository, TipoTelefoneRepository tipoTelefoneRepository1, TipoEmailRepository tipoEmailRepository1) {
        this.repository = repository;
        this.medicoRepository = medicoRepository;
        this.tipoTelefoneRepository = tipoTelefoneRepository1;
        this.tipoEmailRepository = tipoEmailRepository1;


}
    private void setMedicoFields(Medico medico, MedicoDTO dto) {
        medico.setCpf(dto.getCpf());
        medico.setAtivo(dto.isAtivo());
        medico.setCrm(dto.getCrm());
        medico.setEspecialidade(dto.getEspecialidade());
        medico.setNome(dto.getNome());
        medico.setPercentual(dto.getPercentual());
        medico.setTelefone(dto.getTelefone());

        // Aqui você pode adicionar outros campos se tiver
    }
    private MedicoDTO convertToDTO(Medico medico) {
        // Converte a lista de contatos da entidade Medico para uma lista de ContatoDTO
        List<ContatoDTO> contatosDTO = medico.getContatos().stream()
                .map(contato -> {
                    ContatoDTO contatoDTO = new ContatoDTO();

                    // Mapear os campos básicos do contato
                    contatoDTO.setContId(contato.getContId());
                    contatoDTO.setTelefone(contato.getTelefone());
                    contatoDTO.setEmail(contato.getEmail());

                    // Converte TipoTelefone para DTO (se existir)
                    if (contato.getTipoTelefone() != null) {
                        TipoTelefoneDTO tipoTelefoneDTO = new TipoTelefoneDTO();
                        tipoTelefoneDTO.setTelt_id(contato.getTipoTelefone().getTeltId());
                        tipoTelefoneDTO.setTipo(contato.getTipoTelefone().getTipo());
                        contatoDTO.setTipoTelefone(tipoTelefoneDTO);
                    }

                    // Converte TipoEmail para DTO (se existir)
                    if (contato.getTipoEmail() != null) {
                        TipoEmailDTO tipoEmailDTO = new TipoEmailDTO();
                        tipoEmailDTO.settipoe_id(contato.getTipoEmail().getTipoeId());
                        tipoEmailDTO.setTipo(contato.getTipoEmail().getTipo());
                        contatoDTO.setTipoEmail(tipoEmailDTO);
                    }

                    return contatoDTO;
                    // Retorna o contato convertido em DTO
                }).collect(Collectors.toList()); // Converte para uma lista de ContatoDTO

        // Retorna o MedicoDTO com todos os campos preenchidos
        return new MedicoDTO(
                medico.getMedId(),                // ID do Médico
                medico.getNome(),                 // Nome do Médico
                medico.getTelefone(),             // Telefone do Médico
                medico.getCpf(),                  // CPF do Médico
                medico.getCrm(),                  // CRM do Médico
                medico.getPercentual(),           // Percentual
                medico.getEspecialidade(),        // Especialidade do Médico
                contatosDTO,                      // Lista de contatos convertida para DTO
                medico.isAtivo()                  // Status ativo (boolean)
        );
    }

    private List<Contato> mapContatos(List<ContatoDTO> contatoDTOs, Medico medico) {
        if (contatoDTOs == null) return Collections.emptyList();

        return contatoDTOs.stream().map(dto -> {
            Contato contato = new Contato();
            contato.setTelefone(dto.getTelefone());
            contato.setEmail(dto.getEmail());
            contato.setMedico(medico);
            contato.setPaciente(null); // aqui é importante deixar null para paciente
            // Mapear TipoTelefone
            if (dto.getTipoTelefone() != null && dto.getTipoTelefone().getTelt_id() != null) {
                TipoTelefone tipoTelefone = tipoTelefoneRepository.findById(dto.getTipoTelefone().getTelt_id())
                        .orElseThrow(() -> new IllegalArgumentException("TipoTelefone com ID " + dto.getTipoTelefone().getTelt_id() + " não encontrado."));
                contato.setTipoTelefone(tipoTelefone);
            }

// Mapear TipoEmail
            if (dto.getTipoEmail() != null && dto.getTipoEmail().gettipoe_id() != null) {
                TipoEmail tipoEmail = tipoEmailRepository.findById(dto.getTipoEmail().gettipoe_id())
                        .orElseThrow(() -> new IllegalArgumentException("TipoEmail com ID " + dto.getTipoEmail().gettipoe_id() + " não encontrado."));
                contato.setTipoEmail(tipoEmail);
            }


            return contato;
        }).collect(Collectors.toList());

    }

    public List<MedicoDTO> listarTodos() {
        return repository.findAll().stream()
                .map(this::convertToDTO) // Use o método de conversão
                .collect(Collectors.toList());
    }

    public MedicoDTO buscarPorId(Long id) {
        return repository.findById(id)
                .map(this::convertToDTO) // Use o método de conversão
                .orElseThrow(() -> new ResourceNotFoundException("Médico com ID " + id + " não encontrado."));
    }





    public MedicoDTO adicionar(MedicoDTO dto) {
        Medico medico = new Medico();
        medico.setNome(dto.getNome());
        medico.setCrm(dto.getCrm());
        medico.setTelefone(dto.getTelefone());
        medico.setCpf(dto.getCpf());
        medico.setAtivo(true);
        medico.setPercentual(dto.getPercentual());
        medico.setEspecialidade(dto.getEspecialidade());

        // Mapeia e adiciona os contatos
        List<Contato> contatos = mapContatos(dto.getContatos(), medico);
        medico.setContatos(contatos);

        // Salva o médico com os contatos
        repository.save(medico);

        // Lança a exceção personalizada para sinalizar sucesso
        throw new ResourceCreatedException("Médico criado com sucesso.");
    }

    public void deletar(Long id) {
        if (!repository.existsById(id)) {
            throw new ResourceNotFoundException("Não foi possível excluir. Médico com ID " + id + " não encontrado.");
        }
        repository.deleteById(id);
        throw new ResourceDeleteNoContentException("Médico deletado com sucesso.");
    }
    public void limparContatos(Medico medico) {


        // 2. Inicialize a lista de contatos, caso seja necessário
        if (medico.getContatos() == null) {
            medico.setContatos(new ArrayList<>());
        } else if (!medico.getContatos().isEmpty()) {
            // Apenas realiza a limpeza se a lista não estiver vazia
            medico.getContatos().clear();
        }

        // 3. Atualize a entidade no banco (se necessário)
        repository.save(medico);
    }

    public Optional<MedicoDTO> atualizar(Long id, MedicoDTO dto) {
        Medico medico = repository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Não foi possível atualizar. Médico com ID " + id + " não encontrado."));

        medico.setNome(dto.getNome());
        medico.setTelefone(dto.getTelefone());
        medico.setCpf(dto.getCpf());
        medico.setCrm(dto.getCrm());
        medico.setPercentual(dto.getPercentual());
        medico.setEspecialidade(dto.getEspecialidade());

        repository.save(medico);
        medico.getContatos().clear();
        medico.getContatos().addAll(mapContatos(dto.getContatos(), medico));

        medicoRepository.save(medico);
        return Optional.ofNullable(convertToDTO(medico));

    }


}
