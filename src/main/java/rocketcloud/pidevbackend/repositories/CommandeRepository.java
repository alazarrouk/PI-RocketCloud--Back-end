package rocketcloud.pidevbackend.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import rocketcloud.pidevbackend.entities.Commande;
import rocketcloud.pidevbackend.entities.User;

import java.util.Date;
import java.util.List;
import java.util.Set;

public interface CommandeRepository extends JpaRepository<Commande,Integer> {
    List<Commande> findCommandeByDate(Date date);
    List<Commande> findCommandeByUser(User user);
    List<Commande> findCommandeByUserAndDate(User user, Date date);

}
