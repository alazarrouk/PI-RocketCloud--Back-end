package rocketcloud.pidevbackend.entities;


import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import javax.persistence.*;
import lombok.Data;

import java.io.Serializable;
import java.util.List;

@Data
@Entity
@Table(name = "Categories")
public class Categorie implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_categorie")
    private int idCategorie;
    @Column(name = "nom_categorie")
    private String nomCategorie;
    @Column(name = "image_url")
    private String imageUrl;
    @OneToMany(cascade = CascadeType.ALL)
    @JsonIgnore
    @JoinColumn(name = "id_produit")
    private List<Produit> produits;

    public Categorie() {
    }

    public Categorie(int idCategorie, String nomCategorie, String imageUrl, List<Produit> produits) {
        this.idCategorie = idCategorie;
        this.nomCategorie = nomCategorie;
        this.imageUrl = imageUrl;
        this.produits = produits;
    }

    public int getIdCategorie() {
        return idCategorie;
    }

    public void setIdCategorie(int idCategorie) {
        this.idCategorie = idCategorie;
    }

    public String getNomCategorie() {
        return nomCategorie;
    }

    public void setNomCategorie(String nomCategorie) {
        this.nomCategorie = nomCategorie;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    public List<Produit> getProduits() {
        return produits;
    }

    public void setProduits(List<Produit> produits) {
        this.produits = produits;
    }

    @Override
    public String toString() {
        return "Categorie{" +
                "idCategorie=" + idCategorie +
                ", nomCategorie='" + nomCategorie + '\'' +
                ", imageUrl='" + imageUrl + '\'' +
                ", produits=" + produits +
                '}';
    }
}
