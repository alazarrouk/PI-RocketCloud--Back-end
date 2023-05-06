package rocketcloud.pidevbackend.entities;

import javax.persistence.*;

import lombok.AllArgsConstructor;
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
    private int idPanier;
    @Temporal(TemporalType.DATE)
    @Column(name="created_At",nullable = true)
    private Date createdAt;

    private int quantite;
    @ManyToOne(cascade=CascadeType.ALL,optional=false)
    @JoinColumn(name = "id_produit",nullable = true)
    private Produit produit;
    @ManyToOne(cascade=CascadeType.ALL,optional=false)
    @JoinColumn(name = "id_user",nullable = true)
    private User user;

    public Panier() {
    }

    public Panier(Produit produit, User user) {
        this.produit = produit;
        this.user = user;
        this.createdAt = new Date();
    }

}
