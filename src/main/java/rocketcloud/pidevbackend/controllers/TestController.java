package rocketcloud.pidevbackend.controllers;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


/*
 * cette classe définit un contrôleur d'autorisation test qui contient 4 API
 * *

 */
@CrossOrigin(origins =  "*", maxAge = 3600)
@RestController
@RequestMapping("/api/test")
public class TestController {
    //(api/test/all) pour l'accès public

    @GetMapping("/all")
    public String allAccess() {
        return "Public Content.";
    }
    //(api/test/user) pour les utilisateurs à ROLE_USER ou ROLE_VENDEUR ou ROLE_ADMIN

    @GetMapping("/user")
    @PreAuthorize("hasRole('user') or hasRole('vendeur') or hasRole('admin')")
    public String userAccess() {
        return "User Content.";
    }

    @GetMapping("/vendeur")
    @PreAuthorize("hasRole('vendeur')")
    public String moderatorAccess() {
        return "vendeur Board.";
    }
    //(api/test/admin) pour les utilisateurs à ROLE_ADMIN

    @GetMapping("/admin")
    @PreAuthorize("hasRole('admin')")
    public String adminAccess() {
        return "Admin Board.";
    }



}
