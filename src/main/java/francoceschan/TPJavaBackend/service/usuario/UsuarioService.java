package francoceschan.TPJavaBackend.service.usuario;

import francoceschan.TPJavaBackend.dao.UsuarioDao;
import francoceschan.TPJavaBackend.model.Usuario;

import java.util.Optional;

public interface UsuarioService {

    Optional<Usuario> findUsuarioByNroDocumento(String dni);

    Usuario crearUsuario(Usuario usuario);
}
