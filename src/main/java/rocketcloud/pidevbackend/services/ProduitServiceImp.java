package rocketcloud.pidevbackend.services;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import rocketcloud.pidevbackend.entities.Categorie;
import rocketcloud.pidevbackend.entities.Produit;
import rocketcloud.pidevbackend.repositories.CategorieRepository;
import rocketcloud.pidevbackend.repositories.ProduitRepository;
import rocketcloud.pidevbackend.services.Interfaces.IProduitServiceImp;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class ProduitServiceImp implements IProduitServiceImp {
    @Autowired
    private ProduitRepository produitRepository;
    @Autowired
    private CategorieRepository categorieRepository;
    public Produit addProduit(Produit produit) {
        // Retrieve the Categorie entity from the database

        //  Categorie categorie = categorieRepository.findById(produit.getCategorie().getIdCategorie()).orElse(null);
        // Set the managed Categorie entity on the Produit entity
        //produit.setCategorie(categorie);
        return produitRepository.save(produit);
    }
    public Produit updateProduit(int idProduit, Produit produit) {
        // Récupérer l'entité Produit existante à partir de la base de données
        Produit existingProduit = produitRepository.findById(idProduit).orElse(null);
        if(existingProduit != null) {
            // Mettre à jour l'entité Produit existante avec les nouvelles valeurs
            existingProduit.setNomProduit(produit.getNomProduit());
            existingProduit.setImageProduit(produit.getImageProduit());
            existingProduit.setPrixActuel(produit.getPrixActuel());
            existingProduit.setPrixRreduction(produit.getPrixRreduction());
            existingProduit.setQuantite(produit.getQuantite());
            existingProduit.setDescription(produit.getDescription());
            existingProduit.setDateExpiration(produit.getDateExpiration());

            // Vérifier si la propriété de catégorie dans l'objet produit envoyé n'est pas nulle
            if(produit.getCategorie() != null) {
                // Récupérer l'entité Categorie existante à partir de la base de données
                Categorie existingCategorie = categorieRepository.findById(produit.getCategorie().getIdCategorie()).orElse(null);
                if(existingCategorie != null) {
                    // Définir l'entité Categorie gérée sur l'entité Produit
                    existingProduit.setCategorie(existingCategorie);
                }
            }

            // Enregistrer l'entité Produit mise à jour
            return produitRepository.save(existingProduit);
        } else {
            return null;
        }
    }




    public void deleteProduit(Produit produit) {
        produitRepository.delete(produit);
    }

    public List<Produit> retrieveAllProduits() {
        List<Produit> listProduits = (List) produitRepository.findAll();
        return listProduits;
    }

    public List<Produit> getProduitsByCategorie(Categorie categorie) {
        return produitRepository.findAllByCategorie(categorie);
    }
    @Override
    public Produit getProduitById(int idProduit)  {
        return produitRepository.findById(idProduit).get();

    }

    public Produit getProduit(int idProduit) {
        System.out.println(produitRepository.findById(idProduit).get().getCategorie().getNomCategorie());
        return produitRepository.findById(idProduit).get();
    }

    @Override
    public Map<String, Integer> getNombreProduitsParCategorie() {
        Map<String, Integer> result = new HashMap<>();

        List<Object[]> rows = produitRepository.countProduitsByCategorie();

        for (Object[] row : rows) {
            String nomCategorie = (String) row[0];
            Long count = (Long) row[1];
            result.put(nomCategorie, count.intValue());
        }

        return result;
    }
}
