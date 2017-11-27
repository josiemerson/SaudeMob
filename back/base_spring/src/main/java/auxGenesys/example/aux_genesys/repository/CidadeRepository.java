package auxGenesys.example.aux_genesys.repository;

import auxGenesys.example.aux_genesys.model.CidadeEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.math.BigDecimal;

public interface CidadeRepository extends JpaRepository<CidadeEntity, Long> {

}