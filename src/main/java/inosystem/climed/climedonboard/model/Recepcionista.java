package inosystem.climed.climedonboard.model;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "recepcionistas")
@Getter @Setter @NoArgsConstructor @AllArgsConstructor
public class Recepcionista {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long recId;

    private String nome;

    private String telefone;

    @Column(unique = true)
    private String cpf;

    private boolean ativo = true;

}