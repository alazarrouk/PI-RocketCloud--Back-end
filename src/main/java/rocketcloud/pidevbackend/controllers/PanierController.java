package rocketcloud.pidevbackend.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import rocketcloud.pidevbackend.entities.Paiement;
import rocketcloud.pidevbackend.entities.Panier;
import rocketcloud.pidevbackend.services.CommandeService;
import rocketcloud.pidevbackend.services.PanierService;

import java.util.List;

@RestController
@RequestMapping("/panier")
public class PanierController {
    @Autowired
    private PanierService panierService;
    @PostMapping("/add")
    public Panier create_panier(@RequestBody Panier panier) {
        return panierService.create_panier(panier);
    }
    @GetMapping("/get")
    public List<Panier> get_paniers(){
        return panierService.get_paniers();
    }
    @GetMapping("/get/{id}")
    public Panier get_panier_by_id(@PathVariable("id") Integer id) {
        return panierService.get_panier(id);
    }
    @DeleteMapping("/delete/{id}")
    public void delete_panier(@PathVariable("id") Integer id ) {
        panierService.delete_panier(id);
    }

}
