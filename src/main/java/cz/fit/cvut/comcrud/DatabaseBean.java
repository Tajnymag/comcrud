/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cz.fit.cvut.comcrud;

import cz.fit.cvut.comcrud.entity.Komiks;
import java.util.Collection;
import javax.ejb.Stateful;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

/**
 *
 * @author Marek Lukáš <lukasma5@fit.cvut.cz>
 */
@Stateful
public class DatabaseBean {

    @PersistenceContext(unitName= "ComCrudPU")
    EntityManager em;
    
    // Add business logic below. (Right-click in editor and choose
    // "Insert Code > Add Business Method")
    
    public DatabaseBean() {
    }
    
    public Collection<Komiks> getListOfComics() {
        Query query = em.createQuery("SELECT k FROM Komiks k");
        return (Collection<Komiks>) query.getResultList();
    }
}
