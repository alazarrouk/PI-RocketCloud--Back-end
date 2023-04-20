package rocketcloud.pidevbackend.controllers;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import rocketcloud.pidevbackend.entities.Categorie;
import rocketcloud.pidevbackend.services.Interfaces.ICategorieServiceImp;

import java.util.List;

@RestController
@RequestMapping("/categorie")
public class CategorieController {
    @Autowired
    private ICategorieServiceImp iCategorieServiceImp;
   //ajouter categorie
    @PostMapping("/add-Categorie")
    public Categorie addCategorie(@RequestBody Categorie categorie) {
        return iCategorieServiceImp.addCategorie(categorie);
    }
    //modifier categorie
    @PutMapping("/update-Categorie")
    public Categorie updateCategorie(@RequestBody Categorie categorie) {
        return iCategorieServiceImp.addCategorie(categorie);
    }
    //supprimer categorie
    @DeleteMapping("/{idCategorie}")
    @ResponseBody
    public void removeCategorie(@PathVariable("idCategorie") int idCategorie) {
        Categorie categorie = new Categorie();
        categorie.setIdCategorie(idCategorie);
        iCategorieServiceImp.deleteCategorie(categorie);
    }
    // afficher toutes les categories
    @GetMapping("/retrieve-all-categories")
    @ResponseBody
    public List<Categorie> getAllCategories() {
        List<Categorie> listCategories = iCategorieServiceImp.retrieveAllCategories();
        return listCategories;
    }
    //afficher une seule categorie
    @GetMapping("/retrieve-categorie/{idCategorie}")
    @ResponseBody
    public Categorie retrieveCategorie(@PathVariable("idCategorie") int idCategorie) {
        return iCategorieServiceImp.getCategorie(idCategorie);
    }
}
