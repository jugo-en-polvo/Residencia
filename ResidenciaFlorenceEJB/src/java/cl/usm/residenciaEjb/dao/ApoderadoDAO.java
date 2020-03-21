/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cl.usm.residenciaEjb.dao;

import cl.usm.residenciaEjb.dto.Apoderado;
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
public class ApoderadoDAO implements ApoderadoDAOLocal {

    private final EntityManagerFactory emf = Persistence.createEntityManagerFactory("ResidenciaFlorenceEJBPU");
    
    @Override
    public Apoderado find(String rut) {
    
        EntityManager em = emf.createEntityManager();
        try{
            return em.find(Apoderado.class, rut);
        }catch(Exception e){
            return null;
        }
        finally{
            em.close();
        }
    }

    @Override
    public List<Apoderado> findAll() {
        
        EntityManager em = emf.createEntityManager();
        try{
            
            return em.createNamedQuery("Apoderado.findAll", Apoderado.class).getResultList();
            
        }catch(Exception e){
            System.out.println(e);
            return null;
        }finally{
            em.close();
        }
        
    }

    @Override
    public void add(Apoderado a) {
    
        EntityManager em = emf.createEntityManager();
        try {
            
            em.persist(a);
            em.flush();
            
        } catch (Exception e) {
            System.out.println(e);
        }finally{
            em.close();
        }
        
    }

    @Override
    public void update(Apoderado a) {
    
        EntityManager em = emf.createEntityManager();
        try {
            
            em.merge(a);
                    
        } catch (Exception e) {
            System.out.println(e);
        }finally{
            em.close();
        }
    
    }

    @Override
    public boolean compruebaExistencia(String rut) {
    
        EntityManager em = emf.createEntityManager();
        try {
            
            em.createNamedQuery("Apoderado.CompruebaExistencia", Apoderado.class).setParameter("rut", rut).getSingleResult();
            return true;
            
        } catch (Exception e) {
            System.out.println(e);
            return false;
        }finally{
            em.close();
        }
        
    }

}
