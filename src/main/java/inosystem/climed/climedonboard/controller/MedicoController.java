package inosystem.climed.climedonboard.controller;

import inosystem.climed.climedonboard.dto.MedicoDTO;
import inosystem.climed.climedonboard.service.MedicoService;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/medicos")
public class MedicoController {
    private final MedicoService service;

    public MedicoController(MedicoService service) {
        this.service = service;
    }

    @GetMapping
    public ResponseEntity<List<MedicoDTO>> listarTodos() {
        return ResponseEntity.ok(service.listarTodos());
    }

    @GetMapping("/{id}")
    public ResponseEntity<MedicoDTO> buscarPorId(@PathVariable Long id) {
        return ResponseEntity.ok(service.buscarPorId(id));
    }

    @PostMapping
    public ResponseEntity<MedicoDTO> adicionar(@Valid @RequestBody MedicoDTO medico) {
        return ResponseEntity.ok(service.adicionar(medico));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletar(@PathVariable Long id) {
        service.deletar(id);
        return ResponseEntity.noContent().build();
    }

    @PutMapping("/{id}")
    public ResponseEntity<Void> atualizar(@PathVariable Long id, @Valid @RequestBody MedicoDTO medicoDTO) {
        service.atualizar(id, medicoDTO);
        return ResponseEntity.noContent().build();
    }
}
