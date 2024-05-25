package francoceschan.TPJavaBackend.dao;

import francoceschan.TPJavaBackend.model.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UsuarioDao extends JpaRepository<Usuario, Long> {
}
