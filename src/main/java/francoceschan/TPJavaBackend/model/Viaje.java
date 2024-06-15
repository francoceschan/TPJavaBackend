package francoceschan.TPJavaBackend.model;

import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDateTime;

@Entity
@Data
@Table(name = "viajes")
public class Viaje {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idViaje;

    private String nombre;

    private String descripcion;

    private LocalDateTime fechaHora;
    /*
    @ManyToOne
    @JoinColumn(name = "idCiudad")
    private Ciudad origen;

    @ManyToOne
    @JoinColumn(name = "idCiudad")
    private Ciudad destino;
    */
    private Float precio;

    @ManyToOne
    @JoinColumn(name = "idColectivo")
    private Colectivo colectivo;
}