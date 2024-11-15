package francoceschan.TPJavaBackend.model.dto;

import francoceschan.TPJavaBackend.model.Viaje;
import lombok.Data;

@Data
public class ReseniaPublicaDTO {
    private String descripcion;
    private Integer puntaje;
    private Viaje viaje;
}
