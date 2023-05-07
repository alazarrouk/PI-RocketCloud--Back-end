package rocketcloud.pidevbackend.entities;

import javax.persistence.*;
import lombok.Data;

import java.io.Serializable;
import java.util.Set;

@Data
@Entity
@Table(name = "Recettes")
public class Recette implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id_recette")
    private int id_recette;
    @Column(name="nom")
    private String nom;
    @Column(name="image")
    private String image;
    @Column(name="description")
    private String description;

    @Column (name = "status")
    private String status;

    @ManyToMany(cascade = CascadeType.MERGE)
    private Set<Ingredient> ingredients;

    public Recette() {
    }

    public Recette(int id_recette, String nom, String image, String description, Set<Ingredient> ingredients) {
        this.id_recette = id_recette;
        this.nom = nom;
        this.image = image;
        this.description = description;
        this.ingredients = ingredients;
    }

    public int getId_recette() {
        return id_recette;
    }

    public void setId_recette(int id_recette) {
        this.id_recette = id_recette;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Set<Ingredient> getIngredients() {
        return ingredients;
    }

    public void setIngredients(Set<Ingredient> ingredients) {
        this.ingredients = ingredients;
    }

    @Override
    public String toString() {
        return "Recette{" +
                "id_recette=" + id_recette +
                ", nom='" + nom + '\'' +
                ", image='" + image + '\'' +
                ", description='" + description + '\'' +
                ", ingredients=" + ingredients +
                '}';
    }
}
