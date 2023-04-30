package rocketcloud.pidevbackend.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

@Data
@Entity
@Table(name = "vendeurs")
public class Vendeur implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id_vendeur")
    private int idVendeur;
    @Column(name="nom_vendeur")
    private String nomVendeur;
    @Column(name="email_vendeur")
    private String emailVendeur;
    @Column(name="numero_vendeur")
    private String numeroVendeur;
    @Column(name="logo_vendeur")
    private String logoVendeur;
    @Column(name="adresse_vendeur")
    private String adresseVendeur;

    @OneToMany(cascade=CascadeType.ALL)
    @JsonIgnore
    @JoinColumn(name="id_produit")
    private List<Produit> produits;
}
