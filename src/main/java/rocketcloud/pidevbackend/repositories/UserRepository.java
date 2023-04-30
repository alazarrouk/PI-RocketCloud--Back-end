package rocketcloud.pidevbackend.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import rocketcloud.pidevbackend.entities.User;

import java.util.Optional;
@Repository
public interface UserRepository  extends JpaRepository<User, Long> {
        Optional<User> findByUsername(String username);

        Boolean existsByUsername(String username);

        Boolean existsByEmail(String email);
        User findUserByUsername(String username);
        User findUserByEmail(String email);

        User findByVerificationCode (String code);
}
