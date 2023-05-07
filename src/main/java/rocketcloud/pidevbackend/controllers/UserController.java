package rocketcloud.pidevbackend.controllers;

import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;
import rocketcloud.pidevbackend.entities.Role;
import rocketcloud.pidevbackend.entities.User;
import rocketcloud.pidevbackend.payload.request.SignupRequest;
import rocketcloud.pidevbackend.payload.response.MessageResponse;
import rocketcloud.pidevbackend.repositories.RoleRepository;
import rocketcloud.pidevbackend.repositories.UserRepository;
import rocketcloud.pidevbackend.security.jwt.JwtUtils;
import rocketcloud.pidevbackend.security.services.RefreshTokenService;
import rocketcloud.pidevbackend.services.iUserServiceImp;

import javax.validation.Valid;
import java.io.IOException;
import java.util.*;

@AllArgsConstructor
@RestController
@RequestMapping("/user/")
@CrossOrigin(maxAge = 3600)
public class UserController {
    @Autowired
    private  iUserServiceImp iUserServiceImp;
    @Autowired
    PasswordEncoder encoder;
    @Autowired
    UserRepository userRepository;

    @Autowired
    RoleRepository roleRepository;

    @Autowired
    AuthenticationManager authenticationManager;

    @Autowired
    JwtUtils jwtUtils;
    @Autowired
    RefreshTokenService refreshTokenService;

    @GetMapping("/all")
    public List<User> getAll(){
        return iUserServiceImp.getAllUsers();

    }

    @GetMapping("get/{numUser}")
    public Optional<User> retrieveUser(@PathVariable Long numUser) {

        return  iUserServiceImp.getUser(numUser);

    }
    @PostMapping("/new")
    public User addUser(@RequestBody User user) {
        return iUserServiceImp.addUser(user);
    }
    @PutMapping("/update")
    public User updateUser(@RequestBody User user) {

        return  iUserServiceImp.updateUser(user);

    }
    @DeleteMapping("/delete/{numUser}")
    public void removeUser(@PathVariable Long numUser){

        iUserServiceImp.removeUser(numUser);
    }


    @PutMapping("/userEdit")
    @ResponseBody
    public ResponseEntity<?> editAccount(@Valid @RequestBody SignupRequest signUpRequest) throws IOException {
        Optional<User> us = iUserServiceImp.getUser(signUpRequest.getId());
        User user=us.get();



        if(!user.getUsername().equals(signUpRequest.getUsername())) {
            if (userRepository.existsByUsername(signUpRequest.getUsername())) {
                return ResponseEntity.badRequest().body(new MessageResponse("Error: Username is already taken!"));
            }
        }
        if(!user.getEmail().equals(signUpRequest.getEmail())) {
            if (userRepository.existsByEmail(signUpRequest.getEmail())) {
                return ResponseEntity.badRequest().body(new MessageResponse("Error: Email is already in use!"));
            }
        }

        user.setEmail(signUpRequest.getEmail());
        user.setUsername(signUpRequest.getUsername());
        user.setAdresse(signUpRequest.getAdresse());


        user.setFullname(signUpRequest.getFullname());

        if(signUpRequest.getPassword()!="") {
            user.setPassword(encoder.encode(signUpRequest.getPassword()));
        }
        User u=userRepository.save(user);
        System.out.println(u.getFullname());
        System.out.println(u.getAdresse());
        return ResponseEntity.ok(u);

    }
    @PutMapping("/modif/{id}")
    @ResponseBody
    public ResponseEntity<?> editAccount(@Valid @RequestBody SignupRequest signUpRequest,@PathVariable("id")Long id ) throws IOException {

        User user = userRepository.findUserByid(id);



        user.setEmail(signUpRequest.getEmail());
        user.setUsername(signUpRequest.getUsername());
        user.setAdresse(signUpRequest.getAdresse());


        user.setFullname(signUpRequest.getFullname());

        if(signUpRequest.getPassword()!="") {
            user.setPassword(encoder.encode(signUpRequest.getPassword()));
        }
        User u=userRepository.save(user);
        System.out.println(u.getFullname());
        System.out.println(u.getAdresse());
        return ResponseEntity.ok(u);

    }
    public User getConnectedUser() {
        String username;
        Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        if (principal instanceof UserDetails) {
            username = ((UserDetails)principal).getUsername();
        } else {
            username = principal.toString();
        }
        User us = userRepository.findByUsername(username).orElse(null);

        return us;


    }
    @GetMapping("/search")
    public ResponseEntity<List<User>> searchUsers(
            @RequestParam(required = false) String username) {

        List<User> users = userRepository.findByusernameContaining(
                username != null ? username : "");

        return ResponseEntity.ok(users);
    }

    @GetMapping("/count")
    public int count(){
        return iUserServiceImp.countUsers();
    }

    @GetMapping("/roles")
    public List<Role> liste(){
        return iUserServiceImp.getAllRoles();
    }
    @GetMapping("/admincount")
    public int countadmin(){
        return iUserServiceImp.getAdminUserCount();
    }
    @GetMapping("/usercount")
    public int countuser(){
        return iUserServiceImp.getUserCount();
    }

    @GetMapping("/vendeurcount")
    public int countvendeur(){
        return iUserServiceImp.getVendeurCount();
    }

    @GetMapping("/countt")
    public Map<Integer, Integer> getUserCounts() {
        Map<Integer, Integer> counts = new HashMap<>();
        counts.put(1, iUserServiceImp.getAdminUserCount());
        counts.put(2, iUserServiceImp.getUserCount());
        counts.put(3, iUserServiceImp.getVendeurCount());
        return counts;
    }
}
