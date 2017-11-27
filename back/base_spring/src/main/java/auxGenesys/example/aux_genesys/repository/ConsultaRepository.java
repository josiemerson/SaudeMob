package auxGenesys.example.aux_genesys.repository;

import auxGenesys.example.aux_genesys.model.ConsultaEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.math.BigDecimal;

public interface ConsultaRepository extends JpaRepository<ConsultaEntity, Long> {

}