package francoceschan.TPJavaBackend.web.boleto;

import francoceschan.TPJavaBackend.model.Boleto;
import francoceschan.TPJavaBackend.model.dto.BoletoDTO;

public interface BoletoController {

    Boleto comprarBoleto(BoletoDTO boletoDTO);
}
