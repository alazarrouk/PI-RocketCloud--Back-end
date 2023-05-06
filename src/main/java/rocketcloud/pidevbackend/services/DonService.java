package rocketcloud.pidevbackend.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import rocketcloud.pidevbackend.entities.Don;
import rocketcloud.pidevbackend.repositories.DonRepository;
import rocketcloud.pidevbackend.services.interfaces.IDon;

import java.util.List;
@Service
public class DonService implements IDon {
    @Autowired
    private DonRepository donRepository;

    @Override
    public Don Create_Don(Don don) {
        return donRepository.save(don);
    }

    @Override
    public Don Update_Don(Don don) {
        return donRepository.save(don);
    }

    @Override
    public void Delete_Don(Integer id) {
        donRepository.deleteById(id);

    }

    @Override
    public List<Don> Get_Dons() {
        return (List<Don>) donRepository.findAll();
    }

    @Override
    public Don Get_Don(Integer id) {
        return donRepository.findById(id).get();
    }
}
