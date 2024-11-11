package francoceschan.TPJavaBackend.web.colectivo;

import francoceschan.TPJavaBackend.model.Colectivo;
import francoceschan.TPJavaBackend.service.colectivo.ColectivoService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.List;

@RestController
@RequestMapping("/colectivo")
@RequiredArgsConstructor
public class ColectivoControllerImpl implements ColectivoController  {

    private final ColectivoService colectivoService;

    @Override
    @PostMapping("/guardar")
    @ResponseStatus(HttpStatus.CREATED)
    public Colectivo guardarColectivo(@RequestBody Colectivo colectivo){
        return colectivoService.guardarColectivo(colectivo);
    }

    @Override
    @GetMapping("/getAll")
    @ResponseStatus(HttpStatus.OK)
    public List<Colectivo> getAll(){
        return colectivoService.getAll();
    }

    @Override
    @GetMapping("/getColectivosDisponibles/{fechaInicio}/{fechaFin}")
    @ResponseStatus(HttpStatus.OK)
    public List<Colectivo> getColectivosDisponibles(@PathVariable("fechaInicio") LocalDateTime fechaInicio, @PathVariable("fechaFin") LocalDateTime fechaFin){
        return colectivoService.findColectivosDisponiblesEntreFechas(fechaInicio, fechaFin);
    }

    @Override
    @DeleteMapping("deleteById/{patente}")
    @ResponseStatus(HttpStatus.OK)
    public void deleteById(@PathVariable("patente") String patente)  throws RuntimeException
    {
        colectivoService.deleteById(patente);
    }

}
