/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cl.usm.residenciaEjb.dao;

import cl.usm.residenciaEjb.dto.PrevisionNombreTipo;
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
public class PrevisionNombreTipoDAO implements PrevisionNombreTipoDAOLocal {

    private final EntityManagerFactory emf = Persistence.createEntityManagerFactory("ResidenciaFlorenceEJBPU");

    @Override
    public List<PrevisionNombreTipo> findByTipo(long id) {

        EntityManager em = emf.createEntityManager();
        try {
            return em.createNamedQuery("PrevisionNombreTipo.findByTipo", PrevisionNombreTipo.class)
                    .setParameter("tipoPrevision", id)
                    .getResultList();
        } catch (Exception e) {
            System.out.println(e);
            return null;
        } finally {
            em.close();
        }

    }

    @Override
    public PrevisionNombreTipo find(long id) {

        EntityManager em = emf.createEntityManager();
        try {
            return em.find(PrevisionNombreTipo.class, id);
        } catch (Exception e) {
            System.out.println(e);
            return null;
        } finally {
            em.close();
        }
    }

    @Override
    public void add(PrevisionNombreTipo p) {

        EntityManager em = emf.createEntityManager();
        try {
            p.setPrevision(em.merge(p.getPrevision()));
            em.persist(p);
        } catch (Exception e) {
            System.out.println(e);
        } finally {
            em.close();
        }

    }

    @Override
    public void update(PrevisionNombreTipo p) {

        EntityManager em = emf.createEntityManager();
        try {
            em.merge(p);
        } catch (Exception e) {
            System.out.println(e);
        } finally {
            em.close();
        }

    }

}
