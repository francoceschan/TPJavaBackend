package francoceschan.TPJavaBackend.web.ciudad;

import francoceschan.TPJavaBackend.model.Ciudad;

import java.util.List;

public interface CiudadController {

    Ciudad guardarCiudad(Ciudad ciudad);

    List<Ciudad> getAll();

    void deleteById(Long idCiudad);
}
