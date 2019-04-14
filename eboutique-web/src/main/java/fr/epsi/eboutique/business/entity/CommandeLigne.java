package fr.epsi.eboutique.business.entity;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@IdClass(value = CommandeLignePK.class)
@Table(name = "comm_produit")
public class CommandeLigne {

	@Id
	@ManyToOne
	@JoinColumn(name = "commande_id")
	private Commande commande;

	@Id
	@ManyToOne
	@JoinColumn(name = "produit_id")
	private Produit produit;

	private int quantite;

	public Produit getProduit() {
		return produit;
	}

	public void setProduit(Produit produit) {
		this.produit = produit;
	}

	public int getQuantite() {
		return quantite;
	}

	public void setQuantite(int quantite) {
		this.quantite = quantite;
	}

}
