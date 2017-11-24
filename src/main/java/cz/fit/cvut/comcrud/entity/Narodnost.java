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
@Table(name = "NARODNOST")
@XmlRootElement
@NamedQueries({
	@NamedQuery(name = "Narodnost.findAll", query = "SELECT n FROM Narodnost n")
	, @NamedQuery(name = "Narodnost.findByIdNarodnost", query = "SELECT n FROM Narodnost n WHERE n.idNarodnost = :idNarodnost")
	, @NamedQuery(name = "Narodnost.findByNazev", query = "SELECT n FROM Narodnost n WHERE n.nazev = :nazev")})
public class Narodnost implements Serializable {

	private static final long serialVersionUID = 1L;
	// @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
	@Id
	@Basic(optional = false)
	@NotNull
	@Column(name = "ID_NARODNOST")
	private BigDecimal idNarodnost;
	@Basic(optional = false)
	@NotNull
	@Size(min = 1, max = 512)
	@Column(name = "NAZEV")
	private String nazev;
	@OneToMany(cascade = CascadeType.ALL, mappedBy = "idNarodnost")
	private Collection<Autor> autorCollection;
	@OneToMany(cascade = CascadeType.ALL, mappedBy = "idNarodnost")
	private Collection<Uzivatel> uzivatelCollection;

	public Narodnost() {
	}

	public Narodnost(BigDecimal idNarodnost) {
		this.idNarodnost = idNarodnost;
	}

	public Narodnost(BigDecimal idNarodnost, String nazev) {
		this.idNarodnost = idNarodnost;
		this.nazev = nazev;
	}

	public BigDecimal getIdNarodnost() {
		return idNarodnost;
	}

	public void setIdNarodnost(BigDecimal idNarodnost) {
		this.idNarodnost = idNarodnost;
	}

	public String getNazev() {
		return nazev;
	}

	public void setNazev(String nazev) {
		this.nazev = nazev;
	}

	@XmlTransient
	public Collection<Autor> getAutorCollection() {
		return autorCollection;
	}

	public void setAutorCollection(Collection<Autor> autorCollection) {
		this.autorCollection = autorCollection;
	}

	@XmlTransient
	public Collection<Uzivatel> getUzivatelCollection() {
		return uzivatelCollection;
	}

	public void setUzivatelCollection(Collection<Uzivatel> uzivatelCollection) {
		this.uzivatelCollection = uzivatelCollection;
	}

	@Override
	public int hashCode() {
		int hash = 0;
		hash += (idNarodnost != null ? idNarodnost.hashCode() : 0);
		return hash;
	}

	@Override
	public boolean equals(Object object) {
		// TODO: Warning - this method won't work in the case the id fields are not set
		if (!(object instanceof Narodnost)) {
			return false;
		}
		Narodnost other = (Narodnost) object;
		if ((this.idNarodnost == null && other.idNarodnost != null) || (this.idNarodnost != null && !this.idNarodnost.equals(other.idNarodnost))) {
			return false;
		}
		return true;
	}

	@Override
	public String toString() {
		return "cz.fit.cvut.comcrud.Narodnost[ idNarodnost=" + idNarodnost + " ]";
	}
	
}
