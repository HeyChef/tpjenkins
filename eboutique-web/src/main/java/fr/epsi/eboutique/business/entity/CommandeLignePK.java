package fr.epsi.eboutique.business.entity;

import java.io.Serializable;
import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

public class CommandeLignePK implements Serializable {

	@ManyToOne
	@JoinColumn(name = "commande_id")
	private Commande commande;

	@ManyToOne
	@JoinColumn(name = "produit_id")
	private Produit produit;

	public Produit getProduit() {
		return produit;
	}

	public void setProduit(Produit produit) {
		this.produit = produit;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o)
			return true;
		if (o == null || getClass() != o.getClass())
			return false;
		CommandeLignePK commandeId1 = (CommandeLignePK) o;
		if (commande != commandeId1.commande)
			return false;
		return produit == commandeId1.produit;
	}

	@Override
	public int hashCode() {
		return Objects.hash(commande, produit);
	}

}
