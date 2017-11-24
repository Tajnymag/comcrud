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
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
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
@Table(name = "KAPITOLA")
@XmlRootElement
@NamedQueries({
	@NamedQuery(name = "Kapitola.findAll", query = "SELECT k FROM Kapitola k")
	, @NamedQuery(name = "Kapitola.findByIdKapitola", query = "SELECT k FROM Kapitola k WHERE k.idKapitola = :idKapitola")
	, @NamedQuery(name = "Kapitola.findByNazev", query = "SELECT k FROM Kapitola k WHERE k.nazev = :nazev")
	, @NamedQuery(name = "Kapitola.findByUrl", query = "SELECT k FROM Kapitola k WHERE k.url = :url")
	, @NamedQuery(name = "Kapitola.findByDatumPridani", query = "SELECT k FROM Kapitola k WHERE k.datumPridani = :datumPridani")
	, @NamedQuery(name = "Kapitola.findByPopis", query = "SELECT k FROM Kapitola k WHERE k.popis = :popis")})
public class Kapitola implements Serializable {

	private static final long serialVersionUID = 1L;
	// @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
	@Id
	@Basic(optional = false)
	@NotNull
	@Column(name = "ID_KAPITOLA")
	private BigDecimal idKapitola;
	@Basic(optional = false)
	@NotNull
	@Size(min = 1, max = 512)
	@Column(name = "NAZEV")
	private String nazev;
	@Basic(optional = false)
	@NotNull
	@Size(min = 1, max = 512)
	@Column(name = "URL")
	private String url;
	@Basic(optional = false)
	@NotNull
	@Column(name = "DATUM_PRIDANI")
	@Temporal(TemporalType.TIMESTAMP)
	private Date datumPridani;
	@Size(max = 512)
	@Column(name = "POPIS")
	private String popis;
	@OneToMany(mappedBy = "idKapitola")
	private Collection<Prispevek> prispevekCollection;

	public Kapitola() {
	}

	public Kapitola(BigDecimal idKapitola) {
		this.idKapitola = idKapitola;
	}

	public Kapitola(BigDecimal idKapitola, String nazev, String url, Date datumPridani) {
		this.idKapitola = idKapitola;
		this.nazev = nazev;
		this.url = url;
		this.datumPridani = datumPridani;
	}

	public BigDecimal getIdKapitola() {
		return idKapitola;
	}

	public void setIdKapitola(BigDecimal idKapitola) {
		this.idKapitola = idKapitola;
	}

	public String getNazev() {
		return nazev;
	}

	public void setNazev(String nazev) {
		this.nazev = nazev;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public Date getDatumPridani() {
		return datumPridani;
	}

	public void setDatumPridani(Date datumPridani) {
		this.datumPridani = datumPridani;
	}

	public String getPopis() {
		return popis;
	}

	public void setPopis(String popis) {
		this.popis = popis;
	}

	@XmlTransient
	public Collection<Prispevek> getPrispevekCollection() {
		return prispevekCollection;
	}

	public void setPrispevekCollection(Collection<Prispevek> prispevekCollection) {
		this.prispevekCollection = prispevekCollection;
	}

	@Override
	public int hashCode() {
		int hash = 0;
		hash += (idKapitola != null ? idKapitola.hashCode() : 0);
		return hash;
	}

	@Override
	public boolean equals(Object object) {
		// TODO: Warning - this method won't work in the case the id fields are not set
		if (!(object instanceof Kapitola)) {
			return false;
		}
		Kapitola other = (Kapitola) object;
		if ((this.idKapitola == null && other.idKapitola != null) || (this.idKapitola != null && !this.idKapitola.equals(other.idKapitola))) {
			return false;
		}
		return true;
	}

	@Override
	public String toString() {
		return "cz.fit.cvut.comcrud.Kapitola[ idKapitola=" + idKapitola + " ]";
	}
	
}
