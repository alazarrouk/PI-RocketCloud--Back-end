package rocketcloud.pidevbackend.controllers;

import org.apache.catalina.LifecycleState;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import rocketcloud.pidevbackend.entities.Recette;
import rocketcloud.pidevbackend.services.interfaces.IRecette;

import java.util.List;

@RestController
@RequestMapping("/Recette")
@CrossOrigin("http://localhost:4200")
public class RecetteController {
    @Autowired
    private IRecette iRecette;

    @PostMapping("/addRecette")
    public Recette addRecette(@RequestBody Recette recette){
        return iRecette.addRecette(recette);
    }
    @GetMapping("/getAll")
    public Iterable<Recette> getRecette(){
        return iRecette.getRecette();
    }
    @PutMapping("/updateRecette")
    public Recette updateRecette(@RequestBody Recette recette) {
        return iRecette.updateRecette(recette);
    }
    @DeleteMapping("/delete/{id}")
    public void removeRecette(@PathVariable int id) {
        iRecette.removeRecette(id);
    }
    @GetMapping("/{nom}")
    public Recette getRecetteByNom(@PathVariable String nom){
        return iRecette.getRecetteByNom(nom);
    }
    @GetMapping("/getNbRecette")

    public int getCountRecettesPending() {
        return  iRecette.getCountRecettesPending();
    }
}
