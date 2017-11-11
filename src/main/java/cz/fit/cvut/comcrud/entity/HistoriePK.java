/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cz.fit.cvut.comcrud.entity;

import java.io.Serializable;
import java.math.BigInteger;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;

/**
 *
 * @author Marek Lukáš <lukasma5@fit.cvut.cz>
 */
@Embeddable
public class HistoriePK implements Serializable {

    @Basic(optional = false)
    @NotNull
    @Column(name = "DATUM")
    @Temporal(TemporalType.TIMESTAMP)
    private Date datum;
    @Basic(optional = false)
    @NotNull
    @Column(name = "ID_PRISPEVEK")
    private BigInteger idPrispevek;
    @Basic(optional = false)
    @NotNull
    @Column(name = "ID_UZIVATEL")
    private BigInteger idUzivatel;

    public HistoriePK() {
    }

    public HistoriePK(Date datum, BigInteger idPrispevek, BigInteger idUzivatel) {
        this.datum = datum;
        this.idPrispevek = idPrispevek;
        this.idUzivatel = idUzivatel;
    }

    public Date getDatum() {
        return datum;
    }

    public void setDatum(Date datum) {
        this.datum = datum;
    }

    public BigInteger getIdPrispevek() {
        return idPrispevek;
    }

    public void setIdPrispevek(BigInteger idPrispevek) {
        this.idPrispevek = idPrispevek;
    }

    public BigInteger getIdUzivatel() {
        return idUzivatel;
    }

    public void setIdUzivatel(BigInteger idUzivatel) {
        this.idUzivatel = idUzivatel;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (datum != null ? datum.hashCode() : 0);
        hash += (idPrispevek != null ? idPrispevek.hashCode() : 0);
        hash += (idUzivatel != null ? idUzivatel.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof HistoriePK)) {
            return false;
        }
        HistoriePK other = (HistoriePK) object;
        if ((this.datum == null && other.datum != null) || (this.datum != null && !this.datum.equals(other.datum))) {
            return false;
        }
        if ((this.idPrispevek == null && other.idPrispevek != null) || (this.idPrispevek != null && !this.idPrispevek.equals(other.idPrispevek))) {
            return false;
        }
        if ((this.idUzivatel == null && other.idUzivatel != null) || (this.idUzivatel != null && !this.idUzivatel.equals(other.idUzivatel))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "cz.fit.cvut.comcrud.HistoriePK[ datum=" + datum + ", idPrispevek=" + idPrispevek + ", idUzivatel=" + idUzivatel + " ]";
    }
    
}
