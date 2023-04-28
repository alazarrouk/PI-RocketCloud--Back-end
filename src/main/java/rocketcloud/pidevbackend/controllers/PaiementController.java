package rocketcloud.pidevbackend.controllers;

import com.stripe.Stripe;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import rocketcloud.pidevbackend.entities.Carte;
import rocketcloud.pidevbackend.entities.Paiement;
import rocketcloud.pidevbackend.entities.User;
import rocketcloud.pidevbackend.services.PaiementService;
import rocketcloud.pidevbackend.services.StripeService;

import java.util.List;

@RestController
@RequestMapping("/paiement")
public class PaiementController {
    @Autowired
    private PaiementService paiementService;
    private StripeService stripeService;
    @PostMapping("/add/{id_user}")
    public Paiement create_paiement(@PathVariable("id_user") Long id_user, @RequestBody Paiement paiement) {
        Carte carte=new Carte();
        carte.setNumber(paiement.getNum_carte());
        carte.setCvc(paiement.getCvc());
        carte.setExp_month(paiement.getExp_mois());
        User user =new User(); // a modifier
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
    @GetMapping("/get/{id}")
    public Paiement get_paiement_by_id(@PathVariable("id") Integer id) {
        return paiementService.get_paiement(id);
    }
    @DeleteMapping("/delete/{id}")
    public void delete_paiement(@PathVariable("id") Integer id ) {paiementService.delete_paiement(id);}
}
