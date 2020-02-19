/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cl.usm.residenciaEjb.dao;

import cl.usm.residenciaEjb.dto.Residente;
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
public class ResidenteDAO implements ResidenteDAOLocal {

    private final EntityManagerFactory emf = Persistence.createEntityManagerFactory("ResidenciaFlorenceEJBPU");
    
    @Override
    public void add(Residente r) {
        
        EntityManager em = emf.createEntityManager();
        try{
            r.setPrecision(em.merge(r.getPrecision()));
            r.setApoderado(em.merge(r.getApoderado()));
            em.persist(r);
        }catch(Exception e){
            System.out.println(e);
        }finally{
            em.close();
        }
        
    }

    @Override
    public List<Residente> findAll() {
        
        EntityManager em = emf.createEntityManager();
        try{
            return em.createNamedQuery("Residente.findAll", Residente.class).getResultList();
        }catch(Exception e){
            System.out.println(e);
            return null;
        }finally{
            em.close();
        }
        
    }

}
