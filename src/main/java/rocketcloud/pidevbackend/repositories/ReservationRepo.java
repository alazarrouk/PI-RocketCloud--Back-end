package rocketcloud.pidevbackend.repositories;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import rocketcloud.pidevbackend.entities.Reservation;
import rocketcloud.pidevbackend.entities.Restaurant;

public interface ReservationRepo  extends CrudRepository<Reservation,Integer> {
    @Query("SELECT COUNT(r) FROM Reservation r WHERE  FUNCTION('DATE', r.date_reservation) = FUNCTION('DATE', CURRENT_TIMESTAMP)")

    Integer getCountReservation();
    @Query("SELECT COUNT(r) FROM Reservation r  WHERE YEAR(r.date_reservation) = YEAR(CURRENT_TIMESTAMP)")


    Integer getCountReservationyear();
    @Query("SELECT COUNT(r) FROM Reservation r  WHERE month (r.date_reservation) = month(CURRENT_TIMESTAMP)")
    Integer getCountReservationmonth();
}
