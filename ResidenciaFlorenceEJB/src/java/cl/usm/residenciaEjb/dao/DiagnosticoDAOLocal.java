/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cl.usm.residenciaEjb.dao;

import cl.usm.residenciaEjb.dto.Diagnostico;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author Senpai
 */
@Local
public interface DiagnosticoDAOLocal {
    
    List<Diagnostico> findByRut(String rut);
    void add(Diagnostico d);
    void update(Diagnostico d);
    
}
