package francoceschan.TPJavaBackend.web.viaje;

import francoceschan.TPJavaBackend.model.Viaje;
import francoceschan.TPJavaBackend.service.viaje.ViajeService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/viaje")
@RequiredArgsConstructor
public class ViajeControllerImpl implements ViajeController{

    private final ViajeService viajeService;

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

    @Override
    @GetMapping("/getAll")
    @ResponseStatus(HttpStatus.OK)
    public List<Viaje> getAll() {
        return viajeService.getAll();
    }

    @Override
    @GetMapping("/busqueda")
    @ResponseStatus(HttpStatus.OK)
    public List<Viaje> busqueda(
            @RequestParam("preciominimo") Optional<Float> precioMinimo,
            @RequestParam("preciomaximo") Optional<Float> precioMaximo,
            @RequestParam("ciudadorigenid") Optional<Long> ciudadOrigenId,
            @RequestParam("ciudaddestinoid") Optional<Long> ciudadDestinoId,
            @RequestParam("fechainicio") Optional<String> fechaInicio,
            @RequestParam("fechafin") Optional<String> fechaFin
    ) {
        return viajeService.buscarViajes(precioMinimo, precioMaximo, ciudadOrigenId, ciudadDestinoId, fechaInicio, fechaFin);
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
