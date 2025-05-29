package inosystem.climed.climedonboard.controller;

import inosystem.climed.climedonboard.dto.EnfermeiroDTO;
import inosystem.climed.climedonboard.service.EnfermeiroService;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/enfermeiros")
public class EnfermeiroController {
    private final EnfermeiroService service;

    public EnfermeiroController(EnfermeiroService service) {
        this.service = service;
    }

    @GetMapping
    public ResponseEntity<List<EnfermeiroDTO>> listarTodos() {
        return ResponseEntity.ok(service.listarTodos());
    }

    @GetMapping("/{id}")
    public ResponseEntity<EnfermeiroDTO> buscarPorId(@PathVariable Long id) {
        return ResponseEntity.ok(service.buscarPorId(id));
    }
    @PostMapping
    public ResponseEntity<EnfermeiroDTO> adicionar(@Valid @RequestBody EnfermeiroDTO enfermeiro) {
        return ResponseEntity.ok(service.adicionar(enfermeiro));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletar(@PathVariable Long id) {
        service.deletar(id);
        return ResponseEntity.noContent().build();
    }

    @PutMapping("/{id}")
    public ResponseEntity<Void> atualizar(@PathVariable Long id, @Valid @RequestBody EnfermeiroDTO enfermeiroDTO) {
        service.atualizar(id, enfermeiroDTO);
        return ResponseEntity.noContent().build();
    }
}
