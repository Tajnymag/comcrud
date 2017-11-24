/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cz.fit.cvut.comcrud.entity;

import java.io.Serializable;
import java.math.BigInteger;
import java.util.Date;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Marek Lukáš <lukasma5@fit.cvut.cz>
 */
@Entity
@Table(name = "HISTORIE")
@XmlRootElement
@NamedQueries({
	@NamedQuery(name = "Historie.findAll", query = "SELECT h FROM Historie h")
	, @NamedQuery(name = "Historie.findByDatum", query = "SELECT h FROM Historie h WHERE h.historiePK.datum = :datum")
	, @NamedQuery(name = "Historie.findByIdPrispevek", query = "SELECT h FROM Historie h WHERE h.historiePK.idPrispevek = :idPrispevek")
	, @NamedQuery(name = "Historie.findByIdUzivatel", query = "SELECT h FROM Historie h WHERE h.historiePK.idUzivatel = :idUzivatel")})
public class Historie implements Serializable {

	private static final long serialVersionUID = 1L;
	@EmbeddedId
	protected HistoriePK historiePK;
	@JoinColumn(name = "ID_PRISPEVEK", referencedColumnName = "ID_PRISPEVEK", insertable = false, updatable = false)
	@ManyToOne(optional = false)
	private Prispevek prispevek;
	@JoinColumn(name = "ID_UZIVATEL", referencedColumnName = "ID_UZIVATEL", insertable = false, updatable = false)
	@ManyToOne(optional = false)
	private Uzivatel uzivatel;

	public Historie() {
	}

	public Historie(HistoriePK historiePK) {
		this.historiePK = historiePK;
	}

	public Historie(Date datum, BigInteger idPrispevek, BigInteger idUzivatel) {
		this.historiePK = new HistoriePK(datum, idPrispevek, idUzivatel);
	}

	public HistoriePK getHistoriePK() {
		return historiePK;
	}

	public void setHistoriePK(HistoriePK historiePK) {
		this.historiePK = historiePK;
	}

	public Prispevek getPrispevek() {
		return prispevek;
	}

	public void setPrispevek(Prispevek prispevek) {
		this.prispevek = prispevek;
	}

	public Uzivatel getUzivatel() {
		return uzivatel;
	}

	public void setUzivatel(Uzivatel uzivatel) {
		this.uzivatel = uzivatel;
	}

	@Override
	public int hashCode() {
		int hash = 0;
		hash += (historiePK != null ? historiePK.hashCode() : 0);
		return hash;
	}

	@Override
	public boolean equals(Object object) {
		// TODO: Warning - this method won't work in the case the id fields are not set
		if (!(object instanceof Historie)) {
			return false;
		}
		Historie other = (Historie) object;
		if ((this.historiePK == null && other.historiePK != null) || (this.historiePK != null && !this.historiePK.equals(other.historiePK))) {
			return false;
		}
		return true;
	}

	@Override
	public String toString() {
		return "cz.fit.cvut.comcrud.Historie[ historiePK=" + historiePK + " ]";
	}
	
}
