package francoceschan.TPJavaBackend.service;

import francoceschan.TPJavaBackend.dao.UsuarioDao;
import francoceschan.TPJavaBackend.model.Usuario;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
@RequiredArgsConstructor
public class UserDetailsServiceImpl implements UserDetailsService {

    private final UsuarioDao usuarioDao;

    //Devuelvo el usuario como User porque es el tipo que necesita spring security
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Usuario usuario = usuarioDao.findUsuarioByMail(username)
                .orElseThrow(() -> new UsernameNotFoundException("El usuario " + username +" no existe"));
        System.out.println(usuario);
        //Faltan los roles
        return new User(usuario.getMail(), usuario.getPassword(), new ArrayList<>());
    }
}
