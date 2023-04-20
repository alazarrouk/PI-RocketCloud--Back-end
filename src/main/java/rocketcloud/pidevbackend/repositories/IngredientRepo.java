package rocketcloud.pidevbackend.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import rocketcloud.pidevbackend.entities.Ingredient;

@Repository
public interface IngredientRepo extends CrudRepository <Ingredient, Integer> {
}
