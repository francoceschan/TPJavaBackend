package francoceschan.TPJavaBackend.web.boleto;

import francoceschan.TPJavaBackend.model.Boleto;
import francoceschan.TPJavaBackend.model.dto.BoletoDTO;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

public interface BoletoController {

    Boleto comprarBoleto(BoletoDTO boletoDTO);

    List<Boleto> findBoletosByMail(String mail);
}
