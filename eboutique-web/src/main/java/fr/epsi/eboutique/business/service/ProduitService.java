package fr.epsi.eboutique.business.service;

import java.util.Collection;
import java.util.List;
import java.util.Optional;

import javax.inject.Inject;
import javax.inject.Named;

import fr.epsi.eboutique.business.dao.ProduitDao;
import fr.epsi.eboutique.business.entity.Produit;

@Named
public class ProduitService {
	  @Inject
	  private ProduitDao produitDao;
	  
	  public Collection<Produit> findAll() {
		    return this.produitDao.findAll();
	  }

	  public Collection<Produit> findByLibelle(String libelle) {
	    return this.produitDao.findByLibelle(libelle);
	  }
	  
	  public Collection<Produit> findByMarque(String marque) {
		    return this.produitDao.findByMarque(marque);
	  }
	  
	  public Produit findById(Long id) {
		    return this.produitDao.findById(id);
	  }
}
