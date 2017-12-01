/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cz.fit.cvut.comcrud.entity.service;

import cz.fit.cvut.comcrud.entity.Historie;
import cz.fit.cvut.comcrud.entity.HistoriePK;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.PathSegment;

/**
 *
 * @author Marek Lukáš <lukasma5@fit.cvut.cz>
 */
@Stateless
@Path("cz.fit.cvut.comcrud.entity.historie")
public class HistorieFacadeREST extends AbstractFacade<Historie> {

	@PersistenceContext(unitName = "ComCrudPU")
	private EntityManager em;

	private HistoriePK getPrimaryKey(PathSegment pathSegment) {
		/*
		 * pathSemgent represents a URI path segment and any associated matrix parameters.
		 * URI path part is supposed to be in form of 'somePath;datum=datumValue;idPrispevek=idPrispevekValue;idUzivatel=idUzivatelValue'.
		 * Here 'somePath' is a result of getPath() method invocation and
		 * it is ignored in the following code.
		 * Matrix parameters are used as field names to build a primary key instance.
		 */
		cz.fit.cvut.comcrud.entity.HistoriePK key = new cz.fit.cvut.comcrud.entity.HistoriePK();
		javax.ws.rs.core.MultivaluedMap<String, String> map = pathSegment.getMatrixParameters();
		java.util.List<String> datum = map.get("datum");
		if (datum != null && !datum.isEmpty()) {
			key.setDatum(new java.util.Date(datum.get(0)));
		}
		java.util.List<String> idPrispevek = map.get("idPrispevek");
		if (idPrispevek != null && !idPrispevek.isEmpty()) {
			key.setIdPrispevek(new java.math.BigInteger(idPrispevek.get(0)));
		}
		java.util.List<String> idUzivatel = map.get("idUzivatel");
		if (idUzivatel != null && !idUzivatel.isEmpty()) {
			key.setIdUzivatel(new java.math.BigInteger(idUzivatel.get(0)));
		}
		return key;
	}

	public HistorieFacadeREST() {
		super(Historie.class);
	}

	@POST
    @Override
    @Consumes({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
	public void create(Historie entity) {
		super.create(entity);
	}

	@PUT
    @Path("{id}")
    @Consumes({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
	public void edit(@PathParam("id") PathSegment id, Historie entity) {
		super.edit(entity);
	}

	@DELETE
    @Path("{id}")
	public void remove(@PathParam("id") PathSegment id) {
		cz.fit.cvut.comcrud.entity.HistoriePK key = getPrimaryKey(id);
		super.remove(super.find(key));
	}

	@GET
    @Path("{id}")
    @Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
	public Historie find(@PathParam("id") PathSegment id) {
		cz.fit.cvut.comcrud.entity.HistoriePK key = getPrimaryKey(id);
		return super.find(key);
	}

	@GET
    @Override
    @Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
	public List<Historie> findAll() {
		return super.findAll();
	}

	@GET
    @Path("{from}/{to}")
    @Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
	public List<Historie> findRange(@PathParam("from") Integer from, @PathParam("to") Integer to) {
		return super.findRange(new int[]{from, to});
	}

	@GET
    @Path("count")
    @Produces(MediaType.TEXT_PLAIN)
	public String countREST() {
		return String.valueOf(super.count());
	}

	@Override
	protected EntityManager getEntityManager() {
		return em;
	}
	
}
