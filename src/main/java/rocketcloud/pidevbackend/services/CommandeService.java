package rocketcloud.pidevbackend.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import rocketcloud.pidevbackend.entities.Commande;
import rocketcloud.pidevbackend.entities.User;
import rocketcloud.pidevbackend.repositories.CommandeRepository;
import rocketcloud.pidevbackend.services.interfaces.ICommande;

import java.util.Date;
import java.util.List;

@Service
public class CommandeService implements ICommande {

    @Autowired
    private CommandeRepository commandeRepository;
    @Override
    public Commande create_commande(Commande commande) {
        return commandeRepository.save(commande);
    }
    @Override
    public Commande update_commande(Commande commande) {
        return commandeRepository.save(commande);
    }
    @Override
    public void delete_commande(Integer id) {
        commandeRepository.deleteById(id);
    }
    @Override
    public List<Commande> get_commandes() {return (List<Commande>) commandeRepository.findAll();}
    @Override
    public Commande get_commande(Integer id) {
        return commandeRepository.findById(id).get();
    }
    @Override
    public List<Commande> get_commandes_by_date(Date date) {return (List<Commande>) commandeRepository.findCommandeByDate(date);}
    @Override
    public List<Commande> get_commandes_by_user(User user) {return (List<Commande>) commandeRepository.findCommandeByUser(user);}
    @Override
    public List<Commande> get_commandes_by_user_date(User user, Date date) {return (List<Commande>) commandeRepository.findCommandeByUserAndDate(user,date);}
    





}
