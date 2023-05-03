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
    private int idPanier;
    @Temporal(TemporalType.DATE)
    @Column(name="created_At",nullable = true)
    private Date createdAt;

    @ManyToOne(cascade=CascadeType.ALL)
    @JoinColumn(name = "id_produit")
    private Produit produit;
    @ManyToOne(cascade=CascadeType.ALL)
    @JoinColumn(name = "id_user")
    private User user;

    public Panier() {
    }


}
