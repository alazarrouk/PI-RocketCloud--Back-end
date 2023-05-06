package rocketcloud.pidevbackend.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import rocketcloud.pidevbackend.entities.Plat;
import rocketcloud.pidevbackend.services.interfaces.Iplat;

@Controller
@RestController
@RequestMapping("/plat")
public class PlatController {
    @Autowired
    private Iplat iplat;


    @PostMapping("/addplat")
    public Plat addplat(@RequestBody Plat plat){
        return iplat.addPlat(plat);
    }

    @DeleteMapping("/delete/{id}")
    public void deleteplat(@PathVariable int id) {
        iplat.deletePlat(id);
    }
    @GetMapping("/getAll")
    public Iterable<Plat> listAllrestaurant(){
        return iplat.listAllplat();
    }
    @PostMapping("/updateplat")
    public Plat updateRestaurant(@RequestBody Plat plat){
        return iplat.updatePlat(plat);
    }

}
