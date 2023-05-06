package rocketcloud.pidevbackend.controllers;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import rocketcloud.pidevbackend.entities.Categorie;
import rocketcloud.pidevbackend.entities.Produit;
import rocketcloud.pidevbackend.entities.Vendeur;
import rocketcloud.pidevbackend.repositories.CategorieRepository;
import rocketcloud.pidevbackend.repositories.ProduitRepository;
import rocketcloud.pidevbackend.repositories.VendeurRepository;
import rocketcloud.pidevbackend.services.interfaces.ICategorieServiceImp;
import rocketcloud.pidevbackend.services.interfaces.IProduitServiceImp;
import rocketcloud.pidevbackend.services.Interfaces.IVendeurServiceImp;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/produit")
public class ProduitController {
    @Autowired
    private ICategorieServiceImp iCategorieServiceImp;
    @Autowired
    private IProduitServiceImp iProduitServiceImp;
    @Autowired
    private IVendeurServiceImp iVendeurServiceImp;
    @Autowired
    private CategorieRepository categorieRepository;
    @Autowired
    private VendeurRepository vendeurRepository;
    @Autowired
    private ProduitRepository produitRepository;
    //ajouter Produit
    @PostMapping("/add-produit")

    public Produit addProduit(@RequestParam("file") MultipartFile file, @ModelAttribute Produit produit, @RequestParam("nomProduit") String nomProduit,
                              @RequestParam("prixActuel") float prixActuel,
                              @RequestParam("prixRreduction") float prixRreduction,
                              @RequestParam("quantite") int quantite,
                              @RequestParam("description") String description,
                              @RequestParam("dateExpiration") String dateExpiration,
                              @RequestParam("idCategorie") int idCategorie,
                              @RequestParam("idVendeur") int idVendeur ) throws IOException {
        String fileName = StringUtils.cleanPath(file.getOriginalFilename());
        String uploadDir = "produit-images/";
        String filePath = uploadDir + fileName;
        ProduitController.FileUploadUtil.saveFile(uploadDir, fileName, file);
        Produit Produit = new Produit();
        Produit.setImageProduit(filePath);
        Produit.setNomProduit(nomProduit);
        Produit.setPrixActuel(prixActuel);
        Produit.setPrixRreduction(prixRreduction);
        Produit.setQuantite(quantite);
        Produit.setDescription(description);
        Produit.setDateExpiration(dateExpiration);
        Categorie categorie = categorieRepository.findById(idCategorie).orElse(null);
        Produit.setCategorie(categorie);
        Vendeur vendeur = vendeurRepository.findById(idVendeur).orElse(null);
        Produit.setVendeur(vendeur);

        return iProduitServiceImp.addProduit(Produit);
    }
    //GetproduitBycategorie
    @GetMapping("/byCategorie/{idCategorie}")
    public List<Produit> getProduitsByCategorie(@PathVariable int idCategorie) {
        Categorie categorie = categorieRepository.getCategorieByIdCategorie(idCategorie);
        return iProduitServiceImp.getProduitsByCategorie(categorie);
    }
    @GetMapping("/byVendeur/{idVendeur}")
    public List<Produit> getProduitsByVendeur(@PathVariable int idVendeur) {
        Vendeur vendeur = vendeurRepository.getCategorieByIdVendeur(idVendeur);
        return iProduitServiceImp.getProduitsByVendeur(vendeur);
    }


    private String saveImage(MultipartFile image) throws IOException {
        String fileName = StringUtils.cleanPath(image.getOriginalFilename());
        String uploadDir = "produit-images/";
        String filePath = uploadDir + fileName;
        CategorieController.FileUploadUtil.saveFile(uploadDir, fileName, image);
        return filePath;
    }
    @GetMapping("/countByCategorie")
    public ResponseEntity<?> countProduitsByCategorie() {
        List<Object[]> result = produitRepository.countProduitsByCategorie();
        List<Map<String, Object>> resultList = new ArrayList<>();

        for (Object[] row : result) {
            Map<String, Object> map = new HashMap<>();
            map.put("idCategorie", row[0]);
            map.put("nomCategorie", row[1]);
            map.put("count", row[2]);
            resultList.add(map);
        }

        return ResponseEntity.ok().body(resultList);
    }
    @GetMapping("/countByVendeur")
    public ResponseEntity<?> countProduitsByVendeur() {
        List<Object[]> result = produitRepository.countProduitsByVendeur();
        List<Map<String, Object>> resultList = new ArrayList<>();

        for (Object[] row : result) {
            Map<String, Object> map = new HashMap<>();
            map.put("idVendeur", row[0]);
            map.put("nomvendeur", row[1]);
            map.put("count", row[2]);
            resultList.add(map);
        }

        return ResponseEntity.ok().body(resultList);
    }
    @PutMapping("/update-Produit/{idProduit}")
    public ResponseEntity<Produit> updateProduit(
            @PathVariable(value = "idProduit") int idProduit,
            @RequestParam(value = "nomProduit") String nomProduit,
            @RequestParam(value = "imageProduit", required = false) MultipartFile imageProduit,
            @RequestParam(value = "prixActuel") float prixActuel,
            @RequestParam(value = "prixRreduction") float prixRreduction,
            @RequestParam(value = "quantite") int quantite,
            @RequestParam(value = "description") String description,
            @RequestParam(value = "dateExpiration") String dateExpiration,
            @RequestParam(value = "idCategorie") int idCategorie,
            @RequestParam(value = "idVendeur") int idVendeur) throws IOException {

        Produit produit = iProduitServiceImp.getProduitById(idProduit);

        produit.setNomProduit(nomProduit);
        produit.setPrixActuel(prixActuel);
        produit.setPrixRreduction(prixRreduction);
        produit.setQuantite(quantite);
        produit.setDescription(description);
        produit.setDateExpiration(dateExpiration);

        if (imageProduit != null) {
            // Si une nouvelle image a été envoyée, on la sauvegarde et on met à jour l'URL de l'image du produit
            String imageUrll = saveImage(imageProduit);
            produit.setImageProduit(imageUrll);
        }

        Categorie categorie = iCategorieServiceImp.getCategorieById(idCategorie);
        produit.setCategorie(categorie);

        Vendeur vendeur = iVendeurServiceImp.getVendeurById(idVendeur);
        produit.setVendeur(vendeur);

        final Produit updatedProduit = iProduitServiceImp.addProduit(produit);
        return ResponseEntity.ok(updatedProduit);
    }


    //supprimer Produit
    @DeleteMapping("/{idProduit}")
    @ResponseBody
    public void removeProduit(@PathVariable("idProduit") int idProduit) {
        Produit produit = new Produit();
        produit.setIdProduit(idProduit);
        iProduitServiceImp.deleteProduit(produit);
    }
    // afficher tous les Produits
    @GetMapping("/retrieve-all-Produits")
    @ResponseBody
    public List<Produit> getAllProduits() {
        List<Produit> listProduits = iProduitServiceImp.retrieveAllProduits();
        return listProduits;
    }
    @PostMapping("/{idProduit}/like")
    public ResponseEntity<?> likeProduit(@PathVariable("idProduit") int idProduit) {
        Produit produit = iProduitServiceImp.getProduitById(idProduit);
        if (produit == null) {
            return ResponseEntity.notFound().build();
        }
        produit.incrementLikes();
        produitRepository.save(produit);
        return ResponseEntity.ok().build();
    }

    @PostMapping("/{idProduit}/unlike")
    public ResponseEntity<?> unlikeProduit(@PathVariable("idProduit") int idProduit) {
        Produit produit = iProduitServiceImp.getProduitById(idProduit);
        if (produit == null) {
            return ResponseEntity.notFound().build();
        }
        produit.incrementUnlikes();
        produitRepository.save(produit);
        return ResponseEntity.ok().build();
    }


    //afficher un seul Produit
    @GetMapping("/retrieve-produit/{idProduit}")
    @ResponseBody
    public Produit retrieveProduit(@PathVariable("idProduit") int idProduit) {
        return iProduitServiceImp.getProduit(idProduit);
    }
    @GetMapping("/produitImage/{idProduit}")
    public ResponseEntity<byte[]> getImage(@PathVariable int idProduit) throws IOException {
        Produit produit = produitRepository.findById(idProduit).orElse(null);
        if (produit == null || produit.getImageProduit() == null) {
            return ResponseEntity.notFound().build();
        }
        String imagePath = produit.getImageProduit();
        Path imageFile = Paths.get(imagePath);
        if (!imageFile.toAbsolutePath().startsWith(Paths.get("produit-images").toAbsolutePath())) {
            return ResponseEntity.badRequest().build();
        }
        byte[] imageBytes = Files.readAllBytes(imageFile);
        return ResponseEntity.ok().contentType(MediaType.IMAGE_PNG).body(imageBytes);
    }


    //imaaaaaaaaaaaage
    private static class FileUploadUtil {

        public static void saveFile(String uploadDir, String fileName,
                                    MultipartFile multipartFile) throws IOException {
            Path uploadPath = Paths.get(uploadDir);

            if (!Files.exists(uploadPath)) {
                Files.createDirectories(uploadPath);
            }

            try {
                Path filePath = uploadPath.resolve(fileName);
                multipartFile.transferTo(filePath);
            } catch (IOException e) {
                throw new IOException("Could not save file: " + fileName, e);
            }
        }
    }


}
