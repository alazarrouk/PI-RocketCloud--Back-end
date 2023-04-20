package rocketcloud.pidevbackend.services.interfaces;

import rocketcloud.pidevbackend.entities.Ingredient;

public interface IIngredient {

    Ingredient addIngredient(Ingredient ingredient);
    Iterable<Ingredient> getIngredient();
    void removeIngredients(int id);
    Ingredient updateIngredient(Ingredient ingredient);
}
