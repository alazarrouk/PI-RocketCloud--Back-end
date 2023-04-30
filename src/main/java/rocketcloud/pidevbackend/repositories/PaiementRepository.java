package rocketcloud.pidevbackend.repositories;

import org.springframework.data.repository.CrudRepository;
import rocketcloud.pidevbackend.entities.Paiement;

public interface PaiementRepository extends CrudRepository<Paiement,Integer> {


}
