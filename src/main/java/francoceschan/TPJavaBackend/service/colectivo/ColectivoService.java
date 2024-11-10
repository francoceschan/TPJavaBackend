package francoceschan.TPJavaBackend.service.colectivo;

import francoceschan.TPJavaBackend.model.Colectivo;

import java.time.LocalDateTime;
import java.util.List;

public interface ColectivoService {

    Colectivo guardarColectivo(Colectivo colectivo);

    List<Colectivo> getAll();

    List<Colectivo> findColectivosDisponiblesEntreFechas(LocalDateTime fechaInicio, LocalDateTime fechaFin);

    void deleteById(String patente)  throws RuntimeException;
}
