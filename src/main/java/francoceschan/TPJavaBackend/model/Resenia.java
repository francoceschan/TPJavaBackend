package francoceschan.TPJavaBackend.model;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name = "resenias")
public class Resenia {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idResenia;

    private String descripcion;

    private Integer puntaje;

    @ManyToOne
    private Viaje viaje;

    @ManyToOne
    private Pasajero pasajero;
}
