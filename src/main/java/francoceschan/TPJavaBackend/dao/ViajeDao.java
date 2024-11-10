package francoceschan.TPJavaBackend.dao;

import francoceschan.TPJavaBackend.model.Viaje;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface ViajeDao extends JpaRepository<Viaje, Long>, JpaSpecificationExecutor<Viaje> {

    @Query(value = "SELECT * FROM viajes WHERE fecha_hora_inicio > NOW()", nativeQuery = true)
    List<Viaje> getViajesDisponibles();

    long countViajeByColectivo_Patente(String patente);
}
