package rocketcloud.pidevbackend.repositories;


import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import rocketcloud.pidevbackend.entities.Produit;

@Repository
public interface ProduitRepository extends CrudRepository<Produit, Integer> {
}
