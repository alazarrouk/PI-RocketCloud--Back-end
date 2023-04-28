package rocketcloud.pidevbackend.services;

import com.stripe.Stripe;
import com.stripe.exception.AuthenticationException;
import com.stripe.exception.StripeException;
import com.stripe.model.*;
import com.stripe.param.CustomerListParams;
import com.stripe.param.PaymentIntentCreateParams;
import rocketcloud.pidevbackend.entities.Carte;
import rocketcloud.pidevbackend.entities.User;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;


public class StripeService {
    public void setApiKey() {
        Stripe.apiKey = "sk_test_51MfpzeHNXQGXsKQNfyUWwUQiZTZm4jCJ7oR1YwabPZtSlWM1QVrd9NgJt68tHszl4x8PRdkFzZoEBYhAbyovocv600464BWMo2";
    }

    public String payment(User user, int amount, Carte carte){
        setApiKey();
        String result="";
        String customer_id=check_customer_exists(user.getEmail());
        System.out.println("old customerId :"+customer_id);
        if(customer_id.equals("")){
            customer_id=create_customer(user);
            System.out.println("new customerId :"+customer_id);
        }
        Card card=get_customer_card_by_number(customer_id,carte.getNumber());
        if(card==null){
            System.out.println("new card for the customer ");
            card=create_card(customer_id,carte);
        }
        //update_customer_default_card(card.getId(),customer_id);
        String paymentIntent=create_payment_intent(customer_id,amount);
        if(!paymentIntent.equals("")){
            confirm_payment_intent(paymentIntent);
            result=paymentIntent;
        }
        return result;
    }

    //create and confirm payment
    public String create_payment_intent(String customer_stripe_id,int amount){
        Map<String,Object> responseData=new HashMap<>();
        String response="";
        try {
            PaymentIntentCreateParams params=new PaymentIntentCreateParams.Builder()
                    .setAmount(amount*100L)
                    .setCurrency("usd")
                    .addPaymentMethodType("card")
                    .setCustomer(customer_stripe_id )
                    .build();
            PaymentIntent paymentIntent = PaymentIntent.create(params);
            response=paymentIntent.getId();
            responseData.put("paymentIntent_id",paymentIntent.getId());
        } catch (StripeException ex) {
            Logger.getLogger(StripeService.class.getName()).log(Level.SEVERE, null, ex);
        }
        return response;
    }

    public void confirm_payment_intent(String paymentIntent_id ){
        try {
            PaymentIntent paymentIntent =PaymentIntent.retrieve(paymentIntent_id);
            Map<String, Object> params = new HashMap<>();
            params.put("payment_method", "pm_card_visa");
            PaymentIntent updatedPaymentIntent =paymentIntent.confirm(params);
        } catch (StripeException ex) {

            Logger.getLogger(StripeService.class.getName()).log(Level.SEVERE, null, ex);
        }
    }


    //customers
    public String create_customer(User user){
        String customer_stripe_id="";
        try {
            Map<String, Object> params = new HashMap<>();
            Map<String, Object> metadata = new HashMap<>();
            metadata.put("id",user.getId());
            params.put("email", user.getEmail());
            params.put("name",user.getUsername());
            params.put("phone", "56353474");
            params.put("metadata",metadata);
            Customer customer = Customer.create(params);
            customer_stripe_id=customer.getId();
        } catch (StripeException ex) {
            Logger.getLogger(StripeService.class.getName()).log(Level.SEVERE, null, ex);
        }
        return customer_stripe_id;

    }

    public String check_customer_exists(String email){
        String customer_stripe_id="";
        try {
            CustomerListParams params=new CustomerListParams.Builder()
                    .setEmail(email)
                    .build();
            CustomerCollection customers=Customer.list(params);
            if(customers.getData().size()!=0){
                for(Customer customer:customers.getData()){
                    customer_stripe_id=customer.getId();
                }
            };
        }catch (StripeException ex) {
            Logger.getLogger(StripeService.class.getName()).log(Level.SEVERE, null, ex);
        }
        return customer_stripe_id;
    }


    //credit_cards
    public Card create_card(String customer_stripe_id,Carte carte ){
        Card new_card=null;
        try {
            Map<String, Object> retrieveParams =new HashMap<>();
            List<String> expandList = new ArrayList<>();
            expandList.add("sources");
            retrieveParams.put("expand", expandList);
            Customer customer =Customer.retrieve(customer_stripe_id,retrieveParams,null);
            //create token card
            Map<String, Object> card = new HashMap<>();
            card.put("number", carte.getNumber());
            card.put("exp_month", carte.getExp_month());
            card.put("exp_year", carte.getExp_year());
            card.put("cvc", carte.getCvc());
            card.put("name", customer.getName());
            Map<String, Object> metadata =new HashMap<>();
            metadata.put("card_identifier",carte.getNumber());
            card.put("metadata", metadata);
            Map<String, Object> params_card = new HashMap<>();
            params_card.put("card", card);
            Token token = Token.create(params_card);
            //create the card
            Map<String, Object> params = new HashMap<>();
            params.put("source", token.getId());
            Card card_payment =(Card) customer.getSources().create(params);
            new_card=card_payment;
        } catch (StripeException ex) {
            Logger.getLogger(StripeService.class.getName()).log(Level.SEVERE, null, ex);
        }
        return new_card;
    }

    public void get_customer_cards(String customer_stripe_id){
        try {
            List<String> expandList = new ArrayList<>();
            expandList.add("sources");
            Map<String, Object> retrieveParams = new HashMap<>();
            retrieveParams.put("expand", expandList);
            Customer customer =Customer.retrieve(customer_stripe_id,retrieveParams,null);
            Map<String, Object> params = new HashMap<>();
            params.put("object", "card");
            PaymentSourceCollection cards =customer.getSources().list(params);
            System.out.println("cards"+cards.getData());
        }catch (StripeException ex) {
            Logger.getLogger(StripeService.class.getName()).log(Level.SEVERE, null, ex);
        }
    }


    public Card get_customer_card_by_id(String customer_stripe_id, String card_stripe_id){
        Card card=null;
        try {
            Map<String, Object> retrieveParams =new HashMap<>();
            List<String> expandList = new ArrayList<>();
            expandList.add("sources");
            retrieveParams.put("expand", expandList);
            Customer customer =Customer.retrieve(customer_stripe_id,retrieveParams,null);
            card =(Card) customer.getSources().retrieve(card_stripe_id);

        } catch (StripeException ex) {
            Logger.getLogger(StripeService.class.getName()).log(Level.SEVERE, null, ex);
        }
        return card;
    }

    public Card get_customer_card_by_number(String customer_stripe_id,String card_number){
        Card card=null;
        try {
            List<String> expandList = new ArrayList<>();
            expandList.add("sources");
            Map<String, Object> retrieveParams = new HashMap<>();
            retrieveParams.put("expand", expandList);
            Customer customer =Customer.retrieve(customer_stripe_id,retrieveParams,null);
            Map<String, Object> params = new HashMap<>();
            params.put("object", "card");
            PaymentSourceCollection cards =customer.getSources().list(params);
            for ( PaymentSource card_data : cards.getData()){
                Card new_card=(Card) card_data;
                String card_identifier=new_card.getMetadata().get("card_identifier");
                if(card_identifier.equals(card_number)){
                    return new_card;
                }
            }
        } catch (StripeException ex) {
            Logger.getLogger(StripeService.class.getName()).log(Level.SEVERE, null, ex);
        }
        return card;
    }

    @Override
    public String toString() {
        return "StripeService []";
    }
}
