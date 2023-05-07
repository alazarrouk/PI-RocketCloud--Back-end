package rocketcloud.pidevbackend.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import rocketcloud.pidevbackend.entities.Role;
import rocketcloud.pidevbackend.entities.User;

import java.util.List;
import java.util.Optional;
import java.util.Set;

@Repository
public interface UserRepository  extends JpaRepository<User, Long> {
        Optional<User> findByUsername(String username);

        Boolean existsByUsername(String username);

        Boolean existsByEmail(String email);
        User findUserByUsername(String username);
        User findUserByEmail(String email);

        User findByVerificationCode (String code);

        User findUserByid(Long id);

        List<User> findByusernameContaining(
                String username);

        @Query("SELECT count(*) FROM  User r")
        int countusers();



}
