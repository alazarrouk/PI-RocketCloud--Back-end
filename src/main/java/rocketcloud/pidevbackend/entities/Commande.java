package rocketcloud.pidevbackend.entities;

import javax.persistence.*;
import lombok.Data;

import java.util.Set;

@Data
@Entity
@Table(name="Commandes")
public class Commande {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id_commande")
    private int id_commande;

    @Column(name="total")
    private float total;
    @ManyToOne
    User user;
    @OneToOne
    private Paiement paiement;

    @ManyToMany(cascade = CascadeType.ALL) //unidirictionnelle
    private Set<Produit> produits;

    public Commande() {
    }

    public Commande(int id_commande, float total, User user, Paiement paiement, Set<Produit> produits) {
        this.id_commande = id_commande;
        this.total = total;
        this.user = user;
        this.paiement = paiement;
        this.produits = produits;
    }

    public int getId_commande() {
        return id_commande;
    }

    public void setId_commande(int id_commande) {
        this.id_commande = id_commande;
    }

    public float getTotal() {
        return total;
    }

    public void setTotal(float total) {
        this.total = total;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Paiement getPaiement() {
        return paiement;
    }

    public void setPaiement(Paiement paiement) {
        this.paiement = paiement;
    }

    public Set<Produit> getProduits() {
        return produits;
    }

    public void setProduits(Set<Produit> produits) {
        this.produits = produits;
    }

    @Override
    public String toString() {
        return "Commande{" +
                "id_commande=" + id_commande +
                ", total=" + total +
                ", user=" + user +
                ", paiement=" + paiement +
                ", produits=" + produits +
                '}';
    }
}
