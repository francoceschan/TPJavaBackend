package francoceschan.TPJavaBackend.service.colectivo;

import francoceschan.TPJavaBackend.dao.ColectivoDao;
import francoceschan.TPJavaBackend.dao.ViajeDao;
import francoceschan.TPJavaBackend.model.Colectivo;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ColectivoServiceImpl implements ColectivoService{

    private final ColectivoDao colectivoDao;
    private final ViajeDao viajeDao;

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
    public void deleteById(String patente) throws RuntimeException {

        // Verifico si hay viajes asociados
        if (viajeDao.countViajeByColectivo_Patente(patente) > 0) {
            throw new RuntimeException("El colectivo no se puede eliminar porque está asignado a uno o más viajes");
        }

        colectivoDao.deleteByPatente(patente);
    }
}
