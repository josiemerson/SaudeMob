package auxGenesys.example.aux_genesys.repository;

import auxGenesys.example.aux_genesys.model.EstadoEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.math.BigDecimal;

public interface EstadoRepository extends JpaRepository<EstadoEntity, Long> {

}