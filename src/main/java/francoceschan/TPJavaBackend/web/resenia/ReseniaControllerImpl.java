package francoceschan.TPJavaBackend.web.resenia;

import francoceschan.TPJavaBackend.model.Colectivo;
import francoceschan.TPJavaBackend.model.Resenia;
import francoceschan.TPJavaBackend.model.dto.ReseniaPublicaDTO;
import francoceschan.TPJavaBackend.service.resenia.ReseniaService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.List;

@RestController
@RequestMapping("/resenia")
@RequiredArgsConstructor
public class ReseniaControllerImpl implements ReseniaController{

    private final ReseniaService reseniaService;

    @Override
    @PostMapping("/guardar")
    @ResponseStatus(HttpStatus.CREATED)
    public Resenia guardarResenia(@RequestBody Resenia resenia){
        return reseniaService.guardarResenia(resenia);
    }

    @Override
    @GetMapping("/findReseniaByViajeAndPasajero/{idViaje}/{idPasajero}")
    @ResponseStatus(HttpStatus.OK)
    public Resenia findReseniaByViajeAndPasajero(@PathVariable("idViaje") Long idViaje, @PathVariable("idPasajero") Long idPasajero) {
        return reseniaService.findReseniaByViajeAndPasajero(idViaje, idPasajero);
    }

    @Override
    @GetMapping("/findReseniasRandom")
    @ResponseStatus(HttpStatus.OK)
    public  List<ReseniaPublicaDTO> findReseniasRandom(){
        return reseniaService.findReseniasRandom();
    }

}
