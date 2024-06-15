package francoceschan.TPJavaBackend.service.colectivo;

import francoceschan.TPJavaBackend.dao.ColectivoDao;
import francoceschan.TPJavaBackend.model.Colectivo;
import org.springframework.stereotype.Service;

@Service
public class ColectivoServiceImpl implements ColectivoService{

    private ColectivoDao colectivoDao;

    @Override
    public Colectivo guardarColectivo(Colectivo colectivo){
        return colectivoDao.save(colectivo);
    }
}
