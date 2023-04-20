package rocketcloud.pidevbackend.repositories;

import org.springframework.data.repository.CrudRepository;
import rocketcloud.pidevbackend.entities.Association;

public interface AssociationRepository extends CrudRepository<Association,Integer> {
}
