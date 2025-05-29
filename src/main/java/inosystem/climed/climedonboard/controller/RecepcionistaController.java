package inosystem.climed.climedonboard.controller;

import inosystem.climed.climedonboard.dto.RecepcionistaDTO;
import inosystem.climed.climedonboard.service.RecepcionistaService;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/recepcionistas")
public class RecepcionistaController {
    private final RecepcionistaService service;

    public RecepcionistaController(RecepcionistaService service) {
        this.service = service;
    }

    @GetMapping
    public ResponseEntity<List<RecepcionistaDTO>> listarTodos() {
        return ResponseEntity.ok(service.listarTodos());
    }

    @GetMapping("/{id}")
    public ResponseEntity<RecepcionistaDTO> buscarPorId(@PathVariable Long id) {
        return ResponseEntity.ok(service.buscarPorId(id));
    }

    @PostMapping
    public ResponseEntity<RecepcionistaDTO> adicionar(@Valid @RequestBody RecepcionistaDTO recepcionista) {
        return ResponseEntity.ok(service.adicionar(recepcionista));
    }


    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletar(@PathVariable Long id) {
        service.deletar(id);
        return ResponseEntity.noContent().build();
    }

    @PutMapping("/{id}")
    public ResponseEntity<Void> atualizar(@PathVariable Long id, @Valid @RequestBody RecepcionistaDTO recepcionistaDTO) {
        service.atualizar(id, recepcionistaDTO);
        return ResponseEntity.noContent().build();
    }
}


