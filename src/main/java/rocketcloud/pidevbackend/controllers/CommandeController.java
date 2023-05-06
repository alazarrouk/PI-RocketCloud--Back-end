package rocketcloud.pidevbackend.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import rocketcloud.pidevbackend.entities.Commande;
import rocketcloud.pidevbackend.entities.Paiement;
import rocketcloud.pidevbackend.services.CommandeService;
import rocketcloud.pidevbackend.services.PaiementService;

import java.util.List;
import java.util.Set;


@RestController
@RequestMapping("/commande")
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class CommandeController {
    @Autowired
    private CommandeService commandeService;
    @Autowired
    private PaiementService paiementService;

    @PostMapping("/add")
    public Commande create_commande(@RequestBody Commande commande) {return commandeService.create_commande(commande);}
    @DeleteMapping("/delete/{id}")
    public void delete_commande(@PathVariable("id") Integer id ) { commandeService.delete_commande(id);}
    @PutMapping("/update")
    public Commande update_commande(@RequestBody Commande commande) {
        return commandeService.update_commande(commande);
    }
    @GetMapping("/get")
    public List<Commande> get_commandes(){return commandeService.get_commandes();}
    @GetMapping("/get/{id}")
    public Commande get_commande_by_id(@PathVariable("id") Integer id) {
        return commandeService.get_commande(id);
    }
    @GetMapping("/get/bypaiement")
    public Commande get_commande_by_paiement(@RequestBody Paiement paiement) {
         return commandeService.get_commande_by_paiement(paiement);
    }
    @GetMapping("/get/user/date")
    public List<Commande> get_commandes_by_user_and_date(){return commandeService.get_commandes();}

    @GetMapping("/get/stats/count/bystatus/{status}")
    public Integer get_count_commandes_by_status(@PathVariable("status") String status){
        return commandeService.get_count_commande_by_status(status);
    }
    @GetMapping("/get/stats/sum/total/bystatus/{status}")
    public Float get_sum_total_commandes_by_status(@PathVariable("status") String status){
        return commandeService.get_sum_total_commande_by_status(status);
    }
    @GetMapping("/get/stats/count/byyear/{year}")
    public Integer get_count_commandes_by_year(@PathVariable("year") int year){
        return commandeService.get_count_commande_by_year(year);
    }
    @GetMapping("/get/stats/count")
    public Integer get_count_commandes(){
        return commandeService.get_count_commande();
    }
    @GetMapping("/get/stats/count/bytoday")
    public Integer get_count_commandes_by_today(){
        return commandeService.get_count_today_commande();  }

    @GetMapping("/get/test")
    public Float test(){
        return commandeService.get_sum_total_commande_by_status("confirmée");
    }



}
