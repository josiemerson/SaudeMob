package auxGenesys.example.aux_genesys.repository;

import auxGenesys.example.aux_genesys.model.PaisEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.math.BigDecimal;

public interface PaisRepository extends JpaRepository<PaisEntity, Long> {

}