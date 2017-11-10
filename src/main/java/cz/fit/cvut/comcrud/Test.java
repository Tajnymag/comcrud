/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cz.fit.cvut.comcrud;

import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;

/**
 *
 * @author Marek Lukáš <lukasma5@fit.cvut.cz>
 */
public class Test {
    public static void main(String[] args) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("ComCrudPU");
	EntityManager em = emf.createEntityManager();
	EntityTransaction trans = em.getTransaction();
	
	trans.begin();
	
	TypedQuery<Comic> qSem = em.createQuery("SELECT s FROM Comic", Comic.class);
	
	List<Comic> result = qSem.getResultList();
        
	trans.commit();
    }
}
