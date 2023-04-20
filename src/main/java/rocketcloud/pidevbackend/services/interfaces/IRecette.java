package rocketcloud.pidevbackend.services.interfaces;

import rocketcloud.pidevbackend.entities.Recette;

import java.util.List;

public interface IRecette {
    Recette addRecette(Recette recette);
    void removeRecette(int id);
    Recette updateRecette(Recette recette);

    Iterable<Recette> getRecette();
//    List<Recette> getRecetteByName(Recette recette);
}
