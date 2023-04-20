package rocketcloud.pidevbackend.entities;

import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.Date;

@Data
@Entity
@Table(name = "Reservations")

public class Reservation implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id_reservation")
    private int id_reservation;
    @Temporal(TemporalType.DATE)
    @Column(name="date_reservation")
    private Date date_reservation;
    @Column(name="nb_places")
    private int nb_places;
    @JsonIgnore

    @ManyToOne
    private User user;
    @JsonIgnore

    @ManyToOne
    private Restaurant restaurant;

    public Reservation() {
    }

    public Reservation(int id_reservation, Date date_reservation, int nb_places, User user, Restaurant restaurant) {
        this.id_reservation = id_reservation;
        this.date_reservation = date_reservation;
        this.nb_places = nb_places;
        this.user = user;
        this.restaurant = restaurant;
    }
    public Reservation(int id_reservation, Date date_reservation, int nb_places) {
        this.id_reservation = id_reservation;
        this.date_reservation = date_reservation;
        this.nb_places = nb_places;

    }


    public int getId_reservation() {
        return id_reservation;
    }

    public void setId_reservation(int id_reservation) {
        this.id_reservation = id_reservation;
    }

    public Date getDate_reservation() {
        return date_reservation;
    }

    public void setDate_reservation(Date date_reservation) {
        this.date_reservation = date_reservation;
    }

    public int getNb_places() {
        return nb_places;
    }

    public void setNb_places(int nb_places) {
        this.nb_places = nb_places;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Restaurant getRestaurant() {
        return restaurant;
    }

    public void setRestaurant(Restaurant restaurant) {
        this.restaurant = restaurant;
    }

    @Override
    public String toString() {
        return "Reservation{" +
                "id_reservation=" + id_reservation +
                ", date_reservation=" + date_reservation +
                ", nb_places=" + nb_places +
                ", user=" + user +
                ", restaurant=" + restaurant +
                '}';
    }
}
