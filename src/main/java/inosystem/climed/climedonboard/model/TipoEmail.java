package inosystem.climed.climedonboard.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "tipo_email")
@Getter
@Setter
public class TipoEmail {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "tipoe_id")
    private Long tipoeId;

    @Column(length = 50)
    private String tipo;
}