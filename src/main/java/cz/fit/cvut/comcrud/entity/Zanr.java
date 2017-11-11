/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cz.fit.cvut.comcrud.entity;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Collection;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author Marek Lukáš <lukasma5@fit.cvut.cz>
 */
@Entity
@Table(name = "ZANR")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Zanr.findAll", query = "SELECT z FROM Zanr z")
    , @NamedQuery(name = "Zanr.findByIdZanr", query = "SELECT z FROM Zanr z WHERE z.idZanr = :idZanr")
    , @NamedQuery(name = "Zanr.findByNazev", query = "SELECT z FROM Zanr z WHERE z.nazev = :nazev")
    , @NamedQuery(name = "Zanr.findByPopis", query = "SELECT z FROM Zanr z WHERE z.popis = :popis")})
public class Zanr implements Serializable {

    private static final long serialVersionUID = 1L;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "ID_ZANR")
    private BigDecimal idZanr;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 128)
    @Column(name = "NAZEV")
    private String nazev;
    @Size(max = 512)
    @Column(name = "POPIS")
    private String popis;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idZanr")
    private Collection<Komiks> komiksCollection;

    public Zanr() {
    }

    public Zanr(BigDecimal idZanr) {
        this.idZanr = idZanr;
    }

    public Zanr(BigDecimal idZanr, String nazev) {
        this.idZanr = idZanr;
        this.nazev = nazev;
    }

    public BigDecimal getIdZanr() {
        return idZanr;
    }

    public void setIdZanr(BigDecimal idZanr) {
        this.idZanr = idZanr;
    }

    public String getNazev() {
        return nazev;
    }

    public void setNazev(String nazev) {
        this.nazev = nazev;
    }

    public String getPopis() {
        return popis;
    }

    public void setPopis(String popis) {
        this.popis = popis;
    }

    @XmlTransient
    public Collection<Komiks> getKomiksCollection() {
        return komiksCollection;
    }

    public void setKomiksCollection(Collection<Komiks> komiksCollection) {
        this.komiksCollection = komiksCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idZanr != null ? idZanr.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Zanr)) {
            return false;
        }
        Zanr other = (Zanr) object;
        if ((this.idZanr == null && other.idZanr != null) || (this.idZanr != null && !this.idZanr.equals(other.idZanr))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "cz.fit.cvut.comcrud.Zanr[ idZanr=" + idZanr + " ]";
    }
    
}
