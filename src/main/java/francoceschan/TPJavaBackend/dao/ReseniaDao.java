package francoceschan.TPJavaBackend.dao;

import francoceschan.TPJavaBackend.model.Resenia;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface ReseniaDao extends JpaRepository<Resenia, Long> {

    @Query(value = "SELECT * FROM resenias ORDER BY RAND() LIMIT 10", nativeQuery = true)
    List<Resenia> findRandomResenias();

    Resenia findReseniaByViaje_IdViajeAndPasajero_Id(Long idViaje, Long idPasajero);
}
