package rocketcloud.pidevbackend.services.Interfaces;


import rocketcloud.pidevbackend.entities.Produit;

import java.util.List;

public interface IProduitServiceImp {
    Produit addProduit(Produit produit);

    List<Produit> retrieveAllProduits();
    void deleteProduit(Produit produit);
    Produit getProduit(int idProduit);

    Produit updateProduit(int idProduit,Produit produit);
}
