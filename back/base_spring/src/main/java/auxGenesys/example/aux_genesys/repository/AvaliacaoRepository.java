package auxGenesys.example.aux_genesys.repository;

import auxGenesys.example.aux_genesys.model.User;
import auxGenesys.example.aux_genesys.model.AvaliacaoEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.math.BigDecimal;

public interface AvaliacaoRepository extends JpaRepository<AvaliacaoEntity, Long> {

}