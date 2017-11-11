/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cz.fit.cvut.comcrud.entity;

import java.io.Serializable;
import java.math.BigInteger;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Marek Lukáš <lukasma5@fit.cvut.cz>
 */
@Entity
@Table(name = "UZIVATELE_A_AUTORI")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "UzivateleAAutori.findAll", query = "SELECT u FROM UzivateleAAutori u")
    , @NamedQuery(name = "UzivateleAAutori.findByIdSloucenehoUzivatele", query = "SELECT u FROM UzivateleAAutori u WHERE u.idSloucenehoUzivatele = :idSloucenehoUzivatele")
    , @NamedQuery(name = "UzivateleAAutori.findByJmeno", query = "SELECT u FROM UzivateleAAutori u WHERE u.jmeno = :jmeno")
    , @NamedQuery(name = "UzivateleAAutori.findByPrijmeni", query = "SELECT u FROM UzivateleAAutori u WHERE u.prijmeni = :prijmeni")
    , @NamedQuery(name = "UzivateleAAutori.findByNickname", query = "SELECT u FROM UzivateleAAutori u WHERE u.nickname = :nickname")
    , @NamedQuery(name = "UzivateleAAutori.findByPohlavi", query = "SELECT u FROM UzivateleAAutori u WHERE u.pohlavi = :pohlavi")
    , @NamedQuery(name = "UzivateleAAutori.findByHeslo", query = "SELECT u FROM UzivateleAAutori u WHERE u.heslo = :heslo")
    , @NamedQuery(name = "UzivateleAAutori.findByIdNarodnost", query = "SELECT u FROM UzivateleAAutori u WHERE u.idNarodnost = :idNarodnost")})
public class UzivateleAAutori implements Serializable {

    private static final long serialVersionUID = 1L;
    @Column(name = "ID_SLOUCENEHO_UZIVATELE")
    private BigInteger idSloucenehoUzivatele;
    @Size(max = 512)
    @Column(name = "JMENO")
    private String jmeno;
    @Size(max = 512)
    @Column(name = "PRIJMENI")
    private String prijmeni;
    @Size(max = 128)
    @Column(name = "NICKNAME")
    private String nickname;
    @Size(max = 128)
    @Column(name = "POHLAVI")
    private String pohlavi;
    @Size(max = 512)
    @Column(name = "HESLO")
    private String heslo;
    @Column(name = "ID_NARODNOST")
    private BigInteger idNarodnost;

    public UzivateleAAutori() {
    }

    public BigInteger getIdSloucenehoUzivatele() {
        return idSloucenehoUzivatele;
    }

    public void setIdSloucenehoUzivatele(BigInteger idSloucenehoUzivatele) {
        this.idSloucenehoUzivatele = idSloucenehoUzivatele;
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

    public String getPohlavi() {
        return pohlavi;
    }

    public void setPohlavi(String pohlavi) {
        this.pohlavi = pohlavi;
    }

    public String getHeslo() {
        return heslo;
    }

    public void setHeslo(String heslo) {
        this.heslo = heslo;
    }

    public BigInteger getIdNarodnost() {
        return idNarodnost;
    }

    public void setIdNarodnost(BigInteger idNarodnost) {
        this.idNarodnost = idNarodnost;
    }
    
}
