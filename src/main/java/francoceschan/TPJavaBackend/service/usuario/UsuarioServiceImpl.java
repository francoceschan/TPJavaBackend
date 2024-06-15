package francoceschan.TPJavaBackend.service.usuario;

import francoceschan.TPJavaBackend.dao.UsuarioDao;
import francoceschan.TPJavaBackend.model.Usuario;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class UsuarioServiceImpl implements UsuarioService {
    private final UsuarioDao usuarioDao;

    @Override
    public Optional<Usuario> findUsuarioByNroDocumento(String dni){
        return usuarioDao.findUsuarioByNroDocumento(dni);
    }

    @Override
    public Usuario crearUsuario(Usuario usuario){
        return usuarioDao.save(usuario);
    }
}