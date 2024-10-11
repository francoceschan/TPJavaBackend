package francoceschan.TPJavaBackend.service.colectivo;

import francoceschan.TPJavaBackend.model.Colectivo;

import java.util.List;

public interface ColectivoService {

    Colectivo guardarColectivo(Colectivo colectivo);

    List<Colectivo> getAll();

    void deleteById(String patente);
}
