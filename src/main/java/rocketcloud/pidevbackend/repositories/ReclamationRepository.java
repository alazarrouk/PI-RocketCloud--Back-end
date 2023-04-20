package rocketcloud.pidevbackend.repositories;
import org.springframework.data.repository.CrudRepository;
import rocketcloud.pidevbackend.entities.Reclamation;

public interface ReclamationRepository extends CrudRepository <Reclamation,Integer> {
}
