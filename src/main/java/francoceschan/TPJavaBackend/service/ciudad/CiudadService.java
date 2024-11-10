package francoceschan.TPJavaBackend.service.ciudad;

import francoceschan.TPJavaBackend.model.Ciudad;

import java.util.List;

public interface CiudadService {

    Ciudad guardarCiudad(Ciudad ciudad);

    List<Ciudad> getAll();

    void deleteById(Long idCiudad);
}
