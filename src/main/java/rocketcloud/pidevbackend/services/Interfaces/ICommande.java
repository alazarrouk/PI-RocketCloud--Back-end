package rocketcloud.pidevbackend.services.interfaces;

import rocketcloud.pidevbackend.entities.Commande;
import rocketcloud.pidevbackend.entities.Paiement;
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
    Commande get_commande_by_paiement(Paiement paiement);
    List<Commande> get_commandes_by_date(Date date);
    List<Commande> get_commandes_by_user(User user);
    List<Commande> get_commandes_by_user_date(User user, Date date);
    Integer get_count_commande_by_status(String status);
    Integer get_count_commande_by_year(Integer year);
    Integer get_count_commande();
    Float get_sum_total_commande_by_status(String status);
    Integer get_count_today_commande();



}
