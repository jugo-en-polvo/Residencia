/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cl.usm.residenciaEjb.dao;

import cl.usm.residenciaEjb.dto.Lugar;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/**
 *
 * @author Senpai
 */
@Stateless
public class LugarDAO implements LugarDAOLocal {

    private final EntityManagerFactory emf = Persistence.createEntityManagerFactory("ResidenciaFlorenceEJBPU");
    
    @Override
    public List<Lugar> findAll() {
        
        EntityManager em = emf.createEntityManager();
        try {
            return em.createNamedQuery("Lugar.findAll", Lugar.class).getResultList();
        } catch (Exception e) {
            System.out.println(e);
            return null;
        }finally{
            em.close();
        }
    }

    @Override
    public void add(Lugar l) {
        
        EntityManager em = emf.createEntityManager();
        try {
            em.persist(l);
        } catch (Exception e) {
            System.out.println(e);
        }finally{
            em.close();
        }
        
    }

    @Override
    public Lugar find(long id) {
    
        EntityManager em = emf.createEntityManager();
        try {
            return em.find(Lugar.class, id);
        } catch (Exception e) {
            System.out.println(e);
            return null;
        }finally{
            em.close();
        }
        
    }

    @Override
    public void update(Lugar l) {
        
        EntityManager em = emf.createEntityManager();
        try {
            em.merge(l);
        } catch (Exception e) {
            System.out.println(e);
        }finally{
            em.close();
        }
        
    }

    
}
