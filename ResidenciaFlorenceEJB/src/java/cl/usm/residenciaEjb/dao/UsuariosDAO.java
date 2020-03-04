package cl.usm.residenciaEjb.dao;

import cl.usm.residenciaEjb.dto.Usuario;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/**
 *
 * @author Esteban
 */
@Stateless
public class UsuariosDAO implements UsuariosDAOLocal {

    private EntityManagerFactory emf = Persistence.createEntityManagerFactory("ResidenciaFlorenceEJBPU");
    
    @Override
    public void add(Usuario usuario) {
        EntityManager em = this.emf.createEntityManager();
        try{
            em.persist(usuario);
            em.flush();
        }catch(Exception ex){
            
        }finally{
            em.close();
        }
    }

    @Override
    public List<Usuario> findAll() {
        EntityManager em = this.emf.createEntityManager();
        try{
            return em.createNamedQuery("Usuario.findAll", Usuario.class)
                    .getResultList();
        }catch(Exception ex){
            return null;
        }finally{
            em.close();
        }
    }

    @Override
    public Usuario findByRutYClave(String rut, String clave) {
        EntityManager em = this.emf.createEntityManager();
        try{
            return em.createNamedQuery("Usuario.findByRutYClave", Usuario.class)
                    .setParameter("rut", rut).setParameter("clave", clave)
                    .getSingleResult();
        }catch(Exception ex){
            return null;
        }finally{
            em.close();
        }
    }
}