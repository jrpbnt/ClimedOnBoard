package inosystem.climed.climedonboard.service;

import inosystem.climed.climedonboard.model.Especialidade;
import inosystem.climed.climedonboard.repository.EspecialidadeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EspecialidadeService {

    @Autowired
    private EspecialidadeRepository especialidadeRepository;

    // Criar uma nova especialidade
    public Especialidade criarEspecialidade(Especialidade especialidade) {
        return especialidadeRepository.save(especialidade);
    }

    // Buscar especialidade por ID
    public Especialidade buscarPorId(Long id) {
        return especialidadeRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Especialidade com ID " + id + " não encontrada."));
    }

    // Listar todas as especialidades
    public List<Especialidade> listarTodas() {
        return especialidadeRepository.findAll();
    }


    // Atualizar uma especialidade existente
    public Especialidade atualizarEspecialidade(Long id, Especialidade especialidadeAtualizada) {
        Especialidade especialidade = buscarPorId(id); // Verifica se a especialidade existe
        especialidade.setTipoEspecialidade(especialidadeAtualizada.getTipoEspecialidade());
        return especialidadeRepository.save(especialidade);
    }

    // Deletar uma especialidade
    public void deletarEspecialidade(Long id) {
        buscarPorId(id); // Se não encontrar, lança exceção
        especialidadeRepository.deleteById(id);
    }
    public Especialidade buscarPorIdComMedicos(Long id) {
        return especialidadeRepository.findByIdWithMedicos(id)
                .orElseThrow(() -> new RuntimeException("Especialidade com ID " + id + " não encontrada."));
    }



}

