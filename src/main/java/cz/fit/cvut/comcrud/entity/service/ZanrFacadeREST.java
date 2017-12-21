/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cz.fit.cvut.comcrud.entity.service;

import cz.fit.cvut.comcrud.entity.Zanr;
import cz.fit.cvut.comcrud.entity.ZanrList;
import java.math.BigDecimal;
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

/**
 *
 * @author Marek Lukáš <lukasma5@fit.cvut.cz>
 */
@Stateless
@Path("zanr")
public class ZanrFacadeREST extends AbstractFacade<Zanr> {

	@PersistenceContext(unitName = "ComCrudPU")
	private EntityManager em;

	public ZanrFacadeREST() {
		super(Zanr.class);
	}

	@POST
    @Override
    @Consumes({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
	public void create(Zanr entity) {
		super.create(entity);
	}

	@PUT
    @Path("{id}")
    @Consumes({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
	public void edit(@PathParam("id") BigDecimal id, Zanr entity) {
		super.edit(entity);
	}

	@DELETE
    @Path("{id}")
	public void remove(@PathParam("id") BigDecimal id) {
		super.remove(super.find(id));
	}

	@GET
    @Path("{id}")
    @Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
	public Zanr find(@PathParam("id") BigDecimal id) {
		return super.find(id);
	}

	@GET
    @Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
	public ZanrList findAllZanrs() {
		ZanrList l = new ZanrList();
		l.setZanrs(super.findAll());
		return l;
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
