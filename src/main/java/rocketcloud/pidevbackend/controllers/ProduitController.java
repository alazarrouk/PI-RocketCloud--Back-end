package rocketcloud.pidevbackend.controllers;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import rocketcloud.pidevbackend.entities.Produit;
import rocketcloud.pidevbackend.services.interfaces.IProduitServiceImp;

import java.util.List;

@RestController
@RequestMapping("/produit")
public class ProduitController {
    @Autowired
    private IProduitServiceImp iProduitServiceImp;
    //ajouter Produit
    @PostMapping("/add-Produit")
    public Produit addProduit(@RequestBody Produit produit) {
        return iProduitServiceImp.addProduit(produit);
    }
    //modifier Produit
    @PutMapping("/update-Produit/{idProduit}")
    public Produit updateProduit(@PathVariable(value = "idProduit") int idProduit,@RequestBody Produit produit) {
        return iProduitServiceImp.updateProduit(idProduit,produit);
    }
    //supprimer Produit
    @DeleteMapping("/{idProduit}")
    @ResponseBody
    public void removeProduit(@PathVariable("idProduit") int idProduit) {
        Produit produit = new Produit();
        produit.setIdProduit(idProduit);
        iProduitServiceImp.deleteProduit(produit);
    }
    // afficher tous les Produits
    @GetMapping("/retrieve-all-Produits")
    @ResponseBody
    public List<Produit> getAllProduits() {
        List<Produit> listProduits = iProduitServiceImp.retrieveAllProduits();
        return listProduits;
    }
    //afficher un seul Produit
    @GetMapping("/retrieve-produit/{idProduit}")
    @ResponseBody
    public Produit retrieveProduit(@PathVariable("idProduit") int idProduit) {
        return iProduitServiceImp.getProduit(idProduit);
    }
}
