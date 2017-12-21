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
@Table(name = "AUTOR")
@XmlRootElement
@NamedQueries({
	@NamedQuery(name = "Autor.findAll", query = "SELECT a FROM Autor a")
	, @NamedQuery(name = "Autor.findByIdAutor", query = "SELECT a FROM Autor a WHERE a.idAutor = :idAutor")
	, @NamedQuery(name = "Autor.findByJmeno", query = "SELECT a FROM Autor a WHERE a.jmeno = :jmeno")
	, @NamedQuery(name = "Autor.findByPrijmeni", query = "SELECT a FROM Autor a WHERE a.prijmeni = :prijmeni")
	, @NamedQuery(name = "Autor.findByPohlavi", query = "SELECT a FROM Autor a WHERE a.pohlavi = :pohlavi")
	, @NamedQuery(name = "Autor.findByInfo", query = "SELECT a FROM Autor a WHERE a.info = :info")})
public class Autor implements Serializable {

	
	@JoinColumn(name = "ID_NARODNOST", referencedColumnName = "ID_NARODNOST")
	@ManyToOne(optional = false)
	private Narodnost idNarodnost;

	private static final long serialVersionUID = 1L;
	// @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
	@Id
	@Basic(optional = false)
	@NotNull
	@Column(name = "ID_AUTOR")
	private BigDecimal idAutor;
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
	@Size(max = 128)
	@Column(name = "POHLAVI")
	private String pohlavi;
	@Size(max = 512)
	@Column(name = "INFO")
	private String info;

	public Autor() {
	}

	public Autor(BigDecimal idAutor) {
		this.idAutor = idAutor;
	}

	public Autor(BigDecimal idAutor, String jmeno, String prijmeni) {
		this.idAutor = idAutor;
		this.jmeno = jmeno;
		this.prijmeni = prijmeni;
	}

	public BigDecimal getIdAutor() {
		return idAutor;
	}

	public void setIdAutor(BigDecimal idAutor) {
		this.idAutor = idAutor;
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

	public String getPohlavi() {
		return pohlavi;
	}

	public void setPohlavi(String pohlavi) {
		this.pohlavi = pohlavi;
	}

	public String getInfo() {
		return info;
	}

	public void setInfo(String info) {
		this.info = info;
	}

	@Override
	public int hashCode() {
		int hash = 0;
		hash += (idAutor != null ? idAutor.hashCode() : 0);
		return hash;
	}

	@Override
	public boolean equals(Object object) {
		// TODO: Warning - this method won't work in the case the id fields are not set
		if (!(object instanceof Autor)) {
			return false;
		}
		Autor other = (Autor) object;
		if ((this.idAutor == null && other.idAutor != null) || (this.idAutor != null && !this.idAutor.equals(other.idAutor))) {
			return false;
		}
		return true;
	}

	@Override
	public String toString() {
		return "cz.fit.cvut.comcrud.Autor[ idAutor=" + idAutor + " ]";
	}

	public Narodnost getIdNarodnost() {
		return idNarodnost;
	}

	public void setIdNarodnost(Narodnost idNarodnost) {
		this.idNarodnost = idNarodnost;
	}
	
}
