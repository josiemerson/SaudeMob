package auxGenesys.example.aux_genesys.repository;

import auxGenesys.example.aux_genesys.model.BairroEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.math.BigDecimal;

public interface BairroRepository extends JpaRepository<BairroEntity, Long> {

}