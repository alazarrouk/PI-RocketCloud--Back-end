package rocketcloud.pidevbackend.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import rocketcloud.pidevbackend.entities.Reservation;
import rocketcloud.pidevbackend.entities.Restaurant;
import rocketcloud.pidevbackend.services.interfaces.Ireservation;

@Controller
@RestController
@RequestMapping("/reservation")

public class ReservationController {
    @Autowired
    private Ireservation ireservation;


    @PostMapping("/addreservation")
    public Reservation addReservation(@RequestBody Reservation reservation){
        return ireservation.addReservation(reservation);
    }

    @DeleteMapping("/delete/{id}")
    public String deletereservation(@PathVariable int id) {
        ireservation.deleteReservation(id);
        return "done";
    }
    @GetMapping("/getAll")
    public Iterable<Reservation> listAllreservation(){
        return ireservation.listAllreservaton();
    }
    @PostMapping("/updatereservation")
    public Reservation updateRestaurant(@RequestBody Reservation reservation){
        return ireservation.updateReservation(reservation);
    }
}
