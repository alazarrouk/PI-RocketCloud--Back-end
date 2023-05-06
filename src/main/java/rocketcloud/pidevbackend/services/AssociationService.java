package rocketcloud.pidevbackend.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import rocketcloud.pidevbackend.entities.Association;
import rocketcloud.pidevbackend.repositories.AssociationRepository;
import rocketcloud.pidevbackend.services.interfaces.IAssociation;


import java.util.List;
@Service
public class AssociationService implements IAssociation {
    @Autowired
    private AssociationRepository associationRepository;
    @Override
    public Association Create_Association(Association association) {
        return associationRepository.save(association);
    }

    @Override
    public Association Update_Association(Association association) {
        return associationRepository.save(association);
    }

    @Override
    public void Delete_Association(Integer id) {
        associationRepository.deleteById(id);
    }

    @Override
    public List<Association> Get_Association() {
        return (List<Association>) associationRepository.findAll();
    }

    @Override
    public Association Get_Association(Integer id) {
        return  associationRepository.findById(id).get();
    }
}
