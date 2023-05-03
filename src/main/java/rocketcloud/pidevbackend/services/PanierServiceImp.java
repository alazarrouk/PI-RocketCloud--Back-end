package rocketcloud.pidevbackend.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import rocketcloud.pidevbackend.entities.Panier;
import rocketcloud.pidevbackend.repositories.PanierRepository;
import rocketcloud.pidevbackend.services.Interfaces.IPanierServiceImp;

import java.util.List;

@Service
public class PanierServiceImp implements IPanierServiceImp {
    @Autowired
    private PanierRepository panierRepository;
@Override
    public List<Panier> getAllPaniers() {
        return (List<Panier>) panierRepository.findAll();
    }
@Override
    public Panier getPanierById(int idPanier) {
        return panierRepository.findById(idPanier).orElse(null);
    }
@Override
    public void addPanier(Panier panier) {
        panierRepository.save(panier);
    }
@Override
    public void updatePanier(Panier panier) {
        panierRepository.save(panier);
    }
@Override
    public void deletePanier(int idPanier) {
        panierRepository.deleteById(idPanier);
    }

}
