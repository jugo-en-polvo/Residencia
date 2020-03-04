/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cl.usm.residenciaEjb.dao;

import cl.usm.residenciaEjb.dto.Diagnostico;
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
public class DiagnosticoDAO implements DiagnosticoDAOLocal {

    private final EntityManagerFactory emf = Persistence.createEntityManagerFactory("ResidenciaFlorenceEJBPU");
    
    @Override
    public List<Diagnostico> findByRut(String rut) {
    
        EntityManager em = emf.createEntityManager();
        try {
            return em.createNamedQuery("Diagnostico.findByRut", Diagnostico.class)
                    .setParameter("rut", rut)
                    .getResultList();
        } catch (Exception e) {
            System.out.println(e);
            return null;
        }finally{
            em.close();
        }
        
    }

    @Override
    public void add(Diagnostico d) {
    
        EntityManager em = emf.createEntityManager();
        try {
            em.persist(d);
        } catch (Exception e) {
            System.out.println(e);
        }finally{
            em.close();
        }
        
    }
    
}
