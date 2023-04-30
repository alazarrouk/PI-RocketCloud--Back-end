package rocketcloud.pidevbackend.entities;


import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;
import java.util.Set;

@Data
@Entity
@Table(name = "Dons")
public class Don  implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id_don")
    private int id_don;
    @Column(name="date")
    @Temporal(TemporalType.DATE)
    private Date date;
    @Column(name="montant")
    private float montant;
    @OneToMany(cascade = CascadeType.ALL)
    private Set<Produit> produits;
    @ManyToOne
    User user;

    public Don() {
    }

    public Don(int id_don, Date date, float montant, Set<Produit> produits, Association association, User user) {
        this.id_don = id_don;
        this.date = date;
        this.montant = montant;
        this.produits = produits;
        this.user = user;
    }

    public int getId_don() {
        return id_don;
    }

    public void setId_don(int id_don) {
        this.id_don = id_don;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public float getMontant() {
        return montant;
    }

    public void setMontant(float montant) {
        this.montant = montant;
    }

    public Set<Produit> getProduits() {
        return produits;
    }

    public void setProduits(Set<Produit> produits) {
        this.produits = produits;
    }


    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    @Override
    public String toString() {
        return "Don{" +
                "id_don=" + id_don +
                ", date=" + date +
                ", montant=" + montant +
                ", produits=" + produits +
                ", user=" + user +
                '}';
    }
}