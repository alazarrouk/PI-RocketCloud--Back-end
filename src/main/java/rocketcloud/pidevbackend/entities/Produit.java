package rocketcloud.pidevbackend.entities;
import com.fasterxml.jackson.annotation.*;
import javax.persistence.*;
import lombok.Data;

import java.io.Serializable;
import java.util.Date;

@Data
@Entity
@Table(name = "produits")
public class Produit implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id_produit")
    private int idProduit;
    @Column(name="nom_produit")
    private String nomProduit;

    @Column(name="image_produit")
    private String imageProduit;
    @Column(name="prix_actuel")
    private float prixActuel;
    @Column(name="prix_reduction")
    private float prixRreduction;
    private int quantite;
    private String description;

    @Column(name="date_expiration")
    private String dateExpiration;

    @ManyToOne(cascade=CascadeType.ALL)
    @JoinColumn(name = "id_categorie")
    private Categorie categorie;

    @ManyToOne(cascade=CascadeType.ALL)
    @JoinColumn(name = "id_vendeur")
    private Vendeur vendeur;

    private int likes;
    private int unlikes;

    public Produit() {
    }
    public void incrementLikes() {
        this.likes++;
    }

    public void incrementUnlikes() {
        this.unlikes++;
    }





}
