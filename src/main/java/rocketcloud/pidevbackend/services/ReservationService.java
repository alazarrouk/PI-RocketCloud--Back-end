package rocketcloud.pidevbackend.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import rocketcloud.pidevbackend.entities.Reservation;
import rocketcloud.pidevbackend.repositories.ReservationRepo;
import rocketcloud.pidevbackend.services.interfaces.Ireservation;
@Service

public class ReservationService implements Ireservation {
    @Autowired
    private ReservationRepo reporeservation;
    @Override
    public Iterable<Reservation> listAllreservaton() {
          return reporeservation.findAll();
    }

    @Override
    public Reservation addReservation(Reservation reservation) {
        return  reporeservation.save(reservation);
    }

    @Override
    public Reservation updateReservation(Reservation reservation) {
        return  reporeservation.save(reservation);
    }

    @Override
    public void deleteReservation(Integer id) {
        reporeservation.deleteById(id);

    }
}
