package rocketcloud.pidevbackend.entities;

import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Set;

@Data
@Entity
@Table(name = "Associations")
public class Association implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id_association")
    private int id_association;
    @Column(name="nom")
    private String nom;
    @Column(nullable = true)
    @OneToMany(cascade = CascadeType.MERGE) //bidirectionnelle
    private Set<Don> dons;

    public Association() {
    }

    public Association(int id_association, String nom, Set<Don> dons) {
        this.id_association = id_association;
        this.nom = nom;
        this.dons = dons;
    }

    public int getId_association() {
        return id_association;
    }

    public void setId_association(int id_association) {
        this.id_association = id_association;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public Set<Don> getDons() {
        return dons;
    }

    public void setDons(Set<Don> dons) {
        this.dons = dons;
    }

    @Override
    public String toString() {
        return "Association{" +
                "id_association=" + id_association +
                ", nom='" + nom + '\'' +
                ", dons=" + dons +
                '}';
    }
}