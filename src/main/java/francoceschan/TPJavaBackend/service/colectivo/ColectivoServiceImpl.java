package francoceschan.TPJavaBackend.service.colectivo;

import francoceschan.TPJavaBackend.dao.ColectivoDao;
import francoceschan.TPJavaBackend.model.Colectivo;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ColectivoServiceImpl implements ColectivoService{

    private final ColectivoDao colectivoDao;

    @Override
    public Colectivo guardarColectivo(Colectivo colectivo){
        return colectivoDao.save(colectivo);
    }

    @Override
    public List<Colectivo> getAll(){
        return colectivoDao.findAll();
    }

    @Override
    @Transactional
    public void deleteById(String patente){
        colectivoDao.deleteByPatente(patente);
    }
}
