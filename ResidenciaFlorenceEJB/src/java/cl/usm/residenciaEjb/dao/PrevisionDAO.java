/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cl.usm.residenciaEjb.dao;

import cl.usm.residenciaEjb.dto.Prevision;
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
public class PrevisionDAO implements PrevisionDAOLocal {

    private final EntityManagerFactory emf = Persistence.createEntityManagerFactory("ResidenciaFlorenceEJBPU");
    
    @Override
    public Prevision find(long id) {
    
        EntityManager em = emf.createEntityManager();
        try {
            return em.find(Prevision.class, id);
        } catch (Exception e) {
            return null;
        }finally{
            em.close();
        }
        
    }

    @Override
    public List<Prevision> findAll() {
    
        EntityManager em = emf.createEntityManager();
        
        try {
            return em.createNamedQuery("Prevision.findAll", Prevision.class).getResultList();
        } catch (Exception e) {
            System.out.println(e);
            return null;
        }finally{
            em.close();
        }
        
    }

    @Override
    public void add(Prevision p) {
    
        EntityManager em = emf.createEntityManager();
        
        try {
            em.persist(p);
        } catch (Exception e) {
            
        }finally{
            em.close();
        }
        
    }

   
}
