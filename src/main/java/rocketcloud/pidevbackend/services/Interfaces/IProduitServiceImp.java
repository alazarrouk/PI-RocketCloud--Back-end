package rocketcloud.pidevbackend.services.Interfaces;


import rocketcloud.pidevbackend.entities.Categorie;
import rocketcloud.pidevbackend.entities.Produit;
import rocketcloud.pidevbackend.entities.Vendeur;

import java.util.List;
import java.util.Map;

public interface IProduitServiceImp {
    Produit addProduit(Produit produit);

    List<Produit> retrieveAllProduits();

    void deleteProduit(Produit produit);

    Produit getProduit(int idProduit);

    Produit updateProduit(int idProduit, Produit produit);

    Produit getProduitById(int idProduit);

    List<Produit> getProduitsByCategorie(Categorie categorie);
    List<Produit> getProduitsByVendeur(Vendeur vendeur);


    List<Object[]> countProduitsByCategorie();

    List<Object[]> countProduitsByVendeur();
}
