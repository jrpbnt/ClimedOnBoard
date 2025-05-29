package inosystem.climed.climedonboard.service;

import inosystem.climed.climedonboard.dto.EnfermeiroDTO;
import inosystem.climed.climedonboard.exceptions.ResourceCreatedException;
import inosystem.climed.climedonboard.exceptions.ResourceDeleteNoContentException;
import inosystem.climed.climedonboard.exceptions.ResourceNotFoundException;
import inosystem.climed.climedonboard.exceptions.ResourceUpdateNoContentException;
import inosystem.climed.climedonboard.model.Enfermeiro;
import inosystem.climed.climedonboard.repository.EnfermeiroRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;




@Service
public class EnfermeiroService {
    private final EnfermeiroRepository repository;

    public EnfermeiroService(EnfermeiroRepository repository) {
        this.repository = repository;
    }

    public List<EnfermeiroDTO> listarTodos() {
        return repository.findAll().stream()
                .map(enf -> new EnfermeiroDTO(enf.getEnfId(), enf.getNome(), enf.getTelefone(), enf.getCpf(), enf.getEspecialidade(), enf.getCofen(), enf.getCoren()))
                .collect(Collectors.toList());
    }

    public EnfermeiroDTO buscarPorId(Long id) {
        return repository.findById(id)
                .map(enf -> new EnfermeiroDTO(enf.getEnfId(), enf.getNome(), enf.getTelefone(), enf.getCpf(), enf.getEspecialidade(), enf.getCofen(), enf.getCoren()))
                .orElseThrow(() -> new ResourceNotFoundException("Enfermeiro com ID " + id + " não encontrado."));
    }

    public EnfermeiroDTO adicionar(EnfermeiroDTO dto) {
        Enfermeiro enfermeiro = new Enfermeiro(null, dto.getNome(), dto.getTelefone(), dto.getCpf(), true, dto.getEspecialidade(), dto.getCofen(), dto.getCoren());
        repository.save(enfermeiro);
        throw new ResourceCreatedException("Enfermeiro criado com sucesso.");
    }

    public void deletar(Long id) {
        if (!repository.existsById(id)) {
            throw new ResourceNotFoundException("Não foi possível excluir. Enfermeiro com ID " + id + " não encontrado.");
        }
        repository.deleteById(id);
        throw new ResourceDeleteNoContentException("Enfermeiro deletado com sucesso.");
    }

    public Optional<EnfermeiroDTO> atualizar(Long id, EnfermeiroDTO dto) {
        Enfermeiro enfermeiro = repository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Não foi possível atualizar. Enfermeiro com ID " + id + " não encontrado."));

        enfermeiro.setNome(dto.getNome());
        enfermeiro.setTelefone(dto.getTelefone());
        enfermeiro.setCpf(dto.getCpf());
        enfermeiro.setEspecialidade(dto.getEspecialidade());
        enfermeiro.setCofen(dto.getCofen());
        enfermeiro.setCoren(dto.getCoren());

        repository.save(enfermeiro);
        throw new ResourceUpdateNoContentException("Atualização concluída com sucesso.");
    }
}
