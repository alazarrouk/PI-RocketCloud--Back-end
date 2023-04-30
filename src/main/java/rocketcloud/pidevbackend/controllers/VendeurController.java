package rocketcloud.pidevbackend.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import rocketcloud.pidevbackend.entities.Vendeur;
import rocketcloud.pidevbackend.repositories.VendeurRepository;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

@RestController
@RequestMapping("/vendeur")
public class VendeurController {
    @Autowired
    private rocketcloud.pidevbackend.services.Interfaces.IVendeurServiceImp iVendeurServiceImp;
    @Autowired
    private VendeurRepository vendeurRepository;

    @PostMapping("/add-vendeur")

    public Vendeur addVendeur(@RequestParam("file") MultipartFile file, @ModelAttribute Vendeur vendeur, @RequestParam("nomVendeur") String nomVendeur,
                              @RequestParam("emailVendeur") String emailVendeur,
                              @RequestParam("numeroVendeur") String numeroVendeur,
                              @RequestParam("adresseVendeur") String adresseVendeur) throws IOException {
        String fileName = StringUtils.cleanPath(file.getOriginalFilename());
        String uploadDir = "vendeurs-images/";
        String filePath = uploadDir + fileName;
        VendeurController.FileUploadUtil.saveFile(uploadDir, fileName, file);
        Vendeur Vendeur = new Vendeur();
        Vendeur.setLogoVendeur(filePath);
        Vendeur.setNomVendeur(nomVendeur);
        Vendeur.setEmailVendeur(emailVendeur);
        Vendeur.setNumeroVendeur(numeroVendeur);
        Vendeur.setAdresseVendeur(adresseVendeur);
        return iVendeurServiceImp.addVendeur(Vendeur);
    }

    @PutMapping("/update-Vendeur/{idVendeur}")
    public Vendeur updateVendeur(@PathVariable(value = "idVendeur") int idVendeur,@RequestBody Vendeur vendeur) {
        return iVendeurServiceImp.updateVendeur(idVendeur,vendeur);
    }
    private String saveImage(MultipartFile image) throws IOException {
        String fileName = StringUtils.cleanPath(image.getOriginalFilename());
        String uploadDir = "vendeurs-images/";
        String filePath = uploadDir + fileName;
        CategorieController.FileUploadUtil.saveFile(uploadDir, fileName, image);
        return filePath;
    }
    @PutMapping("/updateVendeurs/{idVendeur}")
    public ResponseEntity<Vendeur> updateCategorie(@PathVariable(value = "idVendeur") int idVendeur,
                                                   @RequestParam(value = "nomVendeur") String nomVendeur,
                                                   @RequestParam(value = "emailVendeur") String emailVendeur,
                                                   @RequestParam(value = "numeroVendeur") String numeroVendeur,
                                                   @RequestParam(value = "logoVendeur", required = false) MultipartFile logoVendeur, @RequestParam(value = "adresseVendeur") String adresseVendeur) throws IOException {
        Vendeur vendeur = iVendeurServiceImp.getVendeurById(idVendeur);
        vendeur.setNomVendeur(nomVendeur);
        vendeur.setEmailVendeur(emailVendeur);
        vendeur.setNumeroVendeur(numeroVendeur);
        vendeur.setAdresseVendeur(adresseVendeur);

        if (logoVendeur != null) {
            // Si une nouvelle image a été envoyée, on la sauvegarde et on met à jour l'URL de l'image de la catégorie
            String imageUrll = saveImage(logoVendeur);
            vendeur.setLogoVendeur(imageUrll);
        }

        final Vendeur updatedVendeur = iVendeurServiceImp.addVendeur(vendeur);
        return ResponseEntity.ok(updatedVendeur);
    }

    @DeleteMapping("/{idVendeur}")
    @ResponseBody
    public void removeVendeur(@PathVariable("idVendeur") int idVendeur) {
        Vendeur vendeur = new Vendeur();
        vendeur.setIdVendeur(idVendeur);
        iVendeurServiceImp.deleteVendeur(vendeur);
    }

    @GetMapping("/retrieve-all-Vendeurs")
    @ResponseBody
    public List<Vendeur> getAllVendeurs() {
        List<Vendeur> listVendeurs = iVendeurServiceImp.retrieveAllVendeurs();
        return listVendeurs;
    }

    @GetMapping("/retrieve-vendeur/{idVendeur}")
    @ResponseBody
    public Vendeur retrieveVendeur(@PathVariable("idVendeur") int idVendeur) {
        return iVendeurServiceImp.getVendeur(idVendeur);
    }
    @GetMapping("/vendeurImage/{idVendeur}")
    public ResponseEntity<byte[]> getImage(@PathVariable int idVendeur) throws IOException {
        Vendeur vendeur = vendeurRepository.findById(idVendeur).orElse(null);
        if (vendeur == null || vendeur.getLogoVendeur() == null) {
            return ResponseEntity.notFound().build();
        }
        String imagePath = vendeur.getLogoVendeur();
        Path imageFile = Paths.get(imagePath);
        if (!imageFile.toAbsolutePath().startsWith(Paths.get("vendeurs-images").toAbsolutePath())) {
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

