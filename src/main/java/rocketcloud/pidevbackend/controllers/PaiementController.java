package rocketcloud.pidevbackend.controllers;

import com.stripe.Stripe;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import rocketcloud.pidevbackend.entities.Carte;
import rocketcloud.pidevbackend.entities.Commande;
import rocketcloud.pidevbackend.entities.Paiement;
import rocketcloud.pidevbackend.entities.User;
import rocketcloud.pidevbackend.services.CommandeService;
import rocketcloud.pidevbackend.services.PaiementService;
import rocketcloud.pidevbackend.services.StripeService;
import rocketcloud.pidevbackend.services.iUserServiceImp;

import java.util.*;

@RestController
@RequestMapping("/paiement")
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class PaiementController {
    @Autowired
    private PaiementService paiementService;
    @Autowired
    private iUserServiceImp userService;
    @Autowired
    public StripeService stripeService;
    @Autowired
    public CommandeService commandeService;
    @PostMapping("/add/{id_user}")
    public Paiement create_paiement(@PathVariable("id_user") Long id_user, @RequestBody Paiement paiement) {
        Carte carte=new Carte();
        carte.setNumber(paiement.getNum_carte());
        carte.setCvc(paiement.getCvc());
        carte.setExp_month(paiement.getExp_mois());
        carte.setExp_year(paiement.getExp_annee());
        User user= (userService.getUser(id_user)).orElse(new User());
        String paymentIntent= stripeService.payment(user,(int) paiement.getMontant(),carte);
        if( paymentIntent=="")
            return null;
        paiement.setPaymentIntent_id(paymentIntent);
        return paiementService.create_paiement(paiement);
    }
    @GetMapping("/get")
    public List<Paiement> get_paiements(){
        return paiementService.get_paiements();
    }
    @GetMapping("/getAll")
    public List<Map<String, Object>> get_paiementsWithData(){
        List<Paiement> listPaiements=paiementService.get_paiements();
        List<Map<String, Object>> paymentsWithData = new ArrayList<>();
        for (Paiement payment : listPaiements) {
            Commande commande= commandeService.get_commande_by_paiement(payment);
            Map<String, Object> paymentWithUser = new HashMap<>();
            paymentWithUser.put("payment", payment);
            paymentWithUser.put("commande", commande);
            paymentsWithData.add(paymentWithUser);
        }
        return paymentsWithData;
    }

    @GetMapping("/get/{id}")
    public Paiement get_paiement_by_id(@PathVariable("id") Integer id) {
        return paiementService.get_paiement(id);
    }

    @GetMapping("/get/stats/sum/montant/bymonth")
    public List<Object[]> get_sum_paiement_grouped_by_month(){
        return paiementService.get_total_paiement_grouped_by_month() ; }
    @GetMapping("/get/stats/sum/montant/byweek")
    public List<Object[]> get_sum_paiement_grouped_by_week(){
        return paiementService.getMontantSumByWeek() ; }
    @GetMapping("/get/stats/sum/montant/bydayoftheweek")
    public List<Object[]> get_sum_paiement_grouped_by_dayoftheweek(){
        return paiementService.getsumMontantByDayOfWeek(); }
}
