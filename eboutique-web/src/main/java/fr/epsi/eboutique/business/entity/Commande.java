package fr.epsi.eboutique.business.entity;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.Collection;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class Commande {

    @Id
    @GeneratedValue( strategy = GenerationType.IDENTITY )
    @Column( name = "id" )
    private Long                      identifier;

    @OneToMany( mappedBy = "commande" )
    private Collection<CommandeLigne> lignes;

    @Column( name = "date_creation" )
    private LocalDate                 dateCreation;

    public Collection<CommandeLigne> getLignes() {
        return lignes;
    }

    public void setLignes( Collection<CommandeLigne> lignes ) {
        this.lignes = lignes;
    }

    public LocalDate getDateCreation() {
        return dateCreation;
    }

    public void setDateCreation( LocalDate dateCreation ) {
        this.dateCreation = dateCreation;
    }

    public Long getIdentifier() {
        return identifier;
    }

    public void setIdentifier( Long identifier ) {
        this.identifier = identifier;
    }

    public BigDecimal getTotal() {
        BigDecimal total = BigDecimal.ZERO;
        for ( CommandeLigne uneLigne : lignes ) {
            total = total.add( uneLigne.getTotal() );
        }
        return total;
    }
}
