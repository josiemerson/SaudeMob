package auxGenesys.example.aux_genesys.repository;

import auxGenesys.example.aux_genesys.model.PerfilEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.math.BigDecimal;

public interface PerfilRepository extends JpaRepository<PerfilEntity, Long> {

}