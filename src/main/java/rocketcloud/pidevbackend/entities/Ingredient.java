package rocketcloud.pidevbackend.entities;
import javax.persistence.*;
import lombok.Data;

import java.io.Serializable;
import java.util.Set;

@Data
@Entity
@Table(name = "Ingredients")

public class Ingredient implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id_ingredient")
    private int id_ingredient;
    @Column(name="nom")
    private String nom;

}
