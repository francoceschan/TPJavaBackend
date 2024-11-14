package francoceschan.TPJavaBackend.service.boleto;

import francoceschan.TPJavaBackend.dao.BoletoDao;
import francoceschan.TPJavaBackend.exceptions.BoletoException;
import francoceschan.TPJavaBackend.model.Boleto;
import francoceschan.TPJavaBackend.model.Pasajero;
import francoceschan.TPJavaBackend.model.dto.BoletoDTO;
import francoceschan.TPJavaBackend.service.pasajero.PasajeroService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class BoletoServiceImpl implements BoletoService {

    private final BoletoDao boletoDao;

    private final PasajeroService pasajeroService;

    @Override
    public Boleto comprarBoleto(BoletoDTO boletoDTO){

        Integer butaca = boletoDTO.getViaje().getColectivo().getCapacidad() -  boletoDao.countBoletoByViaje_IdViaje(boletoDTO.getViaje().getIdViaje());

        if(butaca <= 0){
            throw new BoletoException("No hay butacas disponibles");
        }

        Pasajero pasajero = pasajeroService.findPasajeroByMail(boletoDTO.getMailPasajero());

        Boleto boleto = new Boleto();

        boleto.setPasajero(pasajero);
        boleto.setViaje(boletoDTO.getViaje());
        boleto.setButaca(butaca);

        return boletoDao.save(boleto);
    }

}
