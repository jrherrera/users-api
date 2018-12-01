package unsl.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import unsl.entities.User;
import unsl.repository.UserRepository;

@Service
public class UserService {

    @Autowired
    UserRepository userRepository;

    /**
     * @param dni
     * @return
     */
    public User findByDni(Long dni) {
        return userRepository.findByDni(dni);
    }

    /**
     * @param user
     * @return
     */
    public User saveUser(User user) {
        return userRepository.save(user);
    }

    /**
     * @param userId
     * @return
     */
    public User getUser(Long userId) {
        return userRepository.findById(userId).orElse(null);
    }
}
