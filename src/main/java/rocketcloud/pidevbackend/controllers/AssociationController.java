package rocketcloud.pidevbackend.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import rocketcloud.pidevbackend.entities.Association;
import rocketcloud.pidevbackend.services.AssociationService;


import java.util.List;

@RestController
@RequestMapping("/Association")
public class AssociationController {
    @Autowired
    private AssociationService associationService;
    @PostMapping("/add")
    public Association Create_Association(@RequestBody Association association) {
        return associationService.Create_Association(association);
    }
    @GetMapping("/getAll")
    public List<Association> Get_Associations(){
        return associationService.Get_Association();
    }
    @GetMapping("/get/{id}")
    public Association Get_Association_By_Id(@PathVariable("id") Integer id) {
        return associationService.Get_Association(id);
    }
    @DeleteMapping("/delete/{id}")
    public void Delete_Association(@PathVariable("id") Integer id ) {
        associationService.Delete_Association(id);
    }
    @PostMapping("/modifierPiste")
    public void updateAssociation(@RequestBody Association association)
    {
        associationService.Update_Association(association);
    }
    @PostMapping ("/modifierassociation")

    public void modifierAssociation(@RequestBody Association A) {
        associationService.modifierAssociation(A);
    }
}