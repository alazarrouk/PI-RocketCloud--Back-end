package rocketcloud.pidevbackend.services.Interfaces;

import rocketcloud.pidevbackend.entities.Commande;

import java.util.List;

public interface ICommande {
    //insert
    Commande create_commande(Commande commande);

    //update
    Commande update_commande(Commande commande);

    //remove
    void delete_commande(Integer id);

    //retrieve
    List<Commande> get_commandes();
    Commande get_commande(Integer id);
}
