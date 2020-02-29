/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cl.usm.residenciaEjb.dao;

import cl.usm.residenciaEjb.dto.Control_Medico;
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
public class ControlesMedicosDAO implements ControlesMedicosDAOLocal {

    private final EntityManagerFactory emf = Persistence.createEntityManagerFactory("ResidenciaFlorenceEJBPU");
    
    @Override
    public List<Control_Medico> findAll() {
        
        EntityManager em = emf.createEntityManager();
        try {
            return em.createNamedQuery("Control_Medico.findAll", Control_Medico.class).getResultList();
        } catch (Exception e) {
            System.out.println(e);
            return null;
        }finally{
            em.close();
        }
    }

    @Override
    public List<Control_Medico> findByRut(String rut) {
    
        EntityManager em = emf.createEntityManager();
        try {
            return em.createNamedQuery("Control_Medico.findByRut", Control_Medico.class)
                    .setParameter("rut_residente", rut)
                    .getResultList();
        } catch (Exception e) {
            System.out.println(e);
            return null;
        }finally{
            em.close();
        }
        
    }

    @Override
    public void add(Control_Medico cm) {
    
        EntityManager em = emf.createEntityManager();
        try {
            cm.setResidente(em.merge(cm.getResidente()));
            cm.setLugar(em.merge(cm.getLugar()));
            em.persist(cm);
            em.flush();
        } catch (Exception e) {
            System.out.println(e);
        }finally{
            em.close();
        }
    }

    
}
