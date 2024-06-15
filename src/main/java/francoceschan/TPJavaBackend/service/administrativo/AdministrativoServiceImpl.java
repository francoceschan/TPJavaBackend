package francoceschan.TPJavaBackend.service.administrativo;

import francoceschan.TPJavaBackend.dao.AdministrativoDao;
import francoceschan.TPJavaBackend.model.Administrativo;
import francoceschan.TPJavaBackend.model.Usuario;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AdministrativoServiceImpl implements AdministrativoService{

    private final AdministrativoDao administrativoDao;

    @Override
    public Administrativo crearAdministrativo(Administrativo administrativo){
        return administrativoDao.save(administrativo);
    }
}
