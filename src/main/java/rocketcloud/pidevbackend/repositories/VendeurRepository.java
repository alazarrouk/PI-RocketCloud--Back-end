package rocketcloud.pidevbackend.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import rocketcloud.pidevbackend.entities.Categorie;
import rocketcloud.pidevbackend.entities.Vendeur;

@Repository
public interface VendeurRepository extends CrudRepository<Vendeur, Integer> {
    Vendeur getCategorieByIdVendeur(int idVendeur);

}
