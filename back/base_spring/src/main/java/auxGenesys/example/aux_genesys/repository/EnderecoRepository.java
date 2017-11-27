package auxGenesys.example.aux_genesys.repository;

import auxGenesys.example.aux_genesys.model.EnderecoEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.math.BigDecimal;

public interface EnderecoRepository extends JpaRepository<EnderecoEntity, Long> {

}