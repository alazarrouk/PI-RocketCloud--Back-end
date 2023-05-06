package rocketcloud.pidevbackend.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import rocketcloud.pidevbackend.entities.Restaurant;
import rocketcloud.pidevbackend.services.RestaurantService;
import rocketcloud.pidevbackend.services.interfaces.Irestaurant;


@RestController
@RequestMapping("/restaurant")
//@CrossOrigin(origins = "*", allowedHeaders = "*")
@CrossOrigin(origins = "http://localhost:4200")


public class RestaurantController {
    @Autowired
    private Irestaurant irestaurant;
    @Autowired
    private RestaurantService restaurantService;

    @PostMapping("/addrestaurant")
    public Restaurant addRestaurant(@RequestBody Restaurant restaurant){
        System.out.println("resto"+restaurant);
        return irestaurant.addRestaurant(restaurant);
    }

    @DeleteMapping("/delete/{id}")
    public void deleterestaurant(@PathVariable int id) {
        irestaurant.deleteRestaurant(id);
    }
 //   @CrossOrigin(origins = "http://localhost:4200")

    @GetMapping("/getAll")
    public Iterable<Restaurant> listAllrestaurant(){
        return irestaurant.listAllrestaurant();
    }
    @PostMapping("/updaterestaurant")
    public Restaurant updateRestaurant(@RequestBody Restaurant restaurant){
        return irestaurant.updateRestaurant(restaurant);
    }
  //  @GetMapping("/{nom_restaurant}")
    //public Restaurant getRestaurantByNom(@PathVariable String nom_restaurant) {
       // return irestaurant.getRestaurantByNom(nom_restaurant);


  //  }


}
