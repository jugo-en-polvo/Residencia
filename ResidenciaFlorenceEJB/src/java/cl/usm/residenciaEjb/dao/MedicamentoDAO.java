/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cl.usm.residenciaEjb.dao;

import cl.usm.residenciaEjb.dto.Medicamento;
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
public class MedicamentoDAO implements MedicamentoDAOLocal {

    private final EntityManagerFactory emf = Persistence.createEntityManagerFactory("ResidenciaFlorenceEJBPU");
    
    @Override
    public List<Medicamento> findAll() {
    
        EntityManager em = emf.createEntityManager();
        try {
            return em.createNamedQuery("Medicamento.findAll", Medicamento.class).getResultList();
        } catch (Exception e) {
            System.out.println(e);
            return null;
        }finally{
            em.close();
        }
    }

    @Override
    public void add(Medicamento m) {
    
        EntityManager em = emf.createEntityManager();
        try {
            em.persist(m);
        } catch (Exception e) {
            
        }finally{
            em.close();
        }
    
    }

    @Override
    public Medicamento find(long id) {
        
        EntityManager em = emf.createEntityManager();
        try {
            return em.find(Medicamento.class, id);
        } catch (Exception e) {
            System.out.println(e);
            return null;
        }finally{
            em.close();
        }
        
    }

    @Override
    public void update(Medicamento m) {
    
        EntityManager em = emf.createEntityManager();
        try {
            em.merge(m);
        } catch (Exception e) {
            System.out.println(e);
        }finally{
            em.close();
        }
    
    }

    
    
}
