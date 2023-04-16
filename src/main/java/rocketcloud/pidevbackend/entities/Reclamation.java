package rocketcloud.pidevbackend.entities;

import javax.persistence.*;
import lombok.Data;

import java.io.Serializable;
import java.util.Date;

@Data
@Entity
@Table(name = "Reclamations")
public class Reclamation implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id_reclamation")
    private int id_reclamation;
    @Column(name="date")
    @Temporal(TemporalType.DATE)
    private Date date;
    @Column(name="description")
    private String description;
    @ManyToOne
    User user;

    public Reclamation() {
    }

    public Reclamation(int id_reclamation, Date date, String description, User user) {
        this.id_reclamation = id_reclamation;
        this.date = date;
        this.description = description;
        this.user = user;
    }

    public int getId_reclamation() {
        return id_reclamation;
    }

    public void setId_reclamation(int id_reclamation) {
        this.id_reclamation = id_reclamation;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    @Override
    public String toString() {
        return "Reclamation{" +
                "id_reclamation=" + id_reclamation +
                ", date=" + date +
                ", description='" + description + '\'' +
                ", user=" + user +
                '}';
    }
}
