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
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
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
@Table(name = "KOMIKS")
@XmlRootElement
@NamedQueries({
@NamedQuery(name = "Komiks.findAll", query = "SELECT k FROM Komiks k")
, @NamedQuery(name = "Komiks.findByIdKomiks", query = "SELECT k FROM Komiks k WHERE k.idKomiks = :idKomiks")
, @NamedQuery(name = "Komiks.findByNazev", query = "SELECT k FROM Komiks k WHERE k.nazev = :nazev")
, @NamedQuery(name = "Komiks.findByUrl", query = "SELECT k FROM Komiks k WHERE k.url = :url")
, @NamedQuery(name = "Komiks.findByFeed", query = "SELECT k FROM Komiks k WHERE k.feed = :feed")
, @NamedQuery(name = "Komiks.findByPopis", query = "SELECT k FROM Komiks k WHERE k.popis = :popis")
, @NamedQuery(name = "Komiks.findByIkona", query = "SELECT k FROM Komiks k WHERE k.ikona = :ikona")
, @NamedQuery(name = "Komiks.findByNsfw", query = "SELECT k FROM Komiks k WHERE k.nsfw = :nsfw")})
public class Komiks implements Serializable {

	@JoinTable(name = "AUTORSTVI_KOMIKSU", joinColumns = {
		@JoinColumn(name = "ID_KOMIKS", referencedColumnName = "ID_KOMIKS")}, inverseJoinColumns = {
		@JoinColumn(name = "ID_AUTOR", referencedColumnName = "ID_AUTOR")})
	@ManyToMany
	private Collection<Autor> autorCollection;
	@JoinTable(name = "OBSAH_SLOZKY", joinColumns = {
		@JoinColumn(name = "ID_KOMIKS", referencedColumnName = "ID_KOMIKS")}, inverseJoinColumns = {
		@JoinColumn(name = "ID_SLOZKA", referencedColumnName = "ID_SLOZKA")})
	@ManyToMany
	private Collection<Slozka> slozkaCollection;

	private static final long serialVersionUID = 1L;
	// @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
	@Id
	@Basic(optional = false)
	@NotNull
	@Column(name = "ID_KOMIKS")
	private BigDecimal idKomiks;
	@Basic(optional = false)
	@NotNull
	@Size(min = 1, max = 256)
	@Column(name = "NAZEV")
	private String nazev;
	@Basic(optional = false)
	@NotNull
	@Size(min = 1, max = 512)
	@Column(name = "URL")
	private String url;
	@Size(max = 512)
	@Column(name = "FEED")
	private String feed;
	@Basic(optional = false)
	@NotNull
	@Size(min = 1, max = 512)
	@Column(name = "POPIS")
	private String popis;
	@Basic(optional = false)
	@NotNull
	@Size(min = 1, max = 128)
	@Column(name = "IKONA")
	private String ikona;
	@Basic(optional = false)
	@NotNull
	@Column(name = "NSFW")
	private BigInteger nsfw;
	@JoinColumn(name = "ID_ZANR", referencedColumnName = "ID_ZANR")
	@ManyToOne(optional = false)
	private Zanr idZanr;
	@OneToMany(cascade = CascadeType.ALL, mappedBy = "idKomiks")
	private Collection<Prispevek> prispevekCollection;

	public Komiks() {
	}

	public Komiks(BigDecimal idKomiks) {
		this.idKomiks = idKomiks;
	}

	public Komiks(BigDecimal idKomiks, String nazev, String url, String popis, String ikona, BigInteger nsfw) {
		this.idKomiks = idKomiks;
		this.nazev = nazev;
		this.url = url;
		this.popis = popis;
		this.ikona = ikona;
		this.nsfw = nsfw;
	}

	public BigDecimal getIdKomiks() {
		return idKomiks;
	}

	public void setIdKomiks(BigDecimal idKomiks) {
		this.idKomiks = idKomiks;
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

	public String getFeed() {
		return feed;
	}

	public void setFeed(String feed) {
		this.feed = feed;
	}

	public String getPopis() {
		return popis;
	}

	public void setPopis(String popis) {
		this.popis = popis;
	}

	public String getIkona() {
		return ikona;
	}

	public void setIkona(String ikona) {
		this.ikona = ikona;
	}

	public BigInteger getNsfw() {
		return nsfw;
	}

	public void setNsfw(BigInteger nsfw) {
		this.nsfw = nsfw;
	}

	public Zanr getIdZanr() {
		return idZanr;
	}

	public void setIdZanr(Zanr idZanr) {
		this.idZanr = idZanr;
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
		hash += (idKomiks != null ? idKomiks.hashCode() : 0);
		return hash;
	}

	@Override
	public boolean equals(Object object) {
		// TODO: Warning - this method won't work in the case the id fields are not set
		if (!(object instanceof Komiks)) {
			return false;
		}
		Komiks other = (Komiks) object;
		if ((this.idKomiks == null && other.idKomiks != null) || (this.idKomiks != null && !this.idKomiks.equals(other.idKomiks))) {
			return false;
		}
		return true;
	}

	@Override
	public String toString() {
		return "cz.fit.cvut.comcrud.Komiks[ idKomiks=" + idKomiks + " ]";
	}

	@XmlTransient
	public Collection<Autor> getAutorCollection() {
		return autorCollection;
	}

	public void setAutorCollection(Collection<Autor> autorCollection) {
		this.autorCollection = autorCollection;
	}

	@XmlTransient
	public Collection<Slozka> getSlozkaCollection() {
		return slozkaCollection;
	}

	public void setSlozkaCollection(Collection<Slozka> slozkaCollection) {
		this.slozkaCollection = slozkaCollection;
	}
	
}
