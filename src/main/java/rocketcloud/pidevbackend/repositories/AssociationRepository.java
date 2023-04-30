package rocketcloud.pidevbackend.repositories;

import org.springframework.data.repository.CrudRepository;
import rocketcloud.pidevbackend.entities.Association;
import rocketcloud.pidevbackend.entities.Commande;

import java.util.Date;
import java.util.List;

public interface AssociationRepository extends CrudRepository<Association,Integer> {
}
