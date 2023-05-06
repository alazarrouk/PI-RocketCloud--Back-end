package rocketcloud.pidevbackend.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import rocketcloud.pidevbackend.entities.Panier;
import rocketcloud.pidevbackend.entities.Produit;
import rocketcloud.pidevbackend.entities.User;
import rocketcloud.pidevbackend.repositories.PanierRepository;
import rocketcloud.pidevbackend.repositories.ProduitRepository;
import rocketcloud.pidevbackend.repositories.UserRepository;
import rocketcloud.pidevbackend.repositories.VendeurRepository;
import rocketcloud.pidevbackend.services.Interfaces.IPanierServiceImp;
import rocketcloud.pidevbackend.services.Interfaces.IVendeurServiceImp;


import java.util.Date;

import rocketcloud.pidevbackend.repositories.ProduitRepository;
import rocketcloud.pidevbackend.repositories.UserRepository;
import rocketcloud.pidevbackend.services.interfaces.IPanierServiceImp;


import java.util.List;
import java.util.Map;
import java.util.Optional;

@RestController
@RequestMapping("/panier")
public class PanierController {
    @Autowired

    private IPanierServiceImp iPanierServiceImp;
    @Autowired
    private PanierRepository panierRepository;
    @Autowired
    private ProduitRepository produitRepository;
    @Autowired
    private UserRepository userRepository;
    @GetMapping("/allPaniers")
    public List<Panier> getAllPaniers() {
        return iPanierServiceImp.getAllPaniers();
    }

    @GetMapping("/getPanier/{idPanier}")
    public Panier getPanierById(@PathVariable int idPanier) {
        return iPanierServiceImp.getPanierById(idPanier);
    }

  /*  @PostMapping("/addPanier")
    public void addPanier(@RequestBody Panier panier) {
        iPanierServiceImp.addPanier(panier);
    }*/
  @PostMapping("/addPanier")
  public ResponseEntity<Panier> ajouterProduitAuPanier(@RequestBody Map<String, Object> body) {
      Integer idProduit = (Integer) body.get("idProduit");
      Integer id = (Integer) body.get("id");
      Integer quantite = (Integer) body.get("quantite"); // nouveau paramètre quantite
      Optional<Produit> optionalProduit = produitRepository.findById(idProduit);
      Optional<User> optionalUser = userRepository.findById(id.longValue());

      if (optionalProduit.isPresent() && optionalUser.isPresent()) {
          Produit produit = optionalProduit.get();
          User user = optionalUser.get();

          if (produit.getQuantite() > 0) { // Vérifier si la quantité est supérieure à 0 avant de la décrémenter
              produit.setQuantite(produit.getQuantite() - quantite); // décrémenter la quantité disponible
              produitRepository.save(produit);

              Panier panier = new Panier(produit, user);
              panier.setQuantite(quantite);
              panier.setCreatedAt(new Date());

              panierRepository.save(panier);

              return new ResponseEntity<>(panier, HttpStatus.CREATED);
          } else {
              return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
          }
      } else {
          return new ResponseEntity<>(HttpStatus.NOT_FOUND);
      }
  }
  //recuperer liste des produits du panier d'un user specifique
  @GetMapping("/{id}/produits")
  public ResponseEntity<List<Produit>> getProduitsByUserId(@PathVariable("id") Long id) {
      List<Produit> produits = iPanierServiceImp.findProduitsByUserId(id);
      if (produits.isEmpty()) {
          return new ResponseEntity<>(HttpStatus.NO_CONTENT);
      }
      return new ResponseEntity<>(produits, HttpStatus.OK);
  }

    @Transactional
    @DeleteMapping("/{id}/panier/{idProduit}")
    public ResponseEntity<Void> deletePanier(@PathVariable Long id, @PathVariable Integer idProduit) {
        Optional<Panier> optionalPanier = panierRepository.findByUserIdAndProduitId(id, idProduit);

        if (optionalPanier.isPresent()) {
            Panier panier = optionalPanier.get();
            Produit produit = panier.getProduit();
            produit.setQuantite(produit.getQuantite() + panier.getQuantite());
            produitRepository.save(produit);
            iPanierServiceImp.deletePanierByUserIdAndProduitId(id, idProduit);

            // Incrémente la quantité du produit
            // Met à jour la quantité du produit dans la base de données

            return ResponseEntity.noContent().build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @GetMapping("/paniers/user/{id}")
    public List<Panier> getPaniersByUserId(@PathVariable Long id) {
        return panierRepository.findByUserId(id);
    }



}
