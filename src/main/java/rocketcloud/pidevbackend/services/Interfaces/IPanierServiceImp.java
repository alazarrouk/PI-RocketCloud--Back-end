package rocketcloud.pidevbackend.services.Interfaces;

import rocketcloud.pidevbackend.entities.Panier;
import rocketcloud.pidevbackend.entities.Produit;

import java.util.List;
import java.util.Optional;

public interface IPanierServiceImp {
    List<Panier> getAllPaniers();

    Panier getPanierById(int idPanier);

    void addPanier(Panier panier);

    void updatePanier(Panier panier);

    void deletePanier(int idPanier);
    List<Produit> findProduitsByUserId(Long id);

    void deletePanierByUserIdAndProduitId(Long id, Integer idProduit);
}
