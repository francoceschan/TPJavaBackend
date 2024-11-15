package francoceschan.TPJavaBackend.dao;

import francoceschan.TPJavaBackend.model.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UsuarioDao extends JpaRepository<Usuario, Long> {

    Optional<Usuario> findUsuarioByMail(String mail);

    Optional<Usuario> findUsuarioByNroDocumento(String dni);
}
