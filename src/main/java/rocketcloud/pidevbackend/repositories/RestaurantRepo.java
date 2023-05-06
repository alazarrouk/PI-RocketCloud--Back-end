package rocketcloud.pidevbackend.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;

import org.springframework.stereotype.Repository;
import rocketcloud.pidevbackend.entities.Restaurant;
@Repository
public interface RestaurantRepo  extends JpaRepository<Restaurant,Integer> {
//    Restaurant findRestaurantByNom_restaurant(String nom_restaurant);

}
