package francoceschan.TPJavaBackend.model;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
@Table(name = "ciudades")
public class Ciudad {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idCiudad;

    private String nombre;
}
