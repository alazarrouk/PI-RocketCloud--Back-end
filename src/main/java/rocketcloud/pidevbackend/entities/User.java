package rocketcloud.pidevbackend.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;


import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(	name = "users",uniqueConstraints = {
        @UniqueConstraint(columnNames = "email")
})
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank
    @Size(max = 20)
    private String username;

    public String getFullname() {
        return fullname;
    }

    public void setFullname(String fullname) {
        fullname = fullname;
    }

    @Size(max = 20)
    private String fullname;
    @Size(max = 20)
    private String adresse;
    @NotBlank
    @Size(max = 50)
    @Email
    private String email;

    @NotBlank
    @Size(max = 120)
    private String password;
    private String verificationCode;
    boolean verified=false;
    private String resetpasswordcode;

    public String getResetpasswordcode() {
        return resetpasswordcode;
    }



    public String getAdresse() {
        return adresse;
    }

    public void setAdresse(String adresse) {
        adresse = adresse;
    }

    public void setResetpasswordcode(String resetpasswordcode) {
        this.resetpasswordcode = resetpasswordcode;
    }

    public boolean isVerified() {
        return verified;
    }

    public void setVerified(boolean verified) {
        this.verified = verified;
    }
    public User() {
    }

    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(	name = "user_roles",
            joinColumns = @JoinColumn(name = "user_id"),
            inverseJoinColumns = @JoinColumn(name = "role_id"))
    private Set<Role> roles = new HashSet<>();

    @JsonIgnore
    @Column(nullable = true)
    @OneToMany(cascade = CascadeType.ALL) //unidirictionnelle
    private Set<Produit> produits;

    //client
    @JsonIgnore
    @Column(nullable = true)
    @OneToMany(cascade = CascadeType.ALL,mappedBy="user") //Bidirictionnelle
    private Set<Commande> commandes;

    //client
    @JsonIgnore
    @Column(nullable = true)
    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL) //Bidirictionnelle
    private Set<Reservation> reservations;

    //client
    @Column(nullable = true)
    @OneToMany(cascade = CascadeType.ALL) //Bidirictionnelle
    private Set<Reclamation> reclamations;

    //client
    @JsonIgnore
    @Column(nullable = true)
    @OneToMany(cascade = CascadeType.ALL) //Bidirictionnelle
    private Set<Don> dons;

    //client
    @JsonIgnore
    @Column(nullable = true)
    @ManyToMany(cascade = CascadeType.ALL) //unidirictionnelle
    private Set<Recette> recettes;
   public User() {
    }

    public User(String username, String email, String password,String adresse,String fullname) {
        this.username = username;
        this.email = email;
        this.password = password;

        this.fullname =fullname;
        this.adresse=adresse;
    }
    public Long getId() {
        return id;
    }

    public String getVerificationCode() {
        return verificationCode;
    }

    public void setVerificationCode(String verificationCode) {
        this.verificationCode = verificationCode;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Set<Role> getRoles() {
        return roles;
    }

    public void setRoles(Set<Role> roles) {
        this.roles = roles;
    }



    public Set<Produit> getProduits() {
        return produits;
    }

    public void setProduits(Set<Produit> produits) {
        this.produits = produits;
    }

    public Set<Commande> getCommandes() {
        return commandes;
    }

    public void setCommandes(Set<Commande> commandes) {
        this.commandes = commandes;
    }

    public Set<Reservation> getReservations() {
        return reservations;
    }

    public void setReservations(Set<Reservation> reservations) {
        this.reservations = reservations;
    }

    public Set<Reclamation> getReclamations() {
        return reclamations;
    }

    public void setReclamations(Set<Reclamation> reclamations) {
        this.reclamations = reclamations;
    }

    public Set<Don> getDons() {
        return dons;
    }

    public void setDons(Set<Don> dons) {
        this.dons = dons;
    }

    public Set<Recette> getRecettes() {
        return recettes;
    }

    public void setRecettes(Set<Recette> recettes) {
        this.recettes = recettes;
    }


}
