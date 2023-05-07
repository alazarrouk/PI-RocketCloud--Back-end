/*
package rocketcloud.pidevbackend.controllers;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import rocketcloud.pidevbackend.entities.Reclamation;
import rocketcloud.pidevbackend.services.ReclamationService;
import java.util.List;

@RestController
@RequestMapping("/Reclamation")
public class ReclamationController {
    @Autowired
    private ReclamationService reclamationService;
    @PostMapping("/add")
    public Reclamation Create_Reclamation(@RequestBody Reclamation reclamation) {
        return reclamationService.Create_Reclamation(reclamation);
    }
    @GetMapping("/getAll")
    public List<Reclamation> Get_Reclamation(){
        return reclamationService.Get_Reclamation();
    }
    @GetMapping("/get/{id}")
    public Reclamation Get_Reclamation_By_Id(@PathVariable("id") Integer id) {
        return reclamationService.Get_Reclamation(id);
    }
    @DeleteMapping("/delete/{id}")
    public void Delete_Reclamation(@PathVariable("id") Integer id ) {
        reclamationService.Delete_Reclamation(id);
    }
    @PostMapping("/modifierPiste")
    public void updateReclamation(@RequestBody Reclamation reclamation)
    {
        reclamationService.Update_Reclamation(reclamation);

    }

}
*/
