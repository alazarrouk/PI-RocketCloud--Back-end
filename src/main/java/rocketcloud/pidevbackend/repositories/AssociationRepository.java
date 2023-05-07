package rocketcloud.pidevbackend.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import rocketcloud.pidevbackend.entities.Association;
import rocketcloud.pidevbackend.entities.Commande;

import java.util.Date;
import java.util.List;

public interface AssociationRepository extends JpaRepository<Association,Integer> {
    @Query("SELECT a.nom AS name, COUNT(d.id_don) AS value " +
            "FROM Association a " +
            "LEFT JOIN a.dons d " +
            "GROUP BY a.id_association")
    List<Object[]> getStatAssociationsNbrDon();





}
