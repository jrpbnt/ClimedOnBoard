package inosystem.climed.climedonboard.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "tipo_telefone")
@Getter
@Setter
public class TipoTelefone {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "telt_id")
    private Long teltId;

    @Column(length = 50)
    private String tipo;
}
