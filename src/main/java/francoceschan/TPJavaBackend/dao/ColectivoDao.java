package francoceschan.TPJavaBackend.dao;

import francoceschan.TPJavaBackend.model.Colectivo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.time.LocalDateTime;
import java.util.List;

public interface ColectivoDao extends JpaRepository<Colectivo, Long> {

    void deleteByPatente(String patente);

    @Query("SELECT c FROM Colectivo c WHERE c.patente NOT IN (SELECT v.colectivo.patente FROM Viaje v WHERE :fechaInicio <= v.fechaHoraFin AND :fechaFin >= v.fechaHoraInicio)")
    List<Colectivo> findColectivosDisponiblesEntreFechas(@Param("fechaInicio") LocalDateTime fechaInicio, @Param("fechaFin") LocalDateTime fechaFin);
}
