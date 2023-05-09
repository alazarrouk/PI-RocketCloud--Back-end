package rocketcloud.pidevbackend.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import rocketcloud.pidevbackend.entities.Commande;
import rocketcloud.pidevbackend.entities.Paiement;
import rocketcloud.pidevbackend.entities.User;

import java.util.Date;
import java.util.List;
import java.util.Set;

public interface CommandeRepository extends JpaRepository<Commande,Integer> {
    List<Commande> findCommandeByDate(Date date);
    List<Commande> findCommandesByUserOrderByDateDesc(User user);
    List<Commande> findCommandeByUserAndDate(User user, Date date);
    Commande findCommandeByPaiement(Paiement paiement);
    @Query("SELECT count(c) FROM Commande c WHERE c.status = :status")
    Integer getCountCommandeByStatus (@Param("status") String status);
    @Query("SELECT COUNT(c) FROM Commande c WHERE YEAR(c.date) = :year")
    Integer getCountCommandeByYear(@Param("year") Integer year);
    @Query("SELECT SUM(c.total) FROM Commande c WHERE  c.status = :status")
    Float getSumTotalCommandeByStatus(@Param("status") String status);
    @Query("SELECT COUNT(c) FROM Commande c")
    Integer getCountCommandes();

    @Query("SELECT COUNT(c) FROM Commande c WHERE FUNCTION('DATE', c.date) = FUNCTION('DATE', CURRENT_TIMESTAMP)")
    Integer getCountCommandesToday();







}
