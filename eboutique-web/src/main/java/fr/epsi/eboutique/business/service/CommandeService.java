package fr.epsi.eboutique.business.service;

import javax.inject.Inject;
import javax.inject.Named;

import fr.epsi.eboutique.business.dao.CommandeDao;
import fr.epsi.eboutique.business.entity.Commande;

@Named
public class CommandeService {

    @Inject
    private CommandeDao commandeDao;

    public void addCommande( Commande commande ) {
        this.commandeDao.addCommande( commande );
    }

}
