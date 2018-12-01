package unsl.repository;

import org.springframework.data.repository.CrudRepository;
import unsl.entities.User;
import org.springframework.data.repository.query.Param;

public interface UserRepository extends CrudRepository<User, Long> {

	User findByDni(@Param("dni") Long dni);
}
