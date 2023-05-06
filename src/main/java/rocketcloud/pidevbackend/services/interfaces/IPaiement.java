package rocketcloud.pidevbackend.services.interfaces;

import rocketcloud.pidevbackend.entities.Paiement;

import java.util.List;

public interface IPaiement {
    //insert
    Paiement create_paiement(Paiement paiement);

    //update
    Paiement update_paiement(Paiement paiement);

    //remove
    void delete_paiement(Integer id);

    //retrieve
    List<Paiement> get_paiements();
    Paiement get_paiement(Integer id);
}
