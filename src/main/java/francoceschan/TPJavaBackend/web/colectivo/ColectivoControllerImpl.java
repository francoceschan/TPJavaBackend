package francoceschan.TPJavaBackend.web.colectivo;

import francoceschan.TPJavaBackend.dao.UsuarioDao;
import francoceschan.TPJavaBackend.model.Administrativo;
import francoceschan.TPJavaBackend.model.Colectivo;
import francoceschan.TPJavaBackend.model.Usuario;
import francoceschan.TPJavaBackend.service.administrativo.AdministrativoService;
import francoceschan.TPJavaBackend.service.colectivo.ColectivoService;
import francoceschan.TPJavaBackend.service.usuario.UsuarioService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/colectivo")
@RequiredArgsConstructor
//@PreAuthorize("hasAuthority('CREATE')")
public class ColectivoControllerImpl implements ColectivoController {

    private ColectivoService colectivoService;

    private final UsuarioService usuarioService;

    private final AdministrativoService administrativoService;

    @Override
    @PostMapping("/guardar")
    @ResponseStatus(HttpStatus.OK)
    //@PreAuthorize("hasAuthority('CREATE')")
    public Colectivo guardarColectivo(Colectivo colectivo){
        return colectivoService.guardarColectivo(colectivo);
    }

    @GetMapping("/get")
    @ResponseStatus(HttpStatus.OK)
    public String get(){
        Administrativo usuario = new Administrativo();
        usuario.setApellido("Ceschan");
        usuario.setNombre("Franco");
        usuario.setMail("francoceschan@gmail.com");
        usuario.setNroDocumento("39504981");
        usuario.setPassword("tpjava2024");

        administrativoService.crearAdministrativo(usuario);
        System.out.println(usuarioService.findUsuarioByNroDocumento("39504981"));

        return "hola";
    }

    @GetMapping("/getPermiso")
    @ResponseStatus(HttpStatus.OK)
    public String getPermiso(){
        return "hola permiso";
    }
}
