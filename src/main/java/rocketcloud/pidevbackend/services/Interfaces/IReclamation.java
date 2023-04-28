package rocketcloud.pidevbackend.services.interfaces;

import rocketcloud.pidevbackend.entities.Don;
import rocketcloud.pidevbackend.entities.Reclamation;

import java.util.List;

public interface IReclamation {
    Reclamation Create_Reclamation(Reclamation reclamation);

    //update
    Reclamation Update_Reclamation(Reclamation reclamation);

    //remove
    void Delete_Reclamation(Integer id);

    //retrieve
    List<Reclamation> Get_Reclamation();
    Reclamation Get_Reclamation(Integer id);
}
