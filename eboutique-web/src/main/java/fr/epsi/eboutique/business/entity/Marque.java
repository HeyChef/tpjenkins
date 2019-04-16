package fr.epsi.eboutique.business.entity;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table( name = "marque" )
public class Marque {

    @Id
    @GeneratedValue( strategy = GenerationType.IDENTITY )
    @Column( name = "id" )
    private Long          identifier;

    @Column( name = "libelle" )
    private String        libelle;

    @OneToMany( mappedBy = "marque" )
    private List<Produit> produits;

    public Long getIdentifier() {
        return identifier;
    }

    public void setIdentifier( Long identifier ) {
        this.identifier = identifier;
    }

    public String getLibelle() {
        return libelle;
    }

    public void setLibelle( String libelle ) {
        this.libelle = libelle;
    }

    public List<Produit> getProduits() {
        return produits;
    }

    public void setProduits( List<Produit> produits ) {
        this.produits = produits;
    }

}
