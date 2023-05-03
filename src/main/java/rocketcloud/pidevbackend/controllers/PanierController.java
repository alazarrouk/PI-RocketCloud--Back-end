package rocketcloud.pidevbackend.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import rocketcloud.pidevbackend.entities.Paiement;
import rocketcloud.pidevbackend.entities.Panier;
import rocketcloud.pidevbackend.services.CommandeService;
import rocketcloud.pidevbackend.services.PanierService;
import rocketcloud.pidevbackend.entities.Produit;
import rocketcloud.pidevbackend.entities.User;
import rocketcloud.pidevbackend.repositories.ProduitRepository;



import java.util.Date;
import java.util.List;

@RestController
@RequestMapping("/panier")
public class PanierController {


}
