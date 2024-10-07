package francoceschan.TPJavaBackend.config;

import francoceschan.TPJavaBackend.dao.UsuarioDao;
import francoceschan.TPJavaBackend.model.Usuario;
import francoceschan.TPJavaBackend.model.dto.AuthLoginRequest;
import francoceschan.TPJavaBackend.model.dto.AuthResponse;
import francoceschan.TPJavaBackend.utils.JwtUtils;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class UserDetailsServiceImpl implements UserDetailsService {

    private final UsuarioDao usuarioDao;

    @Autowired
    private JwtUtils jwtUtils;

    @Autowired
    private PasswordEncoder passwordEncoder;

    //Devuelvo el usuario como User porque es el tipo que necesita spring security
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        System.out.println("Buscando usuario...");
        Usuario usuario = usuarioDao.findUsuarioByMail(username)
                .orElseThrow(() -> new UsernameNotFoundException("El usuario no existe"));
        System.out.println("Usuario encontrado: " + usuario.getMail());

        if (usuario.getRoles() == null || usuario.getRoles().isEmpty()) {
            throw new UsernameNotFoundException("El usuario no tiene roles asignados");
        }

        System.out.println("Roles encontrados: " + usuario.getRoles());

        List<SimpleGrantedAuthority> authorityList = new ArrayList<>();
        System.out.println("hola");
        usuario.getRoles()
                .forEach(role -> authorityList.add(new SimpleGrantedAuthority("ROLE_".concat(role.getNombre()))));

        usuario.getRoles().stream()
                .flatMap(role -> role.getPermisos().stream())
                .forEach(permiso -> authorityList.add(new SimpleGrantedAuthority(permiso.getNombre())));
        System.out.println(authorityList);
        return new User(usuario.getMail(), usuario.getPassword(), authorityList);
    }

    public AuthResponse loginUser(AuthLoginRequest authLoginRequest){
        String username = authLoginRequest.username();
        String password = authLoginRequest.password();

        Authentication authentication = this.authenticate(username,password);
        SecurityContextHolder.getContext().setAuthentication(authentication);

        String accessToken = jwtUtils.createToken(authentication);

        AuthResponse authResponse = new AuthResponse(username,"Usuario logueado",accessToken,true);

        return  authResponse;
    }

    public Authentication authenticate(String username, String password){
        UserDetails userDetails = this.loadUserByUsername(username);

        if(userDetails == null){
            throw  new BadCredentialsException("Usuario y/o contraseña invalido.");
        }

        if(!passwordEncoder.matches(password, userDetails.getPassword())){
            throw new BadCredentialsException("Usuario y/o contraseña invalido.");
        }

        return new UsernamePasswordAuthenticationToken(username,userDetails.getPassword(),userDetails.getAuthorities());
    }
}
