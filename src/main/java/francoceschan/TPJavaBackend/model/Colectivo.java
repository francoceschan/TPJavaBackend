package francoceschan.TPJavaBackend.model;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
@Table(name = "colectivos")
public class Colectivo {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idColectivo;

    private Integer capacidad;
}
