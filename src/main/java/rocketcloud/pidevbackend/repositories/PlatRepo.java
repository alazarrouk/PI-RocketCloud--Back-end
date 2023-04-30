package rocketcloud.pidevbackend.repositories;

import org.springframework.data.repository.CrudRepository;
import rocketcloud.pidevbackend.entities.Plat;
import rocketcloud.pidevbackend.entities.Restaurant;

public interface PlatRepo extends CrudRepository<Plat,Integer> {
}
