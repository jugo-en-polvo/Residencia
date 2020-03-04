/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cl.usm.residenciaEjb.dao;

import cl.usm.residenciaEjb.dto.Administrar_Medicamento;
import cl.usm.residenciaEjb.dto.Administrar_MedicamentoID;
import java.util.Calendar;
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
public class Administrar_MedicamentoDAO implements Administrar_MedicamentoDAOLocal {

    private final EntityManagerFactory emf = Persistence.createEntityManagerFactory("ResidenciaFlorenceEJBPU");
    
    @Override
    public void add(Administrar_Medicamento am) {
    
        EntityManager em = emf.createEntityManager();
        try {
            em.persist(am);
        } catch (Exception e) {
            System.out.println(e);
        }finally{
            em.close();
        }
    
    }

    @Override
    public Administrar_Medicamento findByCompositeKey(Calendar fecha, long id) {
    
        EntityManager em = emf.createEntityManager();
        try {
            
            Administrar_MedicamentoID compositeKey = new Administrar_MedicamentoID(id, fecha);
            return em.find(Administrar_Medicamento.class, compositeKey);
            
        } catch (Exception e) {
            System.out.println(e);
            return null;
        }finally{
            em.close();
        }
        
    }

    @Override
    public void update(Administrar_Medicamento am) {
    
        EntityManager em = emf.createEntityManager();
        
        try {
            em.merge(am);
        } catch (Exception e) {
            System.out.println(e);
        }finally{
            em.close();
        }
        
    }

    @Override
    public List<Administrar_Medicamento> findByRut(String rut) {
    
        EntityManager em = emf.createEntityManager();
        try {
            return em.createNamedQuery("AdministratMedicamento.findByRut", Administrar_Medicamento.class)
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
    public List<Administrar_Medicamento> findByRutAndFecha(String rut, Calendar fecha) {
    
        EntityManager em = emf.createEntityManager();
        try {
            
            return em.createNamedQuery("AdministrarMedicamento.findByRutAndFecha", Administrar_Medicamento.class)
                    .setParameter("rut", rut)
                    .setParameter("fecha", fecha)
                    .getResultList();
            
        } catch (Exception e) {
            System.out.println(e);
            return null;
        }finally{
            em.close();
        }
    
    }

 
}
