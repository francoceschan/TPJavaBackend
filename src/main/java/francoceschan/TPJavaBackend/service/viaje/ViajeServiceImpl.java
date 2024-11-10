package francoceschan.TPJavaBackend.service.viaje;

import francoceschan.TPJavaBackend.dao.ViajeDao;
import francoceschan.TPJavaBackend.model.Viaje;
import jakarta.persistence.criteria.Predicate;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;


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

    @Override
    public List<Viaje> buscarViajes(Optional<Float> precioMinimo, Optional<Float> precioMaximo, Optional<Long> ciudadOrigenId, Optional<Long> ciudadDestinoId) {
        return viajeDao.findAll((Specification<Viaje>) (root, query, criteriaBuilder) -> {
            List<Predicate> predicates = new ArrayList<>();

            precioMinimo.ifPresent(min -> predicates.add(criteriaBuilder.greaterThanOrEqualTo(root.get("precio"), min)));
            precioMaximo.ifPresent(max -> predicates.add(criteriaBuilder.lessThanOrEqualTo(root.get("precio"), max)));
            ciudadOrigenId.ifPresent(origenId -> predicates.add(criteriaBuilder.equal(root.get("ciudadOrigen").get("id"), origenId)));
            ciudadDestinoId.ifPresent(destinoId -> predicates.add(criteriaBuilder.equal(root.get("ciudadDestino").get("id"), destinoId)));

            return criteriaBuilder.and(predicates.toArray(new Predicate[0]));
        });
    }
}
