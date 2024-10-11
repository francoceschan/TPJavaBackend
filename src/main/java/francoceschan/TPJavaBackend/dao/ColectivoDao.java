package francoceschan.TPJavaBackend.dao;

import francoceschan.TPJavaBackend.model.Colectivo;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ColectivoDao extends JpaRepository<Colectivo, Long> {

    void deleteByPatente(String patente);
}
