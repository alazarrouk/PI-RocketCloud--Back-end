package rocketcloud.pidevbackend.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import rocketcloud.pidevbackend.entities.Plat;
import rocketcloud.pidevbackend.repositories.PlatRepo;
import rocketcloud.pidevbackend.services.interfaces.Iplat;

import rocketcloud.pidevbackend.repositories.RestaurantRepo;
import rocketcloud.pidevbackend.services.interfaces.Irestaurant;
@Service
public class PlatService implements Iplat {
    @Autowired
    private PlatRepo platRepo;
    @Override
    public Iterable<Plat> listAllplat() {
         return platRepo.findAll();
    }

    @Override
    public Plat addPlat(Plat plat) {
        return platRepo.save(plat);
    }

    @Override
    public Plat updatePlat(Plat plat) {
          return platRepo.save(plat);
    }

    @Override
    public void deletePlat(Integer id) {
        platRepo.deleteById(id);
    }
}
