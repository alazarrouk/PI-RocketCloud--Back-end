package rocketcloud.pidevbackend.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import rocketcloud.pidevbackend.entities.Don;
import rocketcloud.pidevbackend.services.DonService;

import java.util.List;

@RestController
@RequestMapping("/don")
public class DonController {
    @Autowired
    private DonService donService;
    @PostMapping("/add")
    public Don Create_Don(@RequestBody Don don) {
        return donService.Create_Don(don);
    }
    @GetMapping("/getAll")
    public List<Don> Get_Dons(){
        return donService.Get_Dons();
    }
    @GetMapping("/get/{id}")
    public Don Get_Don_By_Id(@PathVariable("id") Integer id) {
        return donService.Get_Don(id);
    }
    @DeleteMapping("/delete/{id}")
    public void Delete_Don(@PathVariable("id") Integer id ) {
        donService.Delete_Don(id);
    }
    @PostMapping("/modifierdon")
    public void updatePiste(@RequestBody Don don)
    {
        donService.Update_Don(don);

    }

}
