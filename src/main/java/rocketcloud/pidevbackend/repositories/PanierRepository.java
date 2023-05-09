package rocketcloud.pidevbackend.repositories;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import rocketcloud.pidevbackend.entities.Panier;
import rocketcloud.pidevbackend.entities.Produit;

import java.util.List;
import java.util.Optional;


public interface PanierRepository extends CrudRepository<Panier, Integer> {
    @Query("SELECT p.produit FROM Panier p WHERE p.user.id = :id")
    List<Produit> findProduitsByUserId(@Param("id") Long id);

   // void deleteByUserIdAndIdProduit(Long id, Integer idProduit);
   @Modifying
    @Query("DELETE FROM Panier p WHERE p.user.id = :id AND p.produit.idProduit = :idProduit")
    void deleteByUserIdAndIdProduit(@Param("id") Long id, @Param("idProduit") Integer idProduit);

    @Query("SELECT p FROM Panier p WHERE p.user.id = :id AND p.produit.idProduit = :idProduit")
    Optional<Panier> findByUserIdAndProduitId(@Param("id") Long id, @Param("idProduit") Integer idProduit);



    List<Panier> findByUserId(Long id);



}
