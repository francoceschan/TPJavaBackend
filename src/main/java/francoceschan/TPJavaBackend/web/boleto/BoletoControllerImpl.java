package francoceschan.TPJavaBackend.web.boleto;

import francoceschan.TPJavaBackend.model.Boleto;
import francoceschan.TPJavaBackend.model.dto.BoletoDTO;
import francoceschan.TPJavaBackend.service.boleto.BoletoService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

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
}
