package francoceschan.TPJavaBackend.service.pasajero;

import francoceschan.TPJavaBackend.model.Pasajero;

public interface PasajeroService {

    Pasajero crearPasajero(Pasajero pasajero);

    Pasajero findPasajeroByMail(String mail);

}
