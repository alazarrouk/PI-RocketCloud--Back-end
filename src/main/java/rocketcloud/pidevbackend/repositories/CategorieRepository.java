package rocketcloud.pidevbackend.repositories;


import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import rocketcloud.pidevbackend.entities.Categorie;

@Repository
public interface CategorieRepository extends CrudRepository<Categorie, Integer> {
    //public interface CategorieRepository extends JpaRepository<Categorie, Integer>
    Categorie getCategorieByIdCategorie(int idCategorie);

}
