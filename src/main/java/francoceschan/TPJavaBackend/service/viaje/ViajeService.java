package francoceschan.TPJavaBackend.service.viaje;

import francoceschan.TPJavaBackend.model.Usuario;
import francoceschan.TPJavaBackend.model.Viaje;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;
import java.util.Optional;

public interface ViajeService {

    Viaje guardarViaje(Viaje viaje, MultipartFile imagen) throws IOException;

    List<Viaje> getAll();

    List<Viaje> getViajesDisponibles();

    void deleteById(Long idViaje);

}
