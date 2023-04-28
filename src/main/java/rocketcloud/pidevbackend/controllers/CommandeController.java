package rocketcloud.pidevbackend.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import rocketcloud.pidevbackend.entities.Commande;
import rocketcloud.pidevbackend.entities.Paiement;
import rocketcloud.pidevbackend.services.CommandeService;

import java.util.List;
import java.util.Set;


@RestController
@RequestMapping("/commande")
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class CommandeController {
    @Autowired
    private CommandeService commandeService;

    @PostMapping("/add")
    public Commande create_commande(@RequestBody Commande commande) {return commandeService.create_commande(commande);}
    @DeleteMapping("/delete/{id}")
    public void delete_commande(@PathVariable("id") Integer id ) { commandeService.delete_commande(id);}
    @PutMapping("/update")
    public Commande update_commande(@RequestBody Commande commande) {return commandeService.update_commande(commande);}
    @GetMapping("/get")
    public List<Commande> get_commandes(){return commandeService.get_commandes();}
    @GetMapping("/get/{id}")
    public Commande get_commande_by_id(@PathVariable("id") Integer id) {
        return commandeService.get_commande(id);
    }
    @GetMapping("/get/user/date")
    public List<Commande> get_commandes_by_user_and_date(){return commandeService.get_commandes();}



}
