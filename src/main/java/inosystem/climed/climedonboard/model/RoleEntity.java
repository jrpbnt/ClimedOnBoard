package inosystem.climed.climedonboard.model;

import jakarta.persistence.*;
import org.springframework.security.core.GrantedAuthority;

@Entity
@Table(name = "roles")
public class RoleEntity implements GrantedAuthority {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, unique = true)
    private String authority; // Ex: ROLE_ADMIN, ROLE_MEDICO

    public RoleEntity() {}

    public RoleEntity(Long id, String authority) {
        this.id = id;
        this.authority = authority;
    }

    @Override
    public String getAuthority() {
        return authority;
    }

    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public void setAuthority(String authority) { this.authority = authority; }

    @Override
    public String toString() {
        return authority;
    }
}