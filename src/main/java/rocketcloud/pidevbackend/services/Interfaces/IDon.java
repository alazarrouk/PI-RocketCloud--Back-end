package rocketcloud.pidevbackend.services.Interfaces;

import rocketcloud.pidevbackend.entities.Commande;
import rocketcloud.pidevbackend.entities.Don;

import java.util.List;

public interface IDon {
    Don Create_Don(Don don);

    //update
    Don Update_Don(Don don);

    //remove
    void Delete_Don(Integer id);

    //retrieve
    List<Don> Get_Dons();
    Don Get_Don(Integer id);
}
