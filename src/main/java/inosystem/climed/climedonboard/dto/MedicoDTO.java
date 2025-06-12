package inosystem.climed.climedonboard.dto;

import inosystem.climed.climedonboard.validator.CPFValid;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class MedicoDTO {

    private Long id;
    private String nome;
    private List<ContatoDTO> contatos;

    @CPFValid
    @NotNull(message = "CPF não pode ser nulo")
    private String cpf;

    private List<EspecialidadeDTO> especialidades;



    private String crm;
    private int percentual;
    private boolean ativo;


    public MedicoDTO(Long id, String nome, String cpf, String crm, int percentual, List<ContatoDTO> contatos, boolean ativo) {
        this.id = id;
        this.nome = nome;
        this.cpf = cpf;
        this.crm = crm;
        this.percentual = percentual;

        this.ativo = ativo;
    }

}