package rocketcloud.pidevbackend.services.interfaces;

import rocketcloud.pidevbackend.entities.Reservation;
import rocketcloud.pidevbackend.entities.Restaurant;

public interface Ireservation {
    Iterable<Reservation> listAllreservaton();


    Reservation addReservation(Reservation reservation);
    Reservation updateReservation(Reservation reservation);

    void deleteReservation(Integer id);
}
