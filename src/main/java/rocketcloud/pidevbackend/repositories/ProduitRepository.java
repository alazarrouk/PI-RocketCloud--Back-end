package rocketcloud.pidevbackend.repositories;


import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import rocketcloud.pidevbackend.entities.Categorie;
import rocketcloud.pidevbackend.entities.Produit;
import rocketcloud.pidevbackend.entities.Vendeur;

import java.util.List;

@Repository
public interface ProduitRepository extends CrudRepository<Produit, Integer> {
    List<Produit> findAllByCategorie(Categorie categorie);
    List<Produit> findAllByVendeur(Vendeur vendeur);

    @Query("SELECT c.idCategorie, c.nomCategorie, COUNT(p.idProduit) FROM Produit p JOIN p.categorie c GROUP BY c.idCategorie")
    List<Object[]> countProduitsByCategorie();
    @Query("SELECT c.idVendeur, c.nomVendeur, COUNT(p.idProduit) FROM Produit p JOIN p.vendeur c GROUP BY c.idVendeur")
    List<Object[]> countProduitsByVendeur();
}
