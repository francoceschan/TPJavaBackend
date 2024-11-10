package francoceschan.TPJavaBackend.web.viaje;

import francoceschan.TPJavaBackend.model.Viaje;
import org.springframework.http.ResponseEntity;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;
import java.util.Optional;

public interface ViajeController {

    ResponseEntity<?> guardarViaje(Viaje viaje, MultipartFile imagen);

    List<Viaje> getAll();

    List<Viaje> busqueda(Optional<Float> precioMinimo, Optional<Float> precioMaximo, Optional<Long> ciudadOrigenId, Optional<Long> ciudadDestinoId);

    List<Viaje> getViajesDisponibles();

    void deleteById(Long idViaje);
}
