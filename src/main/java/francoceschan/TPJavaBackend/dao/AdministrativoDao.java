package francoceschan.TPJavaBackend.dao;

import francoceschan.TPJavaBackend.model.Administrativo;
import francoceschan.TPJavaBackend.model.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface AdministrativoDao extends JpaRepository<Administrativo, Long> {
}
