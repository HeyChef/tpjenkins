package fr.epsi.eboutique.business.dao;

import java.time.LocalDate;

import javax.inject.Named;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import fr.epsi.eboutique.business.entity.Commande;
import fr.epsi.eboutique.business.entity.CommandeLigne;

@Named
public class CommandeDao {

    public void addCommande( Commande commande ) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory( "eboutique-business" );
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();

        LocalDate date = LocalDate.now();
        commande.setDateCreation( date );
        em.persist( commande );
        for ( CommandeLigne uneLigne : commande.getLignes() ) {
            uneLigne.setCommande( commande );
            em.merge( uneLigne );
        }
        em.getTransaction().commit();
    }
}
