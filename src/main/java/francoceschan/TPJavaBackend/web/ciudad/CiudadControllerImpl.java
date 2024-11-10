package francoceschan.TPJavaBackend.web.ciudad;

import francoceschan.TPJavaBackend.model.Ciudad;
import francoceschan.TPJavaBackend.service.ciudad.CiudadService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/ciudad")
@RequiredArgsConstructor
public class CiudadControllerImpl implements CiudadController {

    private final CiudadService ciudadService;

    @Override
    @PostMapping("/guardar")
    @ResponseStatus(HttpStatus.CREATED)
    public Ciudad guardarCiudad(@RequestBody Ciudad ciudad){
        return ciudadService.guardarCiudad(ciudad);
    }

    @Override
    @GetMapping("/getAll")
    @ResponseStatus(HttpStatus.OK)
    public List<Ciudad> getAll(){
        return ciudadService.getAll();
    }

    @Override
    @DeleteMapping("deleteById/{idCiudad}")
    @ResponseStatus(HttpStatus.OK)
    public void deleteById(@PathVariable("idCiudad") Long idCiudad)  throws RuntimeException
    {
        ciudadService.deleteById(idCiudad);
    }
}
