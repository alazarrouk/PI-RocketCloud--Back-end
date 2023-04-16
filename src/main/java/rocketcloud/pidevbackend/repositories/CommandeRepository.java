package rocketcloud.pidevbackend.repositories;

import org.springframework.data.repository.CrudRepository;
import rocketcloud.pidevbackend.entities.Commande;

public interface CommandeRepository extends CrudRepository<Commande,Integer> {
}
