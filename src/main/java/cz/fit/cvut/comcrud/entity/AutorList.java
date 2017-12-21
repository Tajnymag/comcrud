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
public class AutorList implements Serializable {
	private List<Autor> autors;

	public List<Autor> getAutors() {
		return autors;
	}

	public void setAutors(List<Autor> autors) {
		this.autors = autors;
	}
	
}
