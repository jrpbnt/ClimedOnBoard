package inosystem.climed.climedonboard.controller;

import inosystem.climed.climedonboard.dto.EspecialidadeDTO;
import inosystem.climed.climedonboard.model.Especialidade;
import inosystem.climed.climedonboard.model.Medico;
import inosystem.climed.climedonboard.service.EspecialidadeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Collections;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import inosystem.climed.climedonboard.dto.MedicoSemContatoDTO;

@RestController
@RequestMapping("/api/v1/especialidades")
public class EspecialidadeController {



    @Autowired
    private EspecialidadeService especialidadeService;

    private MedicoSemContatoDTO convertToMedicoSemContatoDTO(Medico medico) {
        return new MedicoSemContatoDTO(
                medico.getMedId(),
                medico.getNome(),
                medico.getCpf(),
                medico.getCrm(),
                medico.getPercentual(),
                medico.isAtivo()
        );
    }

    // Adicionar nova especialidade
    @PostMapping
    public ResponseEntity<Especialidade> criarEspecialidade(@RequestBody Especialidade especialidade) {
        Especialidade novaEspecialidade = especialidadeService.criarEspecialidade(especialidade);
        return ResponseEntity.status(HttpStatus.CREATED).body(novaEspecialidade);
    }

    @GetMapping("/{id}")
    public ResponseEntity<EspecialidadeDTO<MedicoSemContatoDTO>> buscarPorId(@PathVariable Long id) {
        Especialidade especialidade = especialidadeService.buscarPorIdComMedicos(id);

        EspecialidadeDTO<MedicoSemContatoDTO> especialidadeDTO = new EspecialidadeDTO<>();
        especialidadeDTO.setId(especialidade.getId());
        especialidadeDTO.setTipoEspecialidade(especialidade.getTipoEspecialidade());

        especialidadeDTO.setMedicos(
                Optional.ofNullable(especialidade.getMedicos())
                        .orElse(Collections.emptyList())
                        .stream()
                        .map(this::convertToMedicoSemContatoDTO)
                        .collect(Collectors.toList())
        );

        return ResponseEntity.ok(especialidadeDTO); // Respondendo com o DTO ajustado ao tipo MedicoSemContatoDTO
    }







    @GetMapping
    public ResponseEntity<List<EspecialidadeDTO<MedicoSemContatoDTO>>> listarTodas() {
        List<Especialidade> especialidades = especialidadeService.listarTodas();

        List<EspecialidadeDTO<MedicoSemContatoDTO>> especialidadesDTO = especialidades.stream().map(especialidade -> {
            EspecialidadeDTO<MedicoSemContatoDTO> especialidadeDTO = new EspecialidadeDTO<>();
            especialidadeDTO.setId(especialidade.getId());
            especialidadeDTO.setTipoEspecialidade(especialidade.getTipoEspecialidade());

            especialidadeDTO.setMedicos(
                    Optional.ofNullable(especialidade.getMedicos())
                            .orElse(Collections.emptyList())
                            .stream()
                            .map(this::convertToMedicoSemContatoDTO)
                            .collect(Collectors.toList())
            );

            return especialidadeDTO;
        }).collect(Collectors.toList());

        return ResponseEntity.ok(especialidadesDTO);
    }



    // Atualizar uma especialidade
    @PutMapping("/{id}")
    public ResponseEntity<Especialidade> atualizarEspecialidade(
            @PathVariable Long id,
            @RequestBody Especialidade especialidadeAtualizada
    ) {
        Especialidade especialidade = especialidadeService.atualizarEspecialidade(id, especialidadeAtualizada);
        return ResponseEntity.ok(especialidade);
    }

    // Remover uma especialidade
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletarEspecialidade(@PathVariable Long id) {
        especialidadeService.deletarEspecialidade(id);
        return ResponseEntity.noContent().build();
    }
}
