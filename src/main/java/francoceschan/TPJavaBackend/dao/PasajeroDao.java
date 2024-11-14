package francoceschan.TPJavaBackend.dao;

import francoceschan.TPJavaBackend.model.Pasajero;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PasajeroDao extends JpaRepository<Pasajero, Long> {

    Pasajero findPasajeroByMail(String mail);
}
