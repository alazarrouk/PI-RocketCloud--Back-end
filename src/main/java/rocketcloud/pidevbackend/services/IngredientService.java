package rocketcloud.pidevbackend.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import rocketcloud.pidevbackend.entities.Ingredient;
import rocketcloud.pidevbackend.repositories.IngredientRepo;
import rocketcloud.pidevbackend.services.interfaces.IIngredient;

@Service
public class IngredientService implements IIngredient {
    @Autowired
    private IngredientRepo ingredientRepo ;
    @Override
    public Ingredient addIngredient(Ingredient ingredient) {
        return ingredientRepo.save(ingredient);
    }

    @Override
    public Iterable<Ingredient> getIngredient() {
        return ingredientRepo.findAll();
    }

    @Override
    public Ingredient updateIngredient(Ingredient ingredient) {
        return ingredientRepo.save(ingredient);
    }

    @Override
    public void removeIngredients(int id) {
        ingredientRepo.deleteById(id);
    }
}
