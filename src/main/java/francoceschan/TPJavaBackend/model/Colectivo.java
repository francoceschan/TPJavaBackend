package francoceschan.TPJavaBackend.model;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
@Table(name = "colectivos")
public class Colectivo {

    @Id
    private String patente;

    private Integer capacidad;
}
