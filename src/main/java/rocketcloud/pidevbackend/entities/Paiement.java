package rocketcloud.pidevbackend.entities;

import javax.persistence.*;
import lombok.Data;

import java.io.Serializable;
import java.util.Date;
@Data
@Entity
@Table(name="Paiements")
public class Paiement implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_paiement")
    private int id_paiement;
    @Temporal(TemporalType.DATE)
    @Column(name = "date")
    private Date date;
    @Column(name = "nom_carte")
    private String nom_carte;
    @Column(name = "num_carte")
    private String num_carte;
    @Column(name = "exp_mois")
    private int exp_mois;
    @Column(name = "exp_annee")
    private int exp_annee;
    @Column(name = "cvc")
    private int cvc;
    @Column(name = "montant")
    private float montant;
    @Column(name = "paymentIntent_id")
    private String paymentIntent_id;

    public Paiement() {
    }

    public Paiement(int id_paiement, Date date, String nom_carte, String num_carte, int exp_mois, int exp_annee, int cvc, float montant, String paymentIntent_id) {
        this.id_paiement = id_paiement;
        this.date = date;
        this.nom_carte = nom_carte;
        this.num_carte = num_carte;
        this.exp_mois = exp_mois;
        this.exp_annee = exp_annee;
        this.cvc = cvc;
        this.montant = montant;
        this.paymentIntent_id = paymentIntent_id;
    }

    public int getId_paiement() {
        return id_paiement;
    }

    public void setId_paiement(int id_paiement) {
        this.id_paiement = id_paiement;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public String getNom_carte() {
        return nom_carte;
    }

    public void setNom_carte(String nom_carte) {
        this.nom_carte = nom_carte;
    }

    public String getNum_carte() {
        return num_carte;
    }

    public void setNum_carte(String num_carte) {
        this.num_carte = num_carte;
    }

    public int getExp_mois() {
        return exp_mois;
    }

    public void setExp_mois(int exp_mois) {
        this.exp_mois = exp_mois;
    }

    public int getExp_annee() {
        return exp_annee;
    }

    public void setExp_annee(int exp_annee) {
        this.exp_annee = exp_annee;
    }

    public int getCvc() {
        return cvc;
    }

    public void setCvc(int cvc) {
        this.cvc = cvc;
    }

    public float getMontant() {
        return montant;
    }

    public void setMontant(float montant) {
        this.montant = montant;
    }

    public String getPaymentIntent_id() {
        return paymentIntent_id;
    }

    public void setPaymentIntent_id(String paymentIntent_id) {
        this.paymentIntent_id = paymentIntent_id;
    }

    @Override
    public String toString() {
        return "Paiement{" +
                "id_paiement=" + id_paiement +
                ", date=" + date +
                ", nom_carte='" + nom_carte + '\'' +
                ", num_carte='" + num_carte + '\'' +
                ", exp_mois='" + exp_mois + '\'' +
                ", exp_annee='" + exp_annee + '\'' +
                ", cvc=" + cvc +
                ", montant=" + montant +
                ", paymentIntent_id='" + paymentIntent_id + '\'' +
                '}';
    }
}