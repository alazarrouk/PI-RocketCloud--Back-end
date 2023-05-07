package rocketcloud.pidevbackend.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import rocketcloud.pidevbackend.entities.Ingredient;
import rocketcloud.pidevbackend.services.interfaces.IIngredient;


@RestController
@RequestMapping("/Ingredient")
@CrossOrigin(origins = "", allowedHeaders = "")
public class IngredientController {

    @Autowired
    private IIngredient iIngredient;

    @PostMapping("/addIngredient")
    public Ingredient addIngredient(@RequestBody Ingredient ingredient){
        return iIngredient.addIngredient(ingredient);
    }

    @GetMapping("/getAll")
    public Iterable<Ingredient> getIngredient(){
        return iIngredient.getIngredient();
    }

    @PutMapping("/updateIngredient")
    public Ingredient updateIngredient(@RequestBody Ingredient ingredient){
        return iIngredient.updateIngredient(ingredient);
    }
    @DeleteMapping("/delete/{id}")
    public String removeRecette(@PathVariable int id) {
        iIngredient.removeIngredients(id);
        return "done";
    }
}
