package fr.epsi.eboutique.business.entity;

import java.io.Serializable;
import java.util.Objects;

@SuppressWarnings("serial")
public class CommandeLignePK implements Serializable {

	private Long commande;

	private Long produit;

	@Override
	public boolean equals(Object o) {
		if (this == o)
			return true;
		if (o == null || getClass() != o.getClass())
			return false;
		CommandeLignePK commandeLigneId1 = (CommandeLignePK) o;
		if (commande != commandeLigneId1.commande)
			return false;
		return produit == commandeLigneId1.produit;
	}

	@Override
	public int hashCode() {
		return Objects.hash(commande, produit);
	}

}
