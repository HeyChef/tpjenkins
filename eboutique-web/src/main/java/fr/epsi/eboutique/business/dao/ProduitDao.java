package fr.epsi.eboutique.business.dao;

import java.util.Collection;
import java.util.List;
import java.util.Optional;

import javax.inject.Named;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.persistence.TypedQuery;

import fr.epsi.eboutique.business.entity.Commande;
import fr.epsi.eboutique.business.entity.Marque;
import fr.epsi.eboutique.business.entity.Produit;

@Named
public class ProduitDao {

	@PersistenceContext(unitName = "eboutique-business")
	private EntityManager em;

	@SuppressWarnings("unchecked")
	public Collection<Produit> findAll() {
		Query query = em.createQuery("SELECT p FROM Produit p ORDER BY libelle ASC");
		return (Collection<Produit>) query.getResultList();
	}

	public Collection<Produit> findByLibelle(String libelle) {
		TypedQuery<Produit> query = em.createQuery(
				"SELECT p FROM Produit p WHERE p.libelle LIKE :libelle ORDER BY libelle ASC", Produit.class);
		return (Collection<Produit>) query.setParameter("libelle", "%" + libelle + "%").getResultList();
	}

	public Collection<Produit> findByMarque(String marque) {
		TypedQuery<Produit> query = em.createQuery(
				"SELECT p FROM Produit p JOIN  p.marque m WHERE m.libelle=:marque ORDER BY p.libelle ASC",
				Produit.class);
		return (Collection<Produit>) query.setParameter("marque", marque).getResultList();
	}

	public Produit findById(Long id) {
		return (Produit) em.find(Produit.class, id);
	}
}
