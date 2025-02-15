package net.javacrud.springboot_restful_webservices.service.impl;

import lombok.AllArgsConstructor;
import lombok.Setter;
import net.javacrud.springboot_restful_webservices.entity.User;
import net.javacrud.springboot_restful_webservices.repository.UserRepository;
import net.javacrud.springboot_restful_webservices.service.UserService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor//UserServiceImpl UserRepository userRepository-parameterized constuctor hence no need to use @Autowired annotation
public class UserServiceImpl implements UserService {

    private UserRepository userRepository;

    @Override
    public User createUser(User user) {
        return userRepository.save(user);
    }

    @Override
    public User getUserById(Long userId) {
        Optional<User> optionalUser = userRepository.findById(userId);
        return optionalUser.get();
    }

    @Override
    public List<User> getAllUsers() {
        return userRepository.findAll();
    }

    @Override
    public User updateUser(User user) {
        User existingUser = userRepository.findById(user.getId()).get();
        existingUser.setFirstName(user.getFirstName());
         existingUser.setLastName(user.getLastName());
       existingUser.setEmail(user.getEmail());
       User updatedUser = userRepository.save(existingUser);
        return updatedUser;
    }

    @Override
    public void deleteUser(Long userId) {
        userRepository.deleteById(userId);
    }
}
