package auxGenesys.example.aux_genesys.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import auxGenesys.example.aux_genesys.model.CoordinatesEntity;

public interface CoordinatesRepository extends JpaRepository<CoordinatesEntity, Long> {
    List<CoordinatesEntity> findById(Long id);
}