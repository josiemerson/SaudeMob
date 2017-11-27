package auxGenesys.example.aux_genesys.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import auxGenesys.example.aux_genesys.model.CoordinatesEntity;
import auxGenesys.example.aux_genesys.repository.CoordinatesRepository;

@Service
public class CoordinatesService {
    @Autowired
    private CoordinatesRepository coordinatesRepository;

    public List<CoordinatesEntity> getAll() {
        return coordinatesRepository.findAll();
    }

    public List<CoordinatesEntity> findCoordinatesPerUser(Long id){
        try{
            return coordinatesRepository.findById(id);
        } catch(Exception ex){
            return null;
        }
    }
}
