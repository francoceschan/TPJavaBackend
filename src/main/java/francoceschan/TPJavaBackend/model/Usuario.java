package francoceschan.TPJavaBackend.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.Data;

import java.util.HashSet;
import java.util.Set;


@Data
@Entity
public abstract class Usuario {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nroDocumento;

    private String nombre;

    private String apellido;

    @Column(unique = true)
    private String mail;

    @JsonIgnore // Excluye este campo de la serialización JSON
    private String password;

    @ManyToMany(fetch = FetchType.EAGER)
    private Set<Rol> roles = new HashSet<>();

}
