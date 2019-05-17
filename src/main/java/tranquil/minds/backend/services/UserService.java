package tranquil.minds.backend.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tranquil.minds.backend.models.User;
import tranquil.minds.backend.repositories.UserRepository;

import java.util.List;
import java.util.Optional;

/**
 * Service implementing business logic orchestrating access to client functionality for JPA requests and messaging.
 *
 */
@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    /**
     * Returns all users.
     * Called by the REST endpoint /users
     *
     * @return  List<User>
     *
     */
    public List<User> getUsers() { return userRepository.findAll(); }

    /**
     * Returns details of a given user by userId.
     * Called by the REST endpoint /users/{userId}
     *
     * @param id
     * @return  User
     *
     */
    public Optional<User> getUser(String id) {return userRepository.findByUserId(id);}

    /**
     * Returns details of a user with an given email address.
     * Called by user validation
     *
     * @param email
     * @return  User
     *
     */
    public Optional<User> getUserByEmail(String email) {return userRepository.findByEmail(email);}

    /**
     * Returns the complete User record with insert timestamps.
     * Called by the REST endpoint /users
     *
     * @param user
     * @return  User
     *
     */
    public User saveUser(User user) {return userRepository.save(user);}

    /**
     * Deletes a user by UserId
     * Called by the REST endpoint /users
     *
     * @param userId
     *
     */
    public void deleteUser(String userId) {userRepository.deleteById(userId);}

    /**
     * Returns the complete User record with insert timestamps.
     * Called by the REST endpoint /users
     *
     * @param user
     * @return  User
     *
     */
    public User updateUser(User user) {return userRepository.saveAndFlush(user);}
}
