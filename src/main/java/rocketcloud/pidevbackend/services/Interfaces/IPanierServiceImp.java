package rocketcloud.pidevbackend.services.Interfaces;

import rocketcloud.pidevbackend.entities.Panier;

import java.util.List;

public interface IPanierServiceImp {
    List<Panier> getAllPaniers();

    Panier getPanierById(int idPanier);

    void addPanier(Panier panier);

    void updatePanier(Panier panier);

    void deletePanier(int idPanier);
}
