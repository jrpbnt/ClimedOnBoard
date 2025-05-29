package inosystem.climed.climedonboard.service;

import inosystem.climed.climedonboard.dto.RecepcionistaDTO;
import inosystem.climed.climedonboard.exceptions.ResourceCreatedException;
import inosystem.climed.climedonboard.exceptions.ResourceDeleteNoContentException;
import inosystem.climed.climedonboard.exceptions.ResourceNotFoundException;
import inosystem.climed.climedonboard.exceptions.ResourceUpdateNoContentException;
import inosystem.climed.climedonboard.model.Recepcionista;
import inosystem.climed.climedonboard.repository.RecepcionistaRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class RecepcionistaService {
    private final RecepcionistaRepository repository;

    public RecepcionistaService(RecepcionistaRepository repository) {
        this.repository = repository;
    }

    public List<RecepcionistaDTO> listarTodos() {
        return repository.findAll().stream()
                .map(rec -> new RecepcionistaDTO(rec.getRecId(), rec.getNome(), rec.getTelefone(), rec.getCpf()))
                .collect(Collectors.toList());
    }

    public RecepcionistaDTO buscarPorId(Long id) {
        return repository.findById(id)
                .map(rec -> new RecepcionistaDTO(rec.getRecId(), rec.getNome(), rec.getTelefone(), rec.getCpf()))
                .orElseThrow(() -> new ResourceNotFoundException("Recepcionista com ID " + id + " não encontrado."));
    }

    public RecepcionistaDTO adicionar(RecepcionistaDTO dto) {
        Recepcionista recepcionista = new Recepcionista(null, dto.getNome(), dto.getTelefone(), dto.getCpf(), true);
        repository.save(recepcionista);
        throw new ResourceCreatedException("Recepcionista criado com sucesso.");
    }

    public void deletar(Long id) {
        if (!repository.existsById(id)) {
            throw new ResourceNotFoundException("Não foi possível excluir. Recepcionista com ID " + id + " não encontrado.");
        }
        repository.deleteById(id);
        throw new ResourceDeleteNoContentException("Recepcionista deletado com sucesso.");
    }

    public Optional<RecepcionistaDTO> atualizar(Long id, RecepcionistaDTO dto) {
        Recepcionista recepcionista = repository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Não foi possível atualizar. Recepcionista com ID " + id + " não encontrado."));

        recepcionista.setNome(dto.getNome());
        recepcionista.setTelefone(dto.getTelefone());
        recepcionista.setCpf(dto.getCpf());

        repository.save(recepcionista);
        throw new ResourceUpdateNoContentException("Atualização concluída com sucesso.");
    }
}
