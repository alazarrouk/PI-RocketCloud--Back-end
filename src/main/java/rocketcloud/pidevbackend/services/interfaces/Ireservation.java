package rocketcloud.pidevbackend.services.interfaces;

import rocketcloud.pidevbackend.entities.Reservation;

public interface Ireservation {
    Iterable<Reservation> listAllreservaton();


    Reservation addReservation(Reservation reservation);
    Reservation updateReservation(Reservation reservation);

    void deleteReservation(Integer id);
    int getnbreservation();
    int getnbreservationyear();
    int getnbreservationMonth();

}
