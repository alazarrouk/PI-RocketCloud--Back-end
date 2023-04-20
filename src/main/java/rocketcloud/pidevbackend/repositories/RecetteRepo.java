package rocketcloud.pidevbackend.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import rocketcloud.pidevbackend.entities.Recette;

import java.util.List;

@Repository
public interface RecetteRepo extends CrudRepository <Recette, Integer> {
//    List<Recette> findByName(Recette recette);
}
