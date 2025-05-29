package inosystem.climed.climedonboard.service;

import inosystem.climed.climedonboard.dto.MedicoDTO;
import inosystem.climed.climedonboard.exceptions.ResourceCreatedException;
import inosystem.climed.climedonboard.exceptions.ResourceDeleteNoContentException;
import inosystem.climed.climedonboard.exceptions.ResourceNotFoundException;
import inosystem.climed.climedonboard.exceptions.ResourceUpdateNoContentException;
import inosystem.climed.climedonboard.model.Medico;
import inosystem.climed.climedonboard.repository.MedicoRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class MedicoService {
    private final MedicoRepository repository;

    public MedicoService(MedicoRepository repository) {
        this.repository = repository;
    }

    public List<MedicoDTO> listarTodos() {
        return repository.findAll().stream()
                .map(med -> new MedicoDTO(med.getMedId(), med.getNome(), med.getTelefone(), med.getCpf(), med.getCrm(), med.getPercentual(), med.getEspecialidade()))
                .collect(Collectors.toList());
    }

    public MedicoDTO buscarPorId(Long id) {
        return repository.findById(id)
                .map(med -> new MedicoDTO(med.getMedId(), med.getNome(), med.getTelefone(), med.getCpf(), med.getCrm(), med.getPercentual(), med.getEspecialidade()))
                .orElseThrow(() -> new ResourceNotFoundException("Médico com ID " + id + " não encontrado."));
    }

    public MedicoDTO adicionar(MedicoDTO dto) {
        Medico medico = new Medico(null, dto.getNome(), dto.getCrm(), dto.getTelefone(), dto.getCpf(), true, dto.getPercentual(), dto.getEspecialidade(), 0);
        repository.save(medico);
        throw new ResourceCreatedException("Médico criado com sucesso.");
    }

    public void deletar(Long id) {
        if (!repository.existsById(id)) {
            throw new ResourceNotFoundException("Não foi possível excluir. Médico com ID " + id + " não encontrado.");
        }
        repository.deleteById(id);
        throw new ResourceDeleteNoContentException("Médico deletado com sucesso.");
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
        throw new ResourceUpdateNoContentException("Atualização concluída com sucesso.");
    }
}
