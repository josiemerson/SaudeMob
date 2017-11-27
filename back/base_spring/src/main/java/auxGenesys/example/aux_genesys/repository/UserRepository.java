package auxGenesys.example.aux_genesys.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import auxGenesys.example.aux_genesys.model.User;

public interface UserRepository extends JpaRepository<User, Long> {
    User findOneByEmail(String email);

    List<User> findByOfficeIsNotNull();
}