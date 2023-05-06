package rocketcloud.pidevbackend.repositories;


import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import rocketcloud.pidevbackend.entities.Categorie;
import rocketcloud.pidevbackend.entities.Produit;
import rocketcloud.pidevbackend.entities.Vendeur;

import java.util.List;

@Repository
public interface ProduitRepository extends CrudRepository<Produit, Integer> {
    List<Produit> findAllByCategorie(Categorie categorie);
    List<Produit> findAllByVendeur(Vendeur vendeur);
    @Query("SELECT p FROM Produit p WHERE  (p.nomProduit LIKE %:searchTerm% OR p.description LIKE %:searchTerm% OR p.categorie.nomCategorie LIKE %:searchTerm% OR p.vendeur.nomVendeur LIKE %:searchTerm%)")
    List<Produit> searchProduits(@Param("searchTerm") String searchTerm);

    @Query("SELECT p FROM Produit p WHERE  (p.nomProduit LIKE %:searchTerm% OR p.description LIKE %:searchTerm% OR p.categorie.nomCategorie LIKE %:searchTerm% OR p.vendeur.nomVendeur LIKE %:searchTerm%)")
    List<Produit> searchProduitsVendeur( @Param("searchTerm") String searchTerm);


    @Query("SELECT c.idCategorie, c.nomCategorie, COUNT(p.idProduit) FROM Produit p JOIN p.categorie c GROUP BY c.idCategorie")
    List<Object[]> countProduitsByCategorie();
    @Query("SELECT c.idVendeur, c.nomVendeur, COUNT(p.idProduit) FROM Produit p JOIN p.vendeur c GROUP BY c.idVendeur")
    List<Object[]> countProduitsByVendeur();
}
