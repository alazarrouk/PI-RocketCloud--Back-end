package rocketcloud.pidevbackend.services.interfaces;

import rocketcloud.pidevbackend.entities.Vendeur;

import java.util.List;

public interface IVendeurServiceImp {
    Vendeur addVendeur(Vendeur vendeur);

    List<Vendeur> retrieveAllVendeurs();
    void deleteVendeur(Vendeur vendeur);

    Vendeur getVendeurById(int idVendeur);

    Vendeur getVendeur(int idVendeur);

    Vendeur updateVendeur(int idVendeur,Vendeur vendeur);


}