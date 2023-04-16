package rocketcloud.pidevbackend.services.Interfaces;

import rocketcloud.pidevbackend.entities.Paiement;
import rocketcloud.pidevbackend.entities.Panier;

import java.util.List;

public interface IPanier {
    //insert
    Panier create_panier(Panier panier);

    //update
    Panier update_panier(Panier panier);

    //remove
    void delete_panier(Integer id);

    //retrieve
    List<Panier> get_paniers();
    Panier get_panier(Integer id);
}
