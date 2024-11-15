package francoceschan.TPJavaBackend.service.resenia;

import francoceschan.TPJavaBackend.dao.ReseniaDao;
import francoceschan.TPJavaBackend.model.Pasajero;
import francoceschan.TPJavaBackend.model.Resenia;
import francoceschan.TPJavaBackend.model.Viaje;
import francoceschan.TPJavaBackend.model.dto.ReseniaPublicaDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class ReseniaServiceImpl implements ReseniaService{

    private final ReseniaDao reseniaDao;

    @Override
    public Resenia guardarResenia(Resenia resenia){
       return reseniaDao.save(resenia);
    }

    @Override
    public Resenia findReseniaByViajeAndPasajero(Long idViaje, Long idPasajero){
        return reseniaDao.findReseniaByViaje_IdViajeAndPasajero_Id(idViaje, idPasajero);
    }

    @Override
    public List<ReseniaPublicaDTO> findReseniasRandom(){
        List<Resenia> resenias = reseniaDao.findRandomResenias();

        return resenias.stream()
                .map(resenia -> {
                    ReseniaPublicaDTO dto = new ReseniaPublicaDTO();
                    dto.setDescripcion(resenia.getDescripcion());
                    dto.setPuntaje(resenia.getPuntaje());
                    dto.setViaje(resenia.getViaje());
                    return dto;
                })
                .collect(Collectors.toList());
    }
}
