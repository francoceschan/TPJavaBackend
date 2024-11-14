package francoceschan.TPJavaBackend.model.dto;


import francoceschan.TPJavaBackend.model.Viaje;
import lombok.Data;

@Data
public class BoletoDTO {
    private Viaje viaje;
    private String mailPasajero;
}
