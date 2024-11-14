package francoceschan.TPJavaBackend.service.pasajero;

import francoceschan.TPJavaBackend.dao.PasajeroDao;
import francoceschan.TPJavaBackend.model.Pasajero;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class PasajeroServiceImpl implements PasajeroService{

    private final PasajeroDao pasajeroDao;

    @Override
    public Pasajero crearPasajero(Pasajero pasajero){

        BCryptPasswordEncoder bCryptPasswordEncoder = new BCryptPasswordEncoder();
        pasajero.setPassword(bCryptPasswordEncoder.encode(pasajero.getPassword()));

        return pasajeroDao.save(pasajero);
    }

    @Override
    public Pasajero findPasajeroByMail(String mail){
        return pasajeroDao.findPasajeroByMail(mail);
    }
}
