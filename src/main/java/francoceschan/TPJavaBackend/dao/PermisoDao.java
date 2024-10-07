package francoceschan.TPJavaBackend.dao;

import francoceschan.TPJavaBackend.model.Permiso;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PermisoDao extends JpaRepository<Permiso, Long> {
}
