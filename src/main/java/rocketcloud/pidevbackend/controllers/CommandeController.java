package rocketcloud.pidevbackend.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import rocketcloud.pidevbackend.entities.Commande;
import rocketcloud.pidevbackend.entities.Paiement;
import rocketcloud.pidevbackend.services.CommandeService;

import java.util.List;


@RestController
@RequestMapping("/commande")
public class CommandeController {
    @Autowired
    private CommandeService commandeService;

    @PostMapping("/add")
    public Commande create_commande(@RequestBody Commande commande) {return commandeService.create_commande(commande);}
    @GetMapping("/get")
    public List<Commande> get_commandes(){return commandeService.get_commandes();}
    @GetMapping("/get/{id}")
    public Commande get_commande_by_id(@PathVariable("id") Integer id) {
        return commandeService.get_commande(id);
    }
    @DeleteMapping("/delete/{id}")
    public void delete_paiement(@PathVariable("id") Integer id ) { commandeService.delete_commande(id);}
}
