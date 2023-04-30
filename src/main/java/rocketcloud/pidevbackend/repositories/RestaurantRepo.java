package rocketcloud.pidevbackend.repositories;

import org.springframework.data.repository.CrudRepository;

import org.springframework.stereotype.Repository;
import rocketcloud.pidevbackend.entities.Restaurant;
@Repository
public interface RestaurantRepo  extends CrudRepository<Restaurant,Integer> {
}
