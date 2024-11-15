package francoceschan.TPJavaBackend.service.boleto;

import francoceschan.TPJavaBackend.model.Boleto;
import francoceschan.TPJavaBackend.model.dto.BoletoDTO;

import java.util.List;

public interface BoletoService {

    Boleto comprarBoleto(BoletoDTO boletoDTO);

    List<Boleto> findBoletoByMail(String mail);
}
