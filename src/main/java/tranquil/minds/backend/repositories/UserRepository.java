package tranquil.minds.backend.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Date;
import java.util.List;
import java.util.Optional;

import tranquil.minds.backend.models.User;

/**
 * Repository controlling JPA commands (ultimately CRUD) to the User and UserAddr Entity.
 *
 */
public interface UserRepository extends JpaRepository<User, String> {

    Optional<List<User>> findByCreationDateBetween(Date startTimestamp, Date endTimestamp);

    Optional<User> findByUserId(String userId);

    Optional<User> findByEmail(String email);

}