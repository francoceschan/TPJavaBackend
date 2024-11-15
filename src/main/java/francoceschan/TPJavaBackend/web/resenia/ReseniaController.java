package francoceschan.TPJavaBackend.web.resenia;

import francoceschan.TPJavaBackend.model.Pasajero;
import francoceschan.TPJavaBackend.model.Resenia;
import francoceschan.TPJavaBackend.model.Viaje;
import francoceschan.TPJavaBackend.model.dto.ReseniaPublicaDTO;

import java.util.List;

public interface ReseniaController {

    Resenia guardarResenia(Resenia resenia);

    Resenia findReseniaByViajeAndPasajero(Long idViaje, Long idPasajero);

    List<ReseniaPublicaDTO> findReseniasRandom();
}
