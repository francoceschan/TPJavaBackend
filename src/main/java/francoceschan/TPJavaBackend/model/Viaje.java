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

    @ManyToOne
    @JoinColumn(name = "idCiudadOrigen")
    private Ciudad ciudadOrigen;

    @ManyToOne
    @JoinColumn(name = "idCiudadDestino")
    private Ciudad ciudadDestino;

    private Float precio;

    @Lob
    @Column(name = "imagen", columnDefinition = "LONGBLOB")
    private byte[] imagen;

    @Transient  // Esto evita que se mapee en la base de datos
    private String imagenBase64;

    @ManyToOne
    @JoinColumn(name = "idColectivo")
    private Colectivo colectivo;
}
