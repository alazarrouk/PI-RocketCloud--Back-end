package rocketcloud.pidevbackend.services.interfaces;

import rocketcloud.pidevbackend.entities.Plat;
import rocketcloud.pidevbackend.entities.Restaurant;

public interface Iplat {
    Iterable<Plat> listAllplat();

   // Restaurant getrestaurantById(Integer id);

    Plat addPlat(Plat plat);
    Plat updatePlat(Plat plat);

    void deletePlat(Integer id);

}
