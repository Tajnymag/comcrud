/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cz.fit.cvut.comcrud.resources;

import javax.ws.rs.GET;
import javax.ws.rs.Produces;
import javax.ws.rs.Path;

/**
 *
 * @author Marek Lukáš <lukasma5@fit.cvut.cz>
 */
@Path("/comics")
public class KomiksResource {
	@GET
	@Produces("text/plain")
	public String getAllComics() {
		return "nope";
	}
}
