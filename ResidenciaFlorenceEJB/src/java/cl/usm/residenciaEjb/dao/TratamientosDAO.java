/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cl.usm.residenciaEjb.dao;

import cl.usm.residenciaEjb.dto.Tratamiento;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.LockModeType;
import javax.persistence.Persistence;

/**
 *
 * @author Senpai
 */
@Stateless
public class TratamientosDAO implements TratamientosDAOLocal {

    private final EntityManagerFactory emf = Persistence.createEntityManagerFactory("ResidenciaFlorenceEJBPU");

    @Override
    public void add(Tratamiento t) {

        EntityManager em = emf.createEntityManager();
        try {

            t.setResidente(em.merge(t.getResidente()));
            t.setMedicamento(em.merge(t.getMedicamento()));
            em.persist(t);

        } catch (Exception e) {
            System.out.println(e);
        } finally {
            em.close();
        }

    }

    @Override
    public List<Tratamiento> findAll() {

        EntityManager em = emf.createEntityManager();
        try {
            return em.createNamedQuery("Tratamiento.findAll", Tratamiento.class).getResultList();
        } catch (Exception e) {
            System.out.println(e);
            return null;
        } finally {
            em.close();
        }

    }

    @Override
    public List<Tratamiento> findByRut(String rut) {

        EntityManager em = emf.createEntityManager();
        try {
            return em.createNamedQuery("Tratamiento.findByRut", Tratamiento.class)
                    .setParameter("rut", rut)
                    .getResultList();
        } catch (Exception e) {
            System.out.println(e);
            return null;
        } finally {
            em.close();
        }

    }

    @Override
    public boolean verExistencia(String rut, Long id, String hora) {

        EntityManager em = emf.createEntityManager();
        try {
            em.createNamedQuery("Tratamiento.VerExiste", Tratamiento.class)
                    .setParameter("rut", rut)
                    .setParameter("id", id)
                    .setParameter("hora", hora)
                    .getSingleResult();
            return true;
        } catch (Exception e) {
            System.out.println(e);
            return false;
        } finally {
            em.close();
        }

    }

}
