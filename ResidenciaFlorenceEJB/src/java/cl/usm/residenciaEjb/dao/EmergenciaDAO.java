/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cl.usm.residenciaEjb.dao;

import cl.usm.residenciaEjb.dto.Emergencia;
import cl.usm.residenciaEjb.dto.EmergenciaID;
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
public class EmergenciaDAO implements EmergenciaDAOLocal {

    private final EntityManagerFactory emf = Persistence.createEntityManagerFactory("ResidenciaFlorenceEJBPU");

    @Override
    public void add(Emergencia e) {

        EntityManager em = emf.createEntityManager();
        try {
            em.persist(e);
        } catch (Exception err) {
            System.out.println(err);
        } finally {
            em.close();
        }

    }

    @Override
    public List<Emergencia> findAll() {

        EntityManager em = emf.createEntityManager();
        try {
            return em.createNamedQuery("Emergencia.findAll", Emergencia.class).getResultList();
        } catch (Exception err) {
            System.out.println(err);
            return null;
        } finally {
            em.close();
        }

    }

    @Override
    public List<Emergencia> FindAllByRut(String rut) {

        EntityManager em = emf.createEntityManager();
        try {
            return em.createNamedQuery("Emergencia.findAllByRut", Emergencia.class)
                    .setParameter("rut", rut)
                    .getResultList();
        } catch (Exception err) {
            System.out.println(err);
            return null;
        } finally {
            em.close();
        }

    }

    @Override
    public void delete(Emergencia e) {
        EntityManager em = emf.createEntityManager();
        try {
            EmergenciaID compositeKey = new EmergenciaID(e.getFecha_emergencia(), e.getResidente().getRut_residente());
            em.remove(em.find(Emergencia.class, compositeKey));
        } catch (Exception err) {
            System.out.println(err);
        } finally {
            em.close();
        }
    }

}
