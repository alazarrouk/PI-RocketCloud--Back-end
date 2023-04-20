package rocketcloud.pidevbackend.controllers;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import rocketcloud.pidevbackend.entities.Categorie;
import rocketcloud.pidevbackend.repositories.CategorieRepository;
import rocketcloud.pidevbackend.services.Interfaces.ICategorieServiceImp;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

@RestController
@RequestMapping("/categorie")
public class CategorieController {
    @Autowired
    private ICategorieServiceImp iCategorieServiceImp;
    @Autowired
    private CategorieRepository categorieRepository;
   //ajouter categorie
    //@PostMapping("/add-Categorie")
    //public Categorie addCategorie(@RequestBody Categorie categorie) {
      //  return iCategorieServiceImp.addCategorie(categorie);
    //}
   @PostMapping("/add-Categorie")
   public Categorie addCategorie(@RequestParam("file") MultipartFile file, @RequestParam("nomCategorie") String nomCategorie) throws IOException {
       String fileName = StringUtils.cleanPath(file.getOriginalFilename());
       String uploadDir = "categorie-images/";
       String filePath = uploadDir + fileName;
       FileUploadUtil.saveFile(uploadDir, fileName, file);
       Categorie categorie = new Categorie();
       categorie.setNomCategorie(nomCategorie);
       categorie.setImageUrl(filePath);
       return iCategorieServiceImp.addCategorie(categorie);
   }
    @GetMapping("/categories/{idCategorie}")
    public ResponseEntity<Categorie> getCategorie(@PathVariable int idCategorie) throws IOException {
        Categorie categorie = categorieRepository.findById(idCategorie).orElse(null);
        if (categorie == null) {
            return ResponseEntity.notFound().build();
        }
        String imageUrl =  categorie.getImageUrl(); // chemin vers l'image
        Categorie categorieDto = new Categorie(categorie.getIdCategorie(), categorie.getNomCategorie(), imageUrl);
        return ResponseEntity.ok().body(categorieDto);
    }

    private String saveImage(MultipartFile image) throws IOException {
        String fileName = StringUtils.cleanPath(image.getOriginalFilename());
        String uploadDir = "categorie-images/";
        String filePath = uploadDir + fileName;
        FileUploadUtil.saveFile(uploadDir, fileName, image);
        return filePath;
    }
    @GetMapping("/categorieImage/{idCategorie}")
    public ResponseEntity<byte[]> getImage(@PathVariable int idCategorie) throws IOException {
        Categorie categorie = categorieRepository.findById(idCategorie).orElse(null);
        if (categorie == null || categorie.getImageUrl() == null) {
            return ResponseEntity.notFound().build();
        }
        String imagePath = categorie.getImageUrl();
        Path imageFile = Paths.get(imagePath);
        if (!imageFile.toAbsolutePath().startsWith(Paths.get("categorie-images").toAbsolutePath())) {
            return ResponseEntity.badRequest().build();
        }
        byte[] imageBytes = Files.readAllBytes(imageFile);
        return ResponseEntity.ok().contentType(MediaType.IMAGE_PNG).body(imageBytes);
    }

    @PutMapping("/categories/{idCategorie}")
    public ResponseEntity<Categorie> updateCategorie(@PathVariable(value = "idCategorie") int idCategorie,
                                                     @RequestParam(value = "nomCategorie") String nomCategorie,
                                                     @RequestParam(value = "imageUrl", required = false) MultipartFile imageUrl) throws IOException {
        Categorie categorie = iCategorieServiceImp.getCategorieById(idCategorie);

        categorie.setNomCategorie(nomCategorie);
        if (imageUrl != null) {
            // Si une nouvelle image a été envoyée, on la sauvegarde et on met à jour l'URL de l'image de la catégorie
            String imageUrll = saveImage(imageUrl);
            categorie.setImageUrl(imageUrll);
        }

        final Categorie updatedCategorie = iCategorieServiceImp.addCategorie(categorie);
        return ResponseEntity.ok(updatedCategorie);
    }





    //modifier categorie
   /* @PutMapping("/update-Categorie")
    public Categorie updateCategorie(@RequestBody Categorie categorie) {
        return iCategorieServiceImp.addCategorie(categorie);
    }*/
    /*@PutMapping("/update-Categorie")
    public Categorie updateCategorie(@RequestParam(name = "imageFile", required = false) MultipartFile imageFile,
                                     @RequestParam(name = "nomCategorie") String nomCategorie,
                                     @RequestParam(name = "idCategorie") int idCategorie) throws IOException {
        Categorie categorie = iCategorieServiceImp.getCategorieById(idCategorie);
        categorie.setNomCategorie(nomCategorie);
        if (imageFile != null) {
            String fileName = StringUtils.cleanPath(imageFile.getOriginalFilename());
            String uploadDir = "categorie-images/";
            String filePath = uploadDir + fileName;
            FileUploadUtil.saveFile(uploadDir, fileName, imageFile);
            categorie.setImageUrl(filePath);
        }
        return iCategorieServiceImp.addCategorie(categorie);
    }*/

    //supprimer categorie
    @DeleteMapping("/{idCategorie}")
    @ResponseBody
    public void removeCategorie(@PathVariable("idCategorie") int idCategorie) {
        Categorie categorie = new Categorie();
        categorie.setIdCategorie(idCategorie);
        iCategorieServiceImp.deleteCategorie(categorie);
    }
    // afficher toutes les categories
    @GetMapping("/retrieve-all-categories")
    @ResponseBody
    public List<Categorie> getAllCategories() {
        List<Categorie> listCategories = iCategorieServiceImp.retrieveAllCategories();
        return listCategories;
    }
    //afficher une seule categorie
    @GetMapping("/retrieve-categorie/{idCategorie}")
    @ResponseBody
    public Categorie retrieveCategorie(@PathVariable("idCategorie") int idCategorie) {
        return iCategorieServiceImp.getCategorie(idCategorie);
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
