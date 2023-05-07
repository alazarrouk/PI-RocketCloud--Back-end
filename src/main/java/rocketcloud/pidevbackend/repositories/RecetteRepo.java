package rocketcloud.pidevbackend.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import rocketcloud.pidevbackend.entities.Recette;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

@Repository
public interface RecetteRepo extends JpaRepository <Recette, Integer> {
    Recette findByNom(String nom);

    @Query(" SELECT COUNT(*) FROM Recette WHERE status = 'pending' ")
            Integer getCountRecettesPending();
}
