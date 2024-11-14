package francoceschan.TPJavaBackend.service.boleto;

import francoceschan.TPJavaBackend.model.Boleto;
import francoceschan.TPJavaBackend.model.dto.BoletoDTO;

public interface BoletoService {

    Boleto comprarBoleto(BoletoDTO boletoDTO);
}
