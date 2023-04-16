package rocketcloud.pidevbackend.entities;

import javax.persistence.*;
import lombok.Data;

import java.io.Serializable;
import java.util.Date;
import java.util.Set;

@Data
@Entity
@Table(name="Paniers")
public class Panier implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id_panier")
    private int id_panier;
    @Temporal(TemporalType.DATE)
    @Column(name="created_At")
    private Date created_At;
    @Column(nullable = true)
    @ManyToMany(cascade = CascadeType.ALL) //unidirectionnelle
    private Set<Produit> produits;

    public Panier() {
    }

    public Panier(int id_panier, Date created_At, Set<Produit> produits) {
        this.id_panier = id_panier;
        this.created_At = created_At;
        this.produits = produits;
    }

    public int getId_panier() {
        return id_panier;
    }

    public void setId_panier(int id_panier) {
        this.id_panier = id_panier;
    }

    public Date getCreated_At() {
        return created_At;
    }

    public void setCreated_At(Date created_At) {
        this.created_At = created_At;
    }

    public Set<Produit> getProduits() {
        return produits;
    }

    public void setProduits(Set<Produit> produits) {
        this.produits = produits;
    }

    @Override
    public String toString() {
        return "Panier{" +
                "id_panier=" + id_panier +
                ", created_At=" + created_At +
                ", produits=" + produits +
                '}';
    }
}
