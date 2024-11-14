package francoceschan.TPJavaBackend.dao;

import francoceschan.TPJavaBackend.model.Boleto;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BoletoDao extends JpaRepository<Boleto, Long> {

    Integer countBoletoByViaje_IdViaje(Long idViaje);

}
