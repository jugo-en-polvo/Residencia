/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cl.usm.residenciaEjb.dao;

import cl.usm.residenciaEjb.dto.PrevisionNombreTipo;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author Senpai
 */
@Local
public interface PrevisionNombreTipoDAOLocal {
    
    void add(PrevisionNombreTipo p);
    List<PrevisionNombreTipo> findByTipo(long id);
    PrevisionNombreTipo find(long id);
    void update(PrevisionNombreTipo p);
    
}
