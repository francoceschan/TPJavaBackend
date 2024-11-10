package francoceschan.TPJavaBackend.dao;

import francoceschan.TPJavaBackend.model.Ciudad;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CiudadDao extends JpaRepository<Ciudad, Long> {
}
