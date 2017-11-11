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
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
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
@Table(name = "UZIVATEL")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Uzivatel.findAll", query = "SELECT u FROM Uzivatel u")
    , @NamedQuery(name = "Uzivatel.findByIdUzivatel", query = "SELECT u FROM Uzivatel u WHERE u.idUzivatel = :idUzivatel")
    , @NamedQuery(name = "Uzivatel.findByJmeno", query = "SELECT u FROM Uzivatel u WHERE u.jmeno = :jmeno")
    , @NamedQuery(name = "Uzivatel.findByPrijmeni", query = "SELECT u FROM Uzivatel u WHERE u.prijmeni = :prijmeni")
    , @NamedQuery(name = "Uzivatel.findByNickname", query = "SELECT u FROM Uzivatel u WHERE u.nickname = :nickname")
    , @NamedQuery(name = "Uzivatel.findByHeslo", query = "SELECT u FROM Uzivatel u WHERE u.heslo = :heslo")})
public class Uzivatel implements Serializable {

    @JoinColumn(name = "ID_NARODNOST", referencedColumnName = "ID_NARODNOST")
    @ManyToOne(optional = false)
    private Narodnost idNarodnost;

    private static final long serialVersionUID = 1L;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "ID_UZIVATEL")
    private BigDecimal idUzivatel;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 512)
    @Column(name = "JMENO")
    private String jmeno;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 512)
    @Column(name = "PRIJMENI")
    private String prijmeni;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 128)
    @Column(name = "NICKNAME")
    private String nickname;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 512)
    @Column(name = "HESLO")
    private String heslo;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "uzivatel")
    private Collection<Historie> historieCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idUzivatel")
    private Collection<Slozka> slozkaCollection;

    public Uzivatel() {
    }

    public Uzivatel(BigDecimal idUzivatel) {
        this.idUzivatel = idUzivatel;
    }

    public Uzivatel(BigDecimal idUzivatel, String jmeno, String prijmeni, String nickname, String heslo) {
        this.idUzivatel = idUzivatel;
        this.jmeno = jmeno;
        this.prijmeni = prijmeni;
        this.nickname = nickname;
        this.heslo = heslo;
    }

    public BigDecimal getIdUzivatel() {
        return idUzivatel;
    }

    public void setIdUzivatel(BigDecimal idUzivatel) {
        this.idUzivatel = idUzivatel;
    }

    public String getJmeno() {
        return jmeno;
    }

    public void setJmeno(String jmeno) {
        this.jmeno = jmeno;
    }

    public String getPrijmeni() {
        return prijmeni;
    }

    public void setPrijmeni(String prijmeni) {
        this.prijmeni = prijmeni;
    }

    public String getNickname() {
        return nickname;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }

    public String getHeslo() {
        return heslo;
    }

    public void setHeslo(String heslo) {
        this.heslo = heslo;
    }

    @XmlTransient
    public Collection<Historie> getHistorieCollection() {
        return historieCollection;
    }

    public void setHistorieCollection(Collection<Historie> historieCollection) {
        this.historieCollection = historieCollection;
    }

    @XmlTransient
    public Collection<Slozka> getSlozkaCollection() {
        return slozkaCollection;
    }

    public void setSlozkaCollection(Collection<Slozka> slozkaCollection) {
        this.slozkaCollection = slozkaCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idUzivatel != null ? idUzivatel.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Uzivatel)) {
            return false;
        }
        Uzivatel other = (Uzivatel) object;
        if ((this.idUzivatel == null && other.idUzivatel != null) || (this.idUzivatel != null && !this.idUzivatel.equals(other.idUzivatel))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "cz.fit.cvut.comcrud.Uzivatel[ idUzivatel=" + idUzivatel + " ]";
    }

    public Narodnost getIdNarodnost() {
        return idNarodnost;
    }

    public void setIdNarodnost(Narodnost idNarodnost) {
        this.idNarodnost = idNarodnost;
    }
    
}
