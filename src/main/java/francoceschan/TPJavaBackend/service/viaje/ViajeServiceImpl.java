package francoceschan.TPJavaBackend.service.viaje;

import francoceschan.TPJavaBackend.dao.ViajeDao;
import francoceschan.TPJavaBackend.model.Viaje;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;


@Service
@RequiredArgsConstructor
public class ViajeServiceImpl implements ViajeService {

    private final ViajeDao viajeDao;

    @Override
    public Viaje guardarViaje(Viaje viaje, MultipartFile imagen) throws IOException {
        if (imagen != null && !imagen.isEmpty()) {
            viaje.setImagen(imagen.getBytes());
        }
        return viajeDao.save(viaje);
    }

    @Override
    public  List<Viaje> getViajesDisponibles(){ return viajeDao.getViajesDisponibles(); }

    @Override
    public List<Viaje> getAll(){
        return viajeDao.findAll();
    }

    @Override
    @Transactional
    public void deleteById(Long idViaje){
        viajeDao.deleteById(idViaje);
    }
}
