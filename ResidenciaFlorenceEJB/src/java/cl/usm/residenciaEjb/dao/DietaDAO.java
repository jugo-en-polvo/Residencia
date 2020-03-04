/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cl.usm.residenciaEjb.dao;

import cl.usm.residenciaEjb.dto.Dieta;
import cl.usm.residenciaEjb.dto.DietaID;
import java.util.Calendar;
import java.util.Date;
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
public class DietaDAO implements DietaDAOLocal {

    private final EntityManagerFactory emf = Persistence.createEntityManagerFactory("ResidenciaFlorenceEJBPU");
    
    @Override
    public void add(Dieta d) {
    
        EntityManager em = emf.createEntityManager();
        try {
            d.setResidente(em.merge(d.getResidente()));
            em.persist(d);
            em.flush();
        } catch (Exception e) {
            System.out.println(e);
        }finally{
            em.close();
        }
        
    }

    @Override
    public void update(Dieta d) {
        
        EntityManager em = emf.createEntityManager();
        try {
            em.merge(d);
            em.flush();
        } catch (Exception e) {
            System.out.println(e);
        }finally{
            em.close();
        }
        
    }

    @Override
    public List<Dieta> findAll() {
    
        EntityManager em = emf.createEntityManager();
        try {
            return em.createNamedQuery("Dieta.findAll", Dieta.class).getResultList();
        } catch (Exception e) {
            System.out.println(e);
            return null;
        }finally{
            em.close();
        }
        
    }

    @Override
    public List<Dieta> findByRut(String rut) {
    
        EntityManager em = emf.createEntityManager();
        try{
            return em.createNamedQuery("Dieta.findByRut", Dieta.class)
                    .setParameter("rut_residente", rut)
                    .getResultList();
        }catch(Exception e){
            System.out.println(e);
            return null;
        }finally{
            em.close();
        }
        
    }

    @Override
    public Dieta findByFecha(Date fecha) {
    
        EntityManager em = emf.createEntityManager();
        try {
            return em.createNamedQuery("Dieta.findByFecha", Dieta.class)
                    .setParameter("fecha", fecha)
                    .getSingleResult();
        } catch (Exception e) {
            System.out.println(e);
            return null;
        }finally{
            em.close();
        }
        
    }

    @Override
    public Dieta findByCompositeKey(Calendar fecha, String rut) {
    
        EntityManager em = emf.createEntityManager();
        try {
            DietaID compositeKey = new DietaID(fecha, rut);
            return em.find(Dieta.class, compositeKey);
        } catch (Exception e) {
            System.out.println(e);
            return null;
        }finally{
            em.close();
        }
        
    }

}
