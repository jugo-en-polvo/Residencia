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
            r.setPrevisionNombreTipo(em.merge(r.getPrevisionNombreTipo()));
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

    @Override
    public Residente find(String rut) {
    
        EntityManager em = emf.createEntityManager();
        try {
            return em.find(Residente.class, rut);
        } catch (Exception e) {
            System.out.println(e);
            return null;
        }finally{
            em.close();
        }
        
    }

    @Override
    public void update(Residente r) {
    
        EntityManager em = emf.createEntityManager();
        try {
            em.merge(r);
        } catch (Exception e) {
            System.out.println(e);
        }finally{
            em.close();
        }
        
    }

    @Override
    public List<Residente> findAllActuales() {
    
        EntityManager em = emf.createEntityManager();
        try {
            return em.createNamedQuery("Residente.findAllActuales", Residente.class).getResultList();
        } catch (Exception e) {
            System.out.println(e);
            return null;
        }finally{
            em.close();
        }
        
    }

    @Override
    public List<Residente> findAllEgresados() {
    
         EntityManager em = emf.createEntityManager();
        try {
            return em.createNamedQuery("Residente.findAllEgresados", Residente.class).getResultList();
        } catch (Exception e) {
            System.out.println(e);
            return null;
        }finally{
            em.close();
        }
    
    }

}
