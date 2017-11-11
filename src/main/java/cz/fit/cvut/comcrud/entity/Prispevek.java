/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cz.fit.cvut.comcrud.entity;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Collection;
import java.util.Date;
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
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author Marek Lukáš <lukasma5@fit.cvut.cz>
 */
@Entity
@Table(name = "PRISPEVEK")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Prispevek.findAll", query = "SELECT p FROM Prispevek p")
    , @NamedQuery(name = "Prispevek.findByIdPrispevek", query = "SELECT p FROM Prispevek p WHERE p.idPrispevek = :idPrispevek")
    , @NamedQuery(name = "Prispevek.findByNazev", query = "SELECT p FROM Prispevek p WHERE p.nazev = :nazev")
    , @NamedQuery(name = "Prispevek.findByUrlPrispevku", query = "SELECT p FROM Prispevek p WHERE p.urlPrispevku = :urlPrispevku")
    , @NamedQuery(name = "Prispevek.findByDatumPridani", query = "SELECT p FROM Prispevek p WHERE p.datumPridani = :datumPridani")
    , @NamedQuery(name = "Prispevek.findByUrlObrazku", query = "SELECT p FROM Prispevek p WHERE p.urlObrazku = :urlObrazku")
    , @NamedQuery(name = "Prispevek.findByKomentarAutora", query = "SELECT p FROM Prispevek p WHERE p.komentarAutora = :komentarAutora")})
public class Prispevek implements Serializable {

    private static final long serialVersionUID = 1L;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "ID_PRISPEVEK")
    private BigDecimal idPrispevek;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 512)
    @Column(name = "NAZEV")
    private String nazev;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 512)
    @Column(name = "URL_PRISPEVKU")
    private String urlPrispevku;
    @Basic(optional = false)
    @NotNull
    @Column(name = "DATUM_PRIDANI")
    @Temporal(TemporalType.TIMESTAMP)
    private Date datumPridani;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 512)
    @Column(name = "URL_OBRAZKU")
    private String urlObrazku;
    @Size(max = 512)
    @Column(name = "KOMENTAR_AUTORA")
    private String komentarAutora;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "prispevek")
    private Collection<Historie> historieCollection;
    @JoinColumn(name = "ID_KAPITOLA", referencedColumnName = "ID_KAPITOLA")
    @ManyToOne
    private Kapitola idKapitola;
    @JoinColumn(name = "ID_KOMIKS", referencedColumnName = "ID_KOMIKS")
    @ManyToOne(optional = false)
    private Komiks idKomiks;
    @OneToOne(mappedBy = "idPrispevekPredchozi")
    private Prispevek prispevek;
    @JoinColumn(name = "ID_PRISPEVEK_PREDCHOZI", referencedColumnName = "ID_PRISPEVEK")
    @OneToOne
    private Prispevek idPrispevekPredchozi;

    public Prispevek() {
    }

    public Prispevek(BigDecimal idPrispevek) {
        this.idPrispevek = idPrispevek;
    }

    public Prispevek(BigDecimal idPrispevek, String nazev, String urlPrispevku, Date datumPridani, String urlObrazku) {
        this.idPrispevek = idPrispevek;
        this.nazev = nazev;
        this.urlPrispevku = urlPrispevku;
        this.datumPridani = datumPridani;
        this.urlObrazku = urlObrazku;
    }

    public BigDecimal getIdPrispevek() {
        return idPrispevek;
    }

    public void setIdPrispevek(BigDecimal idPrispevek) {
        this.idPrispevek = idPrispevek;
    }

    public String getNazev() {
        return nazev;
    }

    public void setNazev(String nazev) {
        this.nazev = nazev;
    }

    public String getUrlPrispevku() {
        return urlPrispevku;
    }

    public void setUrlPrispevku(String urlPrispevku) {
        this.urlPrispevku = urlPrispevku;
    }

    public Date getDatumPridani() {
        return datumPridani;
    }

    public void setDatumPridani(Date datumPridani) {
        this.datumPridani = datumPridani;
    }

    public String getUrlObrazku() {
        return urlObrazku;
    }

    public void setUrlObrazku(String urlObrazku) {
        this.urlObrazku = urlObrazku;
    }

    public String getKomentarAutora() {
        return komentarAutora;
    }

    public void setKomentarAutora(String komentarAutora) {
        this.komentarAutora = komentarAutora;
    }

    @XmlTransient
    public Collection<Historie> getHistorieCollection() {
        return historieCollection;
    }

    public void setHistorieCollection(Collection<Historie> historieCollection) {
        this.historieCollection = historieCollection;
    }

    public Kapitola getIdKapitola() {
        return idKapitola;
    }

    public void setIdKapitola(Kapitola idKapitola) {
        this.idKapitola = idKapitola;
    }

    public Komiks getIdKomiks() {
        return idKomiks;
    }

    public void setIdKomiks(Komiks idKomiks) {
        this.idKomiks = idKomiks;
    }

    public Prispevek getPrispevek() {
        return prispevek;
    }

    public void setPrispevek(Prispevek prispevek) {
        this.prispevek = prispevek;
    }

    public Prispevek getIdPrispevekPredchozi() {
        return idPrispevekPredchozi;
    }

    public void setIdPrispevekPredchozi(Prispevek idPrispevekPredchozi) {
        this.idPrispevekPredchozi = idPrispevekPredchozi;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idPrispevek != null ? idPrispevek.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Prispevek)) {
            return false;
        }
        Prispevek other = (Prispevek) object;
        if ((this.idPrispevek == null && other.idPrispevek != null) || (this.idPrispevek != null && !this.idPrispevek.equals(other.idPrispevek))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "cz.fit.cvut.comcrud.Prispevek[ idPrispevek=" + idPrispevek + " ]";
    }
    
}
