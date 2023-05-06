package rocketcloud.pidevbackend.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import rocketcloud.pidevbackend.entities.Paiement;
import rocketcloud.pidevbackend.repositories.PaiementRepository;
import rocketcloud.pidevbackend.services.interfaces.IPaiement;

import java.util.List;

@Service
public class PaiementService implements IPaiement {
    @Autowired
    PaiementRepository paiementRepository;
    @Override
    public Paiement create_paiement(Paiement paiement) {
        return paiementRepository.save(paiement);
    }
    @Override
    public Paiement update_paiement(Paiement paiement) {
        return paiementRepository.save(paiement);
    }

    @Override
    public void delete_paiement(Integer id) {paiementRepository.deleteById(id);}
    @Override
    public List<Paiement> get_paiements() {
        return (List<Paiement>) paiementRepository.findAll();
    }

    @Override
    public Paiement get_paiement(Integer id) {
        return paiementRepository.findById(id).get();
    }

    @Override
    public List<Object[]> get_total_paiement_grouped_by_month() {
        return paiementRepository.get_monthly_montant();
    }

    @Override
    public List<Object[]> getMontantSumByWeek() {
        return paiementRepository.getMontantSumByWeek();
    }

    @Override
    public List<Object[]> getsumMontantByDayOfWeek() {
        return paiementRepository.getsumMontantByDayOfWeek();
    }

}
