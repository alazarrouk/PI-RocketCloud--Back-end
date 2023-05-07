package rocketcloud.pidevbackend.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import rocketcloud.pidevbackend.entities.ERole;
import rocketcloud.pidevbackend.entities.Role;
import rocketcloud.pidevbackend.entities.User;
import rocketcloud.pidevbackend.repositories.RoleRepository;
import rocketcloud.pidevbackend.repositories.UserRepository;
import rocketcloud.pidevbackend.services.Interfaces.IUserService;


import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.Set;

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

    @Override
    public int countUsers() {
        return userRepository.countusers();
    }
    User u;
    public Set<Role> aff(){
        return u.getRoles();
    }


    public List<Role> getAllRoles() {
        List<Role> allRoles = new ArrayList<>();
        List<User> users = userRepository.findAll();
        for (User user : users) {
            allRoles.addAll(user.getRoles());
        }
        int a= allRoles.size();
        return allRoles;
    }

    public int getUserCount() {
        List<User> users = userRepository.findAll();
        int userCount = 0;
        for (User user : users) {
            for (Role role : user.getRoles()) {
                if (role.getName().equals(ERole.ROLE_USER)) {
                    userCount++;
                    break;
                }
            }
        }
        return userCount;
    }
    public int getVendeurCount() {
        List<User> users = userRepository.findAll();
        int vendeurcount = 0;
        for (User user : users) {
            for (Role role : user.getRoles()) {
                if (role.getName().equals(ERole.ROLE_VENDEUR)) {
                    vendeurcount++;
                    break;
                }
            }
        }
        return vendeurcount;
    }


    public int getAdminUserCount() {
        List<User> users = userRepository.findAll();
        int adminCount = 0;
        for (User user : users) {
            for (Role role : user.getRoles()) {
                if (role.getName().equals(ERole.ROLE_ADMIN)) {
                    adminCount++;
                    break;
                }
            }
        }
        return adminCount;
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
