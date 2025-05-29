package inosystem.climed.climedonboard.dto;


import inosystem.climed.climedonboard.validator.CPFValid;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class EnfermeiroDTO {

    private Long id;
    private String nome;
    private String telefone;


    @CPFValid
    @NotNull(message = "CPF não pode ser nulo")
    private String cpf;

    private String especialidade;
    private String cofen;
    private String coren;
}
