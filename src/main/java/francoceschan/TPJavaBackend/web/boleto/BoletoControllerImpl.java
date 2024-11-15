package francoceschan.TPJavaBackend.web.boleto;

import francoceschan.TPJavaBackend.model.Boleto;
import francoceschan.TPJavaBackend.model.Pasajero;
import francoceschan.TPJavaBackend.model.dto.BoletoDTO;
import francoceschan.TPJavaBackend.service.boleto.BoletoService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/boleto")
@RequiredArgsConstructor
public class BoletoControllerImpl implements BoletoController{

    private final BoletoService boletoService;

    @Override
    @PostMapping("/comprarBoleto")
    @ResponseStatus(HttpStatus.CREATED)
    public Boleto comprarBoleto(@RequestBody BoletoDTO boletoDTO){
        return boletoService.comprarBoleto(boletoDTO);
    }

    @Override
    @GetMapping("findBoletosByMail/{mail}")
    @ResponseStatus(HttpStatus.OK)
    public List<Boleto> findBoletosByMail(@PathVariable("mail") String mail){
        return boletoService.findBoletoByMail(mail);
    }
}
