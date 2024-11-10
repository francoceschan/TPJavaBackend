package francoceschan.TPJavaBackend.web.colectivo;

import francoceschan.TPJavaBackend.model.Colectivo;

import java.time.LocalDateTime;
import java.util.List;

public interface ColectivoController {

    List<Colectivo> getAll();

    void deleteById(String patente);

    Colectivo guardarColectivo(Colectivo colectivo)  throws RuntimeException;

    List<Colectivo> getColectivosDisponibles(LocalDateTime fechaInicio, LocalDateTime fechaFin);
}
