package francoceschan.TPJavaBackend.model.dto;

import francoceschan.TPJavaBackend.model.Viaje;
import lombok.Data;

@Data
public class ViajeResponseDTO {
    private Viaje viaje;
    private String imagenBase64;
}
