package rocketcloud.pidevbackend.services.Interfaces;


import rocketcloud.pidevbackend.entities.Categorie;

import java.util.List;

public interface ICategorieServiceImp {
    Categorie addCategorie(Categorie categorie);
    List<Categorie> retrieveAllCategories();
    void deleteCategorie(Categorie categorie);
    Categorie getCategorie(int idCategorie);
}
