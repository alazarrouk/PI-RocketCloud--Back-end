package rocketcloud.pidevbackend.services.Interfaces;

import rocketcloud.pidevbackend.entities.Commande;
import rocketcloud.pidevbackend.entities.User;

import java.util.Date;
import java.util.List;
import java.util.Set;

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
    List<Commande> get_commandes_by_date(Date date);
    List<Commande> get_commandes_by_user(User user);
    List<Commande> get_commandes_by_user_date(User user, Date date);


}
