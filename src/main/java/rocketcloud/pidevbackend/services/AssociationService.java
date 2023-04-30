package rocketcloud.pidevbackend.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import rocketcloud.pidevbackend.entities.Association;
import rocketcloud.pidevbackend.entities.Don;
import rocketcloud.pidevbackend.repositories.AssociationRepository;
import rocketcloud.pidevbackend.services.Interfaces.IAssociation;

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
        Association association1=associationRepository.findById(association.getId_association()).get();
        for(Don don:association.getDons()){
            association1.getDons().add(don);
        }
        System.out.println("ass"+association1);
        return associationRepository.save(association1);
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

    @Override
    public void modifierAssociation(Association association) {
         associationRepository.save(association);
    }
}