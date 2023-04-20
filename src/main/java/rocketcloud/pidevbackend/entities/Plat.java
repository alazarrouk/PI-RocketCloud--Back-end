package rocketcloud.pidevbackend.entities;

import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;

import java.io.Serializable;

@Data
@Entity
@Table(name = "Plats")
public class Plat implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id_plat")
    private int id_plat;
    @Column(name="nom_plat")
    private String nom_plat;
    @Column(name="photo_plat")
    private String photo_plat;
    @Column(name="prix_plat")
    private float prix_plat;
    @Column(name="description_plat")
    private String description_plat;
    @JsonIgnore

    @ManyToOne
    Restaurant restaurant;

    public Plat() {
    }

    public Plat(int id_plat, String nom_plat, String photo_plat, float prix_plat, String description_plat, Restaurant restaurant) {
        this.id_plat = id_plat;
        this.nom_plat = nom_plat;
        this.photo_plat = photo_plat;
        this.prix_plat = prix_plat;
        this.description_plat = description_plat;
        this.restaurant = restaurant;
    }
    public Plat(int id_plat, String nom_plat, String photo_plat, float prix_plat, String description_plat) {
        this.id_plat = id_plat;
        this.nom_plat = nom_plat;
        this.photo_plat = photo_plat;
        this.prix_plat = prix_plat;
        this.description_plat = description_plat;
    }


    public int getId_plat() {
        return id_plat;
    }

    public void setId_plat(int id_plat) {
        this.id_plat = id_plat;
    }

    public String getNom_plat() {
        return nom_plat;
    }

    public void setNom_plat(String nom_plat) {
        this.nom_plat = nom_plat;
    }

    public String getPhoto_plat() {
        return photo_plat;
    }

    public void setPhoto_plat(String photo_plat) {
        this.photo_plat = photo_plat;
    }

    public float getPrix_plat() {
        return prix_plat;
    }

    public void setPrix_plat(float prix_plat) {
        this.prix_plat = prix_plat;
    }

    public String getDescription_plat() {
        return description_plat;
    }

    public void setDescription_plat(String description_plat) {
        this.description_plat = description_plat;
    }

    public Restaurant getRestaurant() {
        return restaurant;
    }

    public void setRestaurant(Restaurant restaurant) {
        this.restaurant = restaurant;
    }

    @Override
    public String toString() {
        return "Plat{" +
                "id_plat=" + id_plat +
                ", nom_plat='" + nom_plat + '\'' +
                ", photo_plat='" + photo_plat + '\'' +
                ", prix_plat=" + prix_plat +
                ", description_plat='" + description_plat + '\'' +
                ", restaurant=" + restaurant +
                '}';
    }
}
