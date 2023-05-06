package rocketcloud.pidevbackend.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import rocketcloud.pidevbackend.entities.Paiement;

import java.util.List;

public interface PaiementRepository extends JpaRepository<Paiement,Integer> {

    @Query("SELECT \n" +
            "  CASE FUNCTION('MONTH', p.date)\n" +
            "    WHEN 1 THEN 'Jan'\n" +
            "    WHEN 2 THEN 'Fév'\n" +
            "    WHEN 3 THEN 'Mar'\n" +
            "    WHEN 4 THEN 'Avr'\n" +
            "    WHEN 5 THEN 'Mai'\n" +
            "    WHEN 6 THEN 'Juin'\n" +
            "    WHEN 7 THEN 'Juil'\n" +
            "    WHEN 8 THEN 'Août'\n" +
            "    WHEN 9 THEN 'Sept'\n" +
            "    WHEN 10 THEN 'Oct'\n" +
            "    WHEN 11 THEN 'Nov'\n" +
            "    WHEN 12 THEN 'Déc'\n" +
            "  END AS month,\n" +
            "  COALESCE(SUM(p.montant), 0) AS sumMontant\n" +
            "FROM Paiement p\n" +
            "WHERE FUNCTION('YEAR', p.date) = FUNCTION('YEAR', CURRENT_DATE)\n" +
            "GROUP BY FUNCTION('MONTH', p.date)\n")
    public List<Object[]> get_monthly_montant();

    @Query("SELECT WEEK(p.date) as week, SUM(p.montant) as total FROM Paiement p WHERE YEAR(p.date) = YEAR(CURRENT_DATE) AND MONTH(p.date) = MONTH(CURRENT_DATE) GROUP BY WEEK(p.date)")
    List<Object[]> getMontantSumByWeek();
    @Query("SELECT DAYNAME(p.date), SUM(p.montant) " +
            "FROM Paiement p " +
            "WHERE YEAR(p.date) = YEAR(CURRENT_DATE()) " +
            "AND WEEK(p.date) = WEEK(CURRENT_DATE()) " +
            "GROUP BY DAYNAME(p.date)")
    List<Object[]> getsumMontantByDayOfWeek();

}
