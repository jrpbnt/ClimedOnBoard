package inosystem.climed.climedonboard.service;

import inosystem.climed.climedonboard.dto.*;
import inosystem.climed.climedonboard.exceptions.ResourceCreatedException;
import inosystem.climed.climedonboard.exceptions.ResourceDeleteNoContentException;
import inosystem.climed.climedonboard.exceptions.ResourceNotFoundException;
import inosystem.climed.climedonboard.exceptions.ResourceUpdateNoContentException;
import inosystem.climed.climedonboard.model.*;
import inosystem.climed.climedonboard.repository.EspecialidadeRepository;
import inosystem.climed.climedonboard.repository.MedicoRepository;
import inosystem.climed.climedonboard.repository.TipoEmailRepository;
import inosystem.climed.climedonboard.repository.TipoTelefoneRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.*;
import java.util.stream.Collectors;

@Service
public class MedicoService {
    private final MedicoRepository repository;
    private final MedicoRepository medicoRepository;
    private final TipoTelefoneRepository tipoTelefoneRepository;
    private final TipoEmailRepository tipoEmailRepository;
    private final EspecialidadeRepository especialidadeRepository;

    @Autowired
    public MedicoService(MedicoRepository repository, MedicoRepository medicoRepository, TipoTelefoneRepository tipoTelefoneRepository, TipoEmailRepository tipoEmailRepository, TipoTelefoneRepository tipoTelefoneRepository1, TipoEmailRepository tipoEmailRepository1, EspecialidadeRepository especialidadeRepository) {
        this.repository = repository;
        this.medicoRepository = medicoRepository;
        this.tipoTelefoneRepository = tipoTelefoneRepository1;
        this.tipoEmailRepository = tipoEmailRepository1;
        this.especialidadeRepository = especialidadeRepository;
    }
    private void mapearContato(ContatoDTO contatoDTO, Contato contato) {
        // Configurar atributos simples
        contato.setTelefone(contatoDTO.getTelefone());
        contato.setEmail(contatoDTO.getEmail());

        // Mapear tipoTelefone usando o Repositório
        if (contatoDTO.getTipoTelefone() != null && contatoDTO.getTipoTelefone().getTelt_id() != null) {
            TipoTelefone tipoTelefone = tipoTelefoneRepository.findById(contatoDTO.getTipoTelefone().getTelt_id())
                    .orElseThrow(() -> new ResourceNotFoundException("TipoTelefone não encontrado com ID: " + contatoDTO.getTipoTelefone().getTelt_id()));
            contato.setTipoTelefone(tipoTelefone);
        }

        // Mapear tipoEmail usando o Repositório
        if (contatoDTO.getTipoEmail() != null && contatoDTO.getTipoEmail().gettipoe_id() != null) {
            TipoEmail tipoEmail = tipoEmailRepository.findById(contatoDTO.getTipoEmail().gettipoe_id())
                    .orElseThrow(() -> new ResourceNotFoundException("TipoEmail não encontrado com ID: " + contatoDTO.getTipoEmail().gettipoe_id()));
            contato.setTipoEmail(tipoEmail);
        }
    }

    private MedicoDTO convertToDTO(Medico medico) {
        MedicoDTO dto = new MedicoDTO();
        dto.setId(medico.getMedId());
        dto.setNome(medico.getNome());
        dto.setCpf(medico.getCpf());
        dto.setCrm(medico.getCrm());
        dto.setPercentual(medico.getPercentual());
        dto.setAtivo(medico.isAtivo());

        // Converte o Set de Especialidades para List
        dto.setEspecialidades(
                medico.getEspecialidades().stream()
                        .map(especialidade ->
                                new EspecialidadeDTO(
                                        especialidade.getId(),
                                        especialidade.getTipoEspecialidade()
                                )
                        )
                        .collect(Collectors.toList()) // Converte para List
        );


        medico.getEspecialidades().forEach(especialidade -> {
            System.out.println("Especialidade ID: " + especialidade.getId());
            System.out.println("Tipo Especialidade: " + especialidade.getTipoEspecialidade());
        });

        // Mapear contatos
        dto.setContatos(
                medico.getContatos().stream()
                        .map(contato -> {
                            ContatoDTO cDTO = new ContatoDTO();
                            cDTO.setContId(contato.getContId());
                            cDTO.setTelefone(contato.getTelefone());
                            cDTO.setEmail(contato.getEmail());

                            // Mapear TipoTelefone
                            if (contato.getTipoTelefone() != null) {
                                TipoTelefoneDTO tptDTO = new TipoTelefoneDTO();
                                tptDTO.setTelt_id(contato.getTipoTelefone().getTeltId());
                                tptDTO.setTipo(contato.getTipoTelefone().getTipo());
                                cDTO.setTipoTelefone(tptDTO);
                            }

                            // Mapear TipoEmail
                            if (contato.getTipoEmail() != null) {
                                TipoEmailDTO tpeDTO = new TipoEmailDTO();
                                tpeDTO.settipoe_id(contato.getTipoEmail().getTipoeId());
                                tpeDTO.setTipo(contato.getTipoEmail().getTipo());
                                cDTO.setTipoEmail(tpeDTO);
                            }

                            return cDTO;
                        })
                        .collect(Collectors.toList())
        );
        return dto;
    }



    private List<Contato> mapContatos(List<ContatoDTO> contatoDTOs, Medico medico) {
        return contatoDTOs.stream()
                .map(dto -> {
                    Contato contato = new Contato();
                    contato.setTelefone(dto.getTelefone());
                    contato.setEmail(dto.getEmail());

                    if (dto.getTipoTelefone() != null && dto.getTipoTelefone().getTelt_id() != null) {
                        TipoTelefone tipoTelefone = tipoTelefoneRepository.findById(dto.getTipoTelefone().getTelt_id())
                                .orElseThrow(() -> new RuntimeException("TipoTelefone com ID " + dto.getTipoTelefone().getTelt_id() + " não encontrado."));
                        contato.setTipoTelefone(tipoTelefone);
                    }

                    if (dto.getTipoEmail() != null && dto.getTipoEmail().gettipoe_id() != null) {
                        TipoEmail tipoEmail = tipoEmailRepository.findById(dto.getTipoEmail().gettipoe_id())
                                .orElseThrow(() -> new RuntimeException("TipoEmail com ID " + dto.getTipoEmail().gettipoe_id() + " não encontrado."));
                        contato.setTipoEmail(tipoEmail);
                    }

                    contato.setMedico(medico); // Associação com o médico
                    return contato;
                })
                .toList();
    }

    public List<MedicoDTO> listarTodos() {
        // Buscar médicos e especialidades
        List<Medico> medicos = medicoRepository.findAllWithEspecialidades();

        // Mapear para DTO
        return medicos.stream()
                .map(this::convertToDTO)
                .collect(Collectors.toList());
    }




    public MedicoDTO buscarPorId(Long id) {
        Medico medico = repository.findById(id).orElseThrow(() ->
                new RuntimeException("Médico com ID " + id + " não encontrado.")
        );
        return convertToDTO(medico);
    }






    public MedicoDTO adicionar(MedicoDTO dto) {
        Medico medico = new Medico();
        medico.setNome(dto.getNome());
        medico.setCrm(dto.getCrm());
        medico.setCpf(dto.getCpf());
        medico.setAtivo(true);
        medico.setPercentual(dto.getPercentual());

        // Mapeia e adiciona os contatos
        List<Contato> contatos = mapContatos(dto.getContatos(), medico);
        medico.setContatos(contatos);

        if (dto.getEspecialidades() != null && !dto.getEspecialidades().isEmpty()) {
            Set<Especialidade> especialidades = dto.getEspecialidades().stream()
                    .map(id -> especialidadeRepository.findById(id.getId())
                            .orElseThrow(() -> new IllegalArgumentException("Especialidade com ID " + id + " não encontrada."))
                    )
                    .collect(Collectors.toSet());

            medico.setEspecialidades((Set<Especialidade>) especialidades);
        }





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
    @Transactional
    public Optional<MedicoDTO> atualizar(Long id, MedicoDTO dto) {
        Medico medico = medicoRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Médico não encontrado para ID: " + id));

        // Atualizar dados básicos do médico
        medico.setNome(dto.getNome());
        medico.setCpf(dto.getCpf());
        medico.setCrm(dto.getCrm());
        medico.setPercentual(dto.getPercentual());
        medico.setAtivo(dto.isAtivo());

        // Atualizar Contatos
        List<Contato> contatosExistentes = medico.getContatos();

        // Remover contatos antigos que não estão na nova lista do DTO
        contatosExistentes.removeIf(existingContato ->
                dto.getContatos().stream().noneMatch(newContato ->
                        newContato.getContId() != null && newContato.getContId().equals(existingContato.getContId())
                )
        );

        // Adicionar ou atualizar contatos do DTO na lista existente
        for (ContatoDTO novoContatoDTO : dto.getContatos()) {
            if (novoContatoDTO.getContId() != null) {
                // Atualizar contato existente
                contatosExistentes.stream()
                        .filter(existingContato ->
                                existingContato.getContId().equals(novoContatoDTO.getContId()))
                        .findFirst()
                        .ifPresent(existingContato -> updateContato(existingContato, novoContatoDTO));
            } else {
                // Adicionar um novo contato
                Contato novoContato = new Contato();
                mapearContato(novoContatoDTO, novoContato); // Método que mapeia DTO > Entity
                novoContato.setMedico(medico);
                contatosExistentes.add(novoContato);
            }
        }

        // Atualizar Especialidades (se necessário)
        Set<Especialidade> especialidades = dto.getEspecialidades().stream()
                .map(e -> especialidadeRepository.findById(e.getId())
                        .orElseThrow(() -> new RuntimeException("Especialidade não encontrada para ID: " + e.getId())))
                .collect(Collectors.toSet());
        medico.setEspecialidades(especialidades);

        // Persistir as atualizações no banco de dados
        medicoRepository.save(medico);

        return Optional.of(convertToDTO(medico));
    }

    // Método de auxílio para atualizar o contato existente
    private void updateContato(Contato existingContato, ContatoDTO contatoDTO) {
        existingContato.setTelefone(contatoDTO.getTelefone());
        existingContato.setEmail(contatoDTO.getEmail());
        existingContato.setTipoTelefone(tipoTelefoneRepository.findById(contatoDTO.getTipoTelefone().getTelt_id())
                .orElseThrow(() -> new RuntimeException("TipoTelefone não encontrado")));
        existingContato.setTipoEmail(tipoEmailRepository.findById(contatoDTO.getTipoEmail().gettipoe_id())
                .orElseThrow(() -> new RuntimeException("TipoEmail não encontrado")));
    }



}
