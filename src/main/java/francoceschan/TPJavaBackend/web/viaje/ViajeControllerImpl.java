package francoceschan.TPJavaBackend.web.viaje;

import francoceschan.TPJavaBackend.model.Viaje;
import francoceschan.TPJavaBackend.service.viaje.ViajeService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.Base64;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/viaje")
@RequiredArgsConstructor
public class ViajeControllerImpl implements ViajeController{

    private final ViajeService viajeService;

/*    @Override
    @PostMapping("/guardar")
    @ResponseStatus(HttpStatus.CREATED)
    //@PreAuthorize("hasAuthority('CREATE')")
    //@PreAuthorize("hasAnyRole('ROLE_ADMINISTRATIVO')")
    public Viaje guardarViaje(@RequestBody Viaje viaje){
        return viajeService.guardarViaje(viaje);
    }*/

    @Override
    @PostMapping("/guardar")
    @ResponseStatus(HttpStatus.CREATED)
    public ResponseEntity<?> guardarViaje(@RequestPart("viaje") Viaje viaje,
                                          @RequestPart(value = "imagen", required = false) MultipartFile imagen) {
        try {
            Viaje viajeGuardado = viajeService.guardarViaje(viaje, imagen);
            return ResponseEntity.status(HttpStatus.CREATED).body(viajeGuardado);
        } catch (IOException e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Error al guardar el viaje");
        }
    }

/*    @Override
    @GetMapping("/getAll")
    @ResponseStatus(HttpStatus.OK)
    public List<Viaje> getAll(){
        return viajeService.getAll();
    }*/

/*    @PostMapping("/obtener/{id}")
    public ResponseEntity<?> obtenerViaje(@PathVariable Long id) {
        Optional<Viaje> viajeOpt = viajeService.obtenerViaje(id);
        if (viajeOpt.isPresent()) {
            Viaje viaje = viajeOpt.get();

            // Convierte el byte[] de la imagen a Base64
            if (viaje.getImagen() != null) {
                String imagenBase64 = Base64.getEncoder().encodeToString(viaje.getImagen());
                viaje.setImagenBase64(imagenBase64);
            }

            return ResponseEntity.ok(viaje);
        }
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Viaje no encontrado");
    }*/

    @Override
    @GetMapping("/getAll")
    @ResponseStatus(HttpStatus.OK)
    public List<Viaje> getAll() {
        return viajeService.getAll();
    }

    @Override
    @GetMapping("/getViajesDisponibles")
    @ResponseStatus(HttpStatus.OK)
    public List<Viaje> getViajesDisponibles() {
        return viajeService.getViajesDisponibles();
    }


    @Override
    @DeleteMapping("deleteById/{idViaje}")
    @ResponseStatus(HttpStatus.OK)
    public void deleteById(@PathVariable("idViaje") Long idViaje){
        viajeService.deleteById(idViaje);
    }

}
