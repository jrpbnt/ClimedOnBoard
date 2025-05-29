package inosystem.climed.climedonboard.model;

import jakarta.persistence.*;
import lombok.*;


@Entity
@Table(name = "enfermeiros")
@Getter @Setter @NoArgsConstructor
@AllArgsConstructor
public class Enfermeiro {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long enfId;

    private String nome;

    private String telefone;

    @Column(unique = true)
    private String cpf;

    private boolean ativo = true;


    private String especialidade;

    @Column(unique = true, nullable = false)
    private String cofen;

    @Column(unique = true, nullable = false)
    private String coren;
}