package rocketcloud.pidevbackend.services.interfaces;

import rocketcloud.pidevbackend.entities.Restaurant;

public interface Irestaurant {
    Iterable<Restaurant> listAllrestaurant();

    Restaurant getrestaurantById(Integer id);

    Restaurant addRestaurant(Restaurant restaurant);
    Restaurant updateRestaurant(Restaurant restaurant);

    void deleteRestaurant(Integer id);

}
