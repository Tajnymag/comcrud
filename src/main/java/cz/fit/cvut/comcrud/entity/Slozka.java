/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cz.fit.cvut.comcrud.entity;

import java.io.Serializable;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.Collection;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
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
@Table(name = "SLOZKA")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Slozka.findAll", query = "SELECT s FROM Slozka s")
    , @NamedQuery(name = "Slozka.findByIdSlozka", query = "SELECT s FROM Slozka s WHERE s.idSlozka = :idSlozka")
    , @NamedQuery(name = "Slozka.findByNazev", query = "SELECT s FROM Slozka s WHERE s.nazev = :nazev")
    , @NamedQuery(name = "Slozka.findByBarva", query = "SELECT s FROM Slozka s WHERE s.barva = :barva")
    , @NamedQuery(name = "Slozka.findByOdebirana", query = "SELECT s FROM Slozka s WHERE s.odebirana = :odebirana")
    , @NamedQuery(name = "Slozka.findByOblibena", query = "SELECT s FROM Slozka s WHERE s.oblibena = :oblibena")})
public class Slozka implements Serializable {

    @ManyToMany(mappedBy = "slozkaCollection")
    private Collection<Komiks> komiksCollection;

    private static final long serialVersionUID = 1L;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "ID_SLOZKA")
    private BigDecimal idSlozka;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 512)
    @Column(name = "NAZEV")
    private String nazev;
    @Size(max = 64)
    @Column(name = "BARVA")
    private String barva;
    @Basic(optional = false)
    @NotNull
    @Column(name = "ODEBIRANA")
    private BigInteger odebirana;
    @Basic(optional = false)
    @NotNull
    @Column(name = "OBLIBENA")
    private BigInteger oblibena;
    @JoinColumn(name = "ID_UZIVATEL", referencedColumnName = "ID_UZIVATEL")
    @ManyToOne(optional = false)
    private Uzivatel idUzivatel;

    public Slozka() {
    }

    public Slozka(BigDecimal idSlozka) {
        this.idSlozka = idSlozka;
    }

    public Slozka(BigDecimal idSlozka, String nazev, BigInteger odebirana, BigInteger oblibena) {
        this.idSlozka = idSlozka;
        this.nazev = nazev;
        this.odebirana = odebirana;
        this.oblibena = oblibena;
    }

    public BigDecimal getIdSlozka() {
        return idSlozka;
    }

    public void setIdSlozka(BigDecimal idSlozka) {
        this.idSlozka = idSlozka;
    }

    public String getNazev() {
        return nazev;
    }

    public void setNazev(String nazev) {
        this.nazev = nazev;
    }

    public String getBarva() {
        return barva;
    }

    public void setBarva(String barva) {
        this.barva = barva;
    }

    public BigInteger getOdebirana() {
        return odebirana;
    }

    public void setOdebirana(BigInteger odebirana) {
        this.odebirana = odebirana;
    }

    public BigInteger getOblibena() {
        return oblibena;
    }

    public void setOblibena(BigInteger oblibena) {
        this.oblibena = oblibena;
    }

    public Uzivatel getIdUzivatel() {
        return idUzivatel;
    }

    public void setIdUzivatel(Uzivatel idUzivatel) {
        this.idUzivatel = idUzivatel;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idSlozka != null ? idSlozka.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Slozka)) {
            return false;
        }
        Slozka other = (Slozka) object;
        if ((this.idSlozka == null && other.idSlozka != null) || (this.idSlozka != null && !this.idSlozka.equals(other.idSlozka))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "cz.fit.cvut.comcrud.Slozka[ idSlozka=" + idSlozka + " ]";
    }

    @XmlTransient
    public Collection<Komiks> getKomiksCollection() {
        return komiksCollection;
    }

    public void setKomiksCollection(Collection<Komiks> komiksCollection) {
        this.komiksCollection = komiksCollection;
    }
    
}
