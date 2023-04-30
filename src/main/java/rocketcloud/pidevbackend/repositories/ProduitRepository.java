package rocketcloud.pidevbackend.repositories;


import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import rocketcloud.pidevbackend.entities.Categorie;
import rocketcloud.pidevbackend.entities.Produit;

import java.util.List;

@Repository
public interface ProduitRepository extends CrudRepository<Produit, Integer> {
    List<Produit> findAllByCategorie(Categorie categorie);

    @Query("SELECT  c.nomCategorie, COUNT(p) FROM Produit p JOIN p.categorie c GROUP BY c.nomCategorie")
    List<Object[]> countProduitsByCategorie();
}
