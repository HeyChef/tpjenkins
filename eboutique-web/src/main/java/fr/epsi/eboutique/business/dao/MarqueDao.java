package fr.epsi.eboutique.business.dao;

import java.util.Collection;
import java.util.List;
import java.util.Optional;

import javax.inject.Named;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.persistence.TypedQuery;

import fr.epsi.eboutique.business.entity.Marque;
import fr.epsi.eboutique.business.entity.Produit;

@Named
public class MarqueDao {
  
  @PersistenceContext(unitName = "eboutique-business")
  private EntityManager em;
  
@SuppressWarnings("unchecked")
public Collection<Marque> findAll(){
	  Query  query= em.createQuery("SELECT e FROM Marque e");
    return (Collection<Marque>) query.getResultList();
  }
}
