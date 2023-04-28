package rocketcloud.pidevbackend.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import rocketcloud.pidevbackend.entities.Don;
import rocketcloud.pidevbackend.entities.Reclamation;
import rocketcloud.pidevbackend.repositories.DonRepository;
import rocketcloud.pidevbackend.repositories.ReclamationRepository;
import rocketcloud.pidevbackend.services.interfaces.IReclamation;

import java.util.List;
@Service
public class ReclamationService implements IReclamation {
    @Autowired
    private ReclamationRepository reclamationRepository;
    @Override
    public Reclamation Create_Reclamation(Reclamation reclamation) {
        return reclamationRepository.save(reclamation);
    }

    @Override
    public Reclamation Update_Reclamation(Reclamation reclamation) {
        return reclamationRepository.save(reclamation);    }

    @Override
    public void Delete_Reclamation(Integer id) {
        reclamationRepository.deleteById(id);

    }

    @Override
    public List<Reclamation> Get_Reclamation() {
        return (List<Reclamation>) reclamationRepository.findAll();
    }

    @Override
    public Reclamation Get_Reclamation(Integer id) {
        return reclamationRepository.findById(id).get();
    }
}
