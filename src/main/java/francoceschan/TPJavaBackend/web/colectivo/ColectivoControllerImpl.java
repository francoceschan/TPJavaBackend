package francoceschan.TPJavaBackend.web.colectivo;

import francoceschan.TPJavaBackend.dao.PermisoDao;
import francoceschan.TPJavaBackend.dao.RolDao;
import francoceschan.TPJavaBackend.dao.UsuarioDao;
import francoceschan.TPJavaBackend.model.*;
import francoceschan.TPJavaBackend.service.administrativo.AdministrativoService;
import francoceschan.TPJavaBackend.service.colectivo.ColectivoService;
import francoceschan.TPJavaBackend.service.usuario.UsuarioService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.*;

@RestController
@RequestMapping("/colectivo")
@RequiredArgsConstructor
//@PreAuthorize("hasAuthority('CREATE')")
public class ColectivoControllerImpl implements ColectivoController {

    private final ColectivoService colectivoService;

    private final UsuarioService usuarioService;

    private final AdministrativoService administrativoService;

    private final PermisoDao permisoDao;

    private final RolDao rolDao;

    private final UsuarioDao usuarioDao;

    @Override
    @PostMapping("/guardar")
    @ResponseStatus(HttpStatus.CREATED)
    //@PreAuthorize("hasAuthority('CREATE')")
    //@PreAuthorize("hasAnyRole('ROLE_ADMINISTRATIVO')")
    public Colectivo guardarColectivo(@RequestBody Colectivo colectivo){
        return colectivoService.guardarColectivo(colectivo);
    }

    @GetMapping("/getAll")
    @ResponseStatus(HttpStatus.OK)
    public List<Colectivo> getAll(){
        return colectivoService.getAll();
    }

    @DeleteMapping("deleteById/{patente}")
    @ResponseStatus(HttpStatus.OK)
    public void deleteById(@PathVariable("patente") String patente){
        colectivoService.deleteById(patente);
    }

/*    @GetMapping("/get")
    @ResponseStatus(HttpStatus.OK)
    public String get(){

*//*        Permiso permisoCREATE = new Permiso();
        permisoCREATE.setNombre("CREATE");

        Permiso permisoREAD = new Permiso();
        permisoREAD.setNombre("READ");

        Permiso permisoUPDATE = new Permiso();
        permisoUPDATE.setNombre("UPDATE");

        Permiso permisoDELETE = new Permiso();
        permisoDELETE.setNombre("DELETE");

        Set<Permiso> permisos = new HashSet<>();
        permisos.add(permisoCREATE);
        permisos.add(permisoREAD);
        permisos.add(permisoUPDATE);
        permisos.add(permisoDELETE);

        permisos.forEach(permiso -> permisoDao.save(permiso));

        Rol rolAdmin = new Rol();
        rolAdmin.setNombre("ADMINISTRATIVO");
        rolAdmin.setPermisos(permisos);

        rolDao.save(rolAdmin);

        Administrativo usuario = new Administrativo();
        usuario.setApellido("Ceschan");
        usuario.setNombre("Franco");
        usuario.setMail("francoceschan@gmail.com");
        usuario.setNroDocumento("39504981");
        usuario.setPassword("tpjava2024");
        Set<Rol> roles = new HashSet<>();
        roles.add(rolAdmin);
        usuario.setRoles(roles);

        administrativoService.crearAdministrativo(usuario);
        System.out.println(usuarioService.findUsuarioByNroDocumento("39504981"));
*//*
        Optional<Usuario> usuario = usuarioDao.findUsuarioByMail("francoceschan@gmail.com");

        System.out.println(usuario.get().getRoles());

        return "hola";
    }*/

/*    @GetMapping("/getPermiso")
    //@PreAuthorize("hasAuthority('READ')")
    public String getPermiso(){
        Optional<Usuario> usuario = usuarioDao.findUsuarioByMail("francoceschan@gmail.com");

        return "hola permiso";
    }*/
}
