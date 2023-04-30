package rocketcloud.pidevbackend.controllers;

import org.apache.catalina.LifecycleState;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import rocketcloud.pidevbackend.entities.Recette;
import rocketcloud.pidevbackend.services.interfaces.IRecette;

import java.util.List;

@RestController
@RequestMapping("/Recette")
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

    @PostMapping("/updateRecette")
    public Recette updateRecette(@RequestBody Recette recette) {
        return iRecette.updateRecette(recette);
    }
    @DeleteMapping("/delete/{id}")
    public String removeRecette(@PathVariable int id) {
        iRecette.removeRecette(id);
        return "done";
    }

//    @GetMapping("/{nom}")
//    public List<Recette> getRecetteByName(Recette recette){
//        return iRecette.getRecetteByName(recette);
//    }
}
