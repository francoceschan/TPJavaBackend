package francoceschan.TPJavaBackend.model;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name = "boletos")
public class Boleto {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idBoleto;

    private Integer butaca;

    @ManyToOne
    private Viaje viaje;

    @ManyToOne
    private Pasajero pasajero;
}
