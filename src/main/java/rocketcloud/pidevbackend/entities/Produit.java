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
    @Column(name="quantite")
    private int quantite;
    private String description;
    @Column(name="date_expiration")
    private Date dateExpiration;

   @ManyToOne(cascade=CascadeType.ALL)
   @JoinColumn(name = "id_categorie")
   private Categorie categorie;
    @ManyToOne(fetch = FetchType.EAGER)
    private User user;
    public Produit() {
    }

    public Produit(int idProduit, String nomProduit, String imageProduit, float prixActuel, float prixRreduction, int quantite, String description, Date dateExpiration, Categorie categorie, User user) {
        this.idProduit = idProduit;
        this.nomProduit = nomProduit;
        this.imageProduit = imageProduit;
        this.prixActuel = prixActuel;
        this.prixRreduction = prixRreduction;
        this.quantite = quantite;
        this.description = description;
        this.dateExpiration = dateExpiration;
        this.categorie = categorie;
        this.user = user;
    }

    public int getIdProduit() {
        return idProduit;
    }

    public void setIdProduit(int idProduit) {
        this.idProduit = idProduit;
    }

    public String getNomProduit() {
        return nomProduit;
    }

    public void setNomProduit(String nomProduit) {
        this.nomProduit = nomProduit;
    }

    public String getImageProduit() {
        return imageProduit;
    }

    public void setImageProduit(String imageProduit) {
        this.imageProduit = imageProduit;
    }

    public float getPrixActuel() {
        return prixActuel;
    }

    public void setPrixActuel(float prixActuel) {
        this.prixActuel = prixActuel;
    }

    public float getPrixRreduction() {
        return prixRreduction;
    }

    public void setPrixRreduction(float prixRreduction) {
        this.prixRreduction = prixRreduction;
    }

    public int getQuantite() {
        return quantite;
    }

    public void setQuantite(int quantite) {
        this.quantite = quantite;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Date getDateExpiration() {
        return dateExpiration;
    }

    public void setDateExpiration(Date dateExpiration) {
        this.dateExpiration = dateExpiration;
    }

    public Categorie getCategorie() {
        return categorie;
    }

    public void setCategorie(Categorie categorie) {
        this.categorie = categorie;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    @Override
    public String toString() {
        return "Produit{" +
                "idProduit=" + idProduit +
                ", nomProduit='" + nomProduit + '\'' +
                ", imageProduit='" + imageProduit + '\'' +
                ", prixActuel=" + prixActuel +
                ", prixRreduction=" + prixRreduction +
                ", quantite=" + quantite +
                ", description='" + description + '\'' +
                ", dateExpiration=" + dateExpiration +
                ", categorie=" + categorie +
                ", user=" + user +
                '}';
    }
}
