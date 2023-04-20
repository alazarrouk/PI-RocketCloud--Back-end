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

<<<<<<< Updated upstream

=======
<<<<<<< HEAD

=======
>>>>>>> 70ad24d9801166baf3b68e14b074a1cc24847187
>>>>>>> Stashed changes
}
