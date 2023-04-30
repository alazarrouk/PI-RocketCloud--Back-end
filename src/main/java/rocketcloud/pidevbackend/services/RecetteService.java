package rocketcloud.pidevbackend.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import rocketcloud.pidevbackend.entities.Recette;
import rocketcloud.pidevbackend.repositories.RecetteRepo;
import rocketcloud.pidevbackend.services.interfaces.IRecette;

import java.util.List;

@Service
public class RecetteService implements IRecette {
    @Autowired
    private RecetteRepo recetteRepo ;
    @Override
    public Recette addRecette(Recette recette) {

        return recetteRepo.save(recette);

    }

    @Override
    public Iterable<Recette> getRecette() {
        return recetteRepo.findAll();
    }

//    @Override
//    public List<Recette> getRecetteByName(Recette recette) {
//        return recetteRepo.findByName(recette);
//    }

    @Override
    public Recette updateRecette(Recette recette) {
        return recetteRepo.save(recette);
    }

    @Override
    public void removeRecette(int id) {
        recetteRepo.deleteById(id);
    }
}
