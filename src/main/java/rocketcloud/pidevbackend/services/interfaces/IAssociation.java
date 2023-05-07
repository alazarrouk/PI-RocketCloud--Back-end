package rocketcloud.pidevbackend.services.interfaces;

import rocketcloud.pidevbackend.entities.Association;

import java.util.List;

public interface IAssociation {
    Association Create_Association(Association association);

    //update
    Association Update_Association(Association association);

    //remove
    void Delete_Association(Integer id);

    //retrieve
    List<Association> Get_Association();
    Association Get_Association(Integer id);

     void modifierAssociation(Association A);
    List<Object[]> getStatAssociationsNbrDon();

}
