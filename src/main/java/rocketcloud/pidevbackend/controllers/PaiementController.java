package rocketcloud.pidevbackend.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import rocketcloud.pidevbackend.entities.Paiement;
import rocketcloud.pidevbackend.services.PaiementService;

import java.util.List;

@RestController
@RequestMapping("/paiement")
public class PaiementController {
    @Autowired
    private PaiementService paiementService;
    @PostMapping("/add")
    public Paiement create_paiement(@RequestBody Paiement paiement) {return paiementService.create_paiement(paiement);}
    @GetMapping("/get")
    public List<Paiement> get_paiements(){
        return paiementService.get_paiements();
    }
    @GetMapping("/get/{id}")
    public Paiement get_paiement_by_id(@PathVariable("id") Integer id) {
        return paiementService.get_paiement(id);
    }
    @DeleteMapping("/delete/{id}")
    public void delete_paiement(@PathVariable("id") Integer id ) {paiementService.delete_paiement(id);}
}
