package rocketcloud.pidevbackend.services;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import rocketcloud.pidevbackend.entities.Categorie;
import rocketcloud.pidevbackend.repositories.CategorieRepository;
import rocketcloud.pidevbackend.services.interfaces.ICategorieServiceImp;

import java.util.List;

@Service
public class CategorieServiceImp implements ICategorieServiceImp {
    @Autowired
    private CategorieRepository categorieRepository;

    public Categorie addCategorie(Categorie categorie) {
        return categorieRepository.save(categorie);
    }

    public void deleteCategorie(Categorie categorie) {
        categorieRepository.delete(categorie);
    }

    public List<Categorie> retrieveAllCategories() {
        List<Categorie> listCategories = (List) categorieRepository.findAll();
        return listCategories;
    }

    public Categorie getCategorie(int idCategorie) {
        return categorieRepository.findById(idCategorie).get();
    }
}
