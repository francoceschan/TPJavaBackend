package francoceschan.TPJavaBackend.service.ciudad;

import francoceschan.TPJavaBackend.dao.CiudadDao;
import francoceschan.TPJavaBackend.model.Ciudad;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CiudadServiceImpl implements CiudadService{

    private final CiudadDao ciudadDao;

    @Override
    public Ciudad guardarCiudad(Ciudad ciudad){ return ciudadDao.save(ciudad); }

    @Override
    public List<Ciudad> getAll(){ return ciudadDao.findAll(); }

    @Override
    @Transactional
    public void deleteById(Long idCiudad) {

        ciudadDao.deleteById(idCiudad);
    }
}
