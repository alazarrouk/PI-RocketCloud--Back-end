package rocketcloud.pidevbackend.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import rocketcloud.pidevbackend.entities.Paiement;
import rocketcloud.pidevbackend.entities.Panier;
import rocketcloud.pidevbackend.repositories.PaiementRepository;
import rocketcloud.pidevbackend.repositories.PanierRepository;
import rocketcloud.pidevbackend.services.interfaces.IPanier;

import java.util.List;

@Service
public class PanierService implements IPanier {
    @Autowired
    PanierRepository panierRepository;
    @Override
    public Panier create_panier(Panier panier) {
        return panierRepository.save(panier);
    }
    @Override
    public Panier update_panier(Panier panier) { return panierRepository.save(panier);}
    @Override
    public void delete_panier(Integer id) {
        panierRepository.deleteById(id);
    }
    @Override
    public List<Panier> get_paniers() {
        return (List<Panier>) panierRepository.findAll();
    }
    @Override
    public Panier get_panier(Integer id) { return panierRepository.findById(id).get();}
}
