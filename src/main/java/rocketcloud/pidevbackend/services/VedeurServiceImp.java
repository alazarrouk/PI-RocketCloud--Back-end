package rocketcloud.pidevbackend.services;

import rocketcloud.pidevbackend.entities.Vendeur;
import rocketcloud.pidevbackend.repositories.VendeurRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import rocketcloud.pidevbackend.services.Interfaces.IVendeurServiceImp;

import java.util.List;

@Service
public class VedeurServiceImp implements IVendeurServiceImp {
    @Autowired
    private VendeurRepository vendeurRepository;
    public Vendeur addVendeur(Vendeur vendeur) {
        return vendeurRepository.save(vendeur);
    }
    public Vendeur updateVendeur(int idVendeur, Vendeur vendeur) {
        Vendeur existingVendeur = vendeurRepository.findById(idVendeur).orElse(null);
        if(existingVendeur != null) {
            // Mettre à jour l'entité Produit existante avec les nouvelles valeurs
            existingVendeur.setNomVendeur(vendeur.getNomVendeur());
            existingVendeur.setEmailVendeur(vendeur.getEmailVendeur());
            existingVendeur.setNumeroVendeur(vendeur.getNumeroVendeur());
            existingVendeur.setLogoVendeur(vendeur.getLogoVendeur());
            existingVendeur.setAdresseVendeur(vendeur.getAdresseVendeur());
         return vendeurRepository.save(existingVendeur);
        } else {
            return null;
        }
    }

    public void deleteVendeur(Vendeur vendeur) {
        vendeurRepository.delete(vendeur);
    }

    public List<Vendeur> retrieveAllVendeurs() {
        List<Vendeur> listVendeurs = (List) vendeurRepository.findAll();
        return listVendeurs;
    }
    @Override
    public Vendeur getVendeurById(int idVendeur)  {
        return vendeurRepository.findById(idVendeur).get();

    }


    public Vendeur getVendeur(int idVendeur) {
        return vendeurRepository.findById(idVendeur).get();
    }
}
