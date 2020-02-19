/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cl.usm.residenciaEjb.dao;

import cl.usm.residenciaEjb.dto.Prevision;
import java.util.List;
import javax.ejb.Local;

@Local
public interface PrevisionDAOLocal {
    
    Prevision find(long id);
    List<Prevision> findAll();
    void add(Prevision p);
    
}
