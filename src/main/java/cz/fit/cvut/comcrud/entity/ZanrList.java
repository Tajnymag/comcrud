/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cz.fit.cvut.comcrud.entity;

import java.io.Serializable;
import java.util.List;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author marek
 */
@XmlRootElement
public class ZanrList implements Serializable {
	private List<Zanr> zanrs;

	public List<Zanr> getZanrs() {
		return zanrs;
	}

	public void setZanrs(List<Zanr> zanrs) {
		this.zanrs = zanrs;
	}


	
}
