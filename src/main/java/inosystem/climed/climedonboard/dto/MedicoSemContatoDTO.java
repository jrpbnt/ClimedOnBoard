package inosystem.climed.climedonboard.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class MedicoSemContatoDTO {

    private Long id;
    private String nome;
    private String cpf;
    private String crm;
    private int percentual;
    private boolean ativo;

    // Omitimos a propriedade contatos
}

