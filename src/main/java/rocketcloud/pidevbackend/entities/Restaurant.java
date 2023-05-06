package rocketcloud.pidevbackend.entities;

import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;

import java.io.Serializable;
import java.util.Set;

@Data
@Entity
@Table(name = "Restaurants")

public class Restaurant  implements Serializable  {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id_restaurant")
    private int id_restaurant;
    @Column(name="nom_restaurant")
    private String nom_restaurant;

    @Column(name="localisation_restaurant")
    private String localisation_restaurant;
    @Column(name="photo_restaurant")
    private String photo_restaurant;
    @Column(name="tel_restaurant")
    private int tel_restaurant;

    @Column(nullable = true)
    @OneToMany(cascade = CascadeType.ALL,mappedBy = "restaurant") //bidirectionnelle
    private Set<Plat> plats;
    @Column(nullable = true)
    @OneToMany(mappedBy = "restaurant", cascade = CascadeType.ALL)
    private Set<Reservation> reservations;

    public Restaurant() {
    }

    public Restaurant(int id_restaurant, String nom_restaurant, String localisation_restaurant, String photo_restaurant, int tel_restaurant, Set<Plat> plats, Set<Reservation> reservations) {
        this.id_restaurant = id_restaurant;
        this.nom_restaurant = nom_restaurant;
        this.localisation_restaurant = localisation_restaurant;
        this.photo_restaurant = photo_restaurant;
        this.tel_restaurant = tel_restaurant;
        this.plats = plats;
        this.reservations = reservations;
    }

    public int getId_restaurant() {
        return id_restaurant;
    }

    public void setId_restaurant(int id_restaurant) {
        this.id_restaurant = id_restaurant;
    }

    public String getNom_restaurant() {
        return nom_restaurant;
    }

    public void setNom_restaurant(String nom_restaurant) {
        this.nom_restaurant = nom_restaurant;
    }

    public String getLocalisation_restaurant() {
        return localisation_restaurant;
    }

    public void setLocalisation_restaurant(String localisation_restaurant) {
        this.localisation_restaurant = localisation_restaurant;
    }

    public String getPhoto_restaurant() {
        return photo_restaurant;
    }

    public void setPhoto_restaurant(String photo_restaurant) {
        this.photo_restaurant = photo_restaurant;
    }

    public int getTel_restaurant() {
        return tel_restaurant;
    }

    public void setTel_restaurant(int tel_restaurant) {
        this.tel_restaurant = tel_restaurant;
    }

    public Set<Plat> getPlats() {
        return plats;
    }

    public void setPlats(Set<Plat> plats) {
        this.plats = plats;
    }

    public Set<Reservation> getReservations() {
        return reservations;
    }

    public void setReservations(Set<Reservation> reservations) {
        this.reservations = reservations;
    }

    @Override
    public String toString() {
        return "Restaurant{" +
                "id_restaurant=" + id_restaurant +
                ", nom_restaurant='" + nom_restaurant + '\'' +
                ", localisation_restaurant='" + localisation_restaurant + '\'' +
                ", photo_restaurant='" + photo_restaurant + '\'' +
                ", tel_restaurant=" + tel_restaurant +
                ", plats=" + plats +
                ", reservations=" + reservations +
                '}';
    }
}
