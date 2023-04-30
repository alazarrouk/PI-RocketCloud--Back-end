package rocketcloud.pidevbackend.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import rocketcloud.pidevbackend.entities.Restaurant;
import rocketcloud.pidevbackend.services.interfaces.Irestaurant;


@Controller
@RestController
@RequestMapping("/restaurant")
public class RestaurantController {
    @Autowired
    private Irestaurant irestaurant;


    @PostMapping("/addrestaurant")
    public Restaurant addRestaurant(@RequestBody Restaurant restaurant){
        return irestaurant.addRestaurant(restaurant);
    }

    @DeleteMapping("/delete/{id}")
    public String deleterestaurant(@PathVariable int id) {
        irestaurant.deleteRestaurant(id);
        return "done";
    }
    @GetMapping("/getAll")
    public Iterable<Restaurant> listAllrestaurant(){
        return irestaurant.listAllrestaurant();
    }
    @PostMapping("/updaterestaurant")
    public Restaurant updateRestaurant(@RequestBody Restaurant restaurant){
        return irestaurant.updateRestaurant(restaurant);
    }






}
