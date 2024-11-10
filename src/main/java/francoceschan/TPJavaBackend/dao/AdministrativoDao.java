package francoceschan.TPJavaBackend.dao;

import francoceschan.TPJavaBackend.model.Administrativo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AdministrativoDao extends JpaRepository<Administrativo, Long> {
}
