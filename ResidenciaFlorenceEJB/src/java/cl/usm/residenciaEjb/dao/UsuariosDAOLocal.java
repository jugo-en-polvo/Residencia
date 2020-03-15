package cl.usm.residenciaEjb.dao;

import cl.usm.residenciaEjb.dto.Usuario;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author Esteban
 */
@Local
public interface UsuariosDAOLocal {
    void add(Usuario usuario);
    List<Usuario> findAll();
    List<Usuario> findAllByEstado(int estado);
    List<Usuario> findAllByNivelAcceso();
    Usuario findByRutYClave(String rut, String clave);
    Usuario find(String rut);

}
