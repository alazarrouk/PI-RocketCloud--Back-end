package rocketcloud.pidevbackend.repositories;

import org.springframework.data.repository.CrudRepository;
import rocketcloud.pidevbackend.entities.Reservation;
import rocketcloud.pidevbackend.entities.Restaurant;

public interface ReservationRepo  extends CrudRepository<Reservation,Integer> {
}
