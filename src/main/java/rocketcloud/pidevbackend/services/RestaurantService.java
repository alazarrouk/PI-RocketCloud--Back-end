package rocketcloud.pidevbackend.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import rocketcloud.pidevbackend.entities.Restaurant;
import rocketcloud.pidevbackend.repositories.RestaurantRepo;
import rocketcloud.pidevbackend.services.interfaces.Irestaurant;
@Service

public class RestaurantService implements Irestaurant {
    @Autowired
    private RestaurantRepo restaurantRepo;

    @Override
    public Iterable<Restaurant> listAllrestaurant() {
        return restaurantRepo.findAll();

    }

    @Override
    public Restaurant getrestaurantById(Integer id) {
        return null;
    }

    @Override
    public Restaurant addRestaurant(Restaurant restaurant) {
        return restaurantRepo.save(restaurant);

    }

    @Override
    public Restaurant updateRestaurant(Restaurant restaurant) {
        return restaurantRepo.save(restaurant);

    }


    @Override
    public void deleteRestaurant(Integer id) {
        restaurantRepo.deleteById(id);

    }


}
