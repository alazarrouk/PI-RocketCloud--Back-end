package rocketcloud.pidevbackend.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import rocketcloud.pidevbackend.entities.Panier;
import rocketcloud.pidevbackend.repositories.PanierRepository;
import rocketcloud.pidevbackend.repositories.VendeurRepository;
import rocketcloud.pidevbackend.services.Interfaces.IPanierServiceImp;
import rocketcloud.pidevbackend.services.Interfaces.IVendeurServiceImp;

import rocketcloud.pidevbackend.repositories.ProduitRepository;
import rocketcloud.pidevbackend.repositories.UserRepository;
import rocketcloud.pidevbackend.services.interfaces.IPanierServiceImp;


import java.util.List;

@RestController
@RequestMapping("/panier")
public class PanierController {
    @Autowired

    private IPanierServiceImp iPanierServiceImp;
    @Autowired
    private PanierRepository panierRepository;
    @GetMapping("/allPaniers")
    public List<Panier> getAllPaniers() {
        return iPanierServiceImp.getAllPaniers();
    }

    @GetMapping("/getPanier/{idPanier}")
    public Panier getPanierById(@PathVariable int idPanier) {
        return iPanierServiceImp.getPanierById(idPanier);
    }

    @PostMapping("/addPanier")
    public void addPanier(@RequestBody Panier panier) {
        iPanierServiceImp.addPanier(panier);
    }

    @PutMapping("/updatePaniers")
    public void updatePanier(@RequestBody Panier panier) {
        iPanierServiceImp.updatePanier(panier);
    }

    @DeleteMapping("/deletePanier/{idPanier}")
    public void deletePanier(@PathVariable int idPanier) {
        iPanierServiceImp.deletePanier(idPanier);
    }

}
