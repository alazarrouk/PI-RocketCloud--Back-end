package rocketcloud.pidevbackend.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import rocketcloud.pidevbackend.entities.User;
import rocketcloud.pidevbackend.repositories.RoleRepository;
import rocketcloud.pidevbackend.repositories.UserRepository;
import rocketcloud.pidevbackend.services.Interfaces.IUserService;


import java.util.List;
import java.util.Optional;

@Service

public class iUserServiceImp implements IUserService {
    @Autowired
    UserRepository userRepository;
    @Autowired
    RoleRepository roleRepository;

    @Override
    public List<User> getAllUsers() {
        return userRepository.findAll();
    }

    @Override
    public User addUser(User u) {
        return userRepository.save(u);
    }

    @Override
    public void removeUser(Long id) {
        userRepository.deleteById(id);

    }

    @Override
    public Optional<User> getUser(Long id) {
        return userRepository.findById(id);
    }

    @Override
    public User updateUser(User u) {
        return userRepository.save(u);
    }

    public User updateUser(User user, Long id) {
        User existingUser = getUser(id).get();
        if (existingUser != null) {
            existingUser.setUsername(user.getUsername());
            existingUser.setFullname(user.getFullname());
            existingUser.setEmail(user.getEmail());
            existingUser.setAdresse(user.getAdresse());
            return userRepository.save(existingUser);
        }
        return null;
    }

}
