/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cl.usm.residenciaEjb.dao;

import cl.usm.residenciaEjb.dto.Lugar;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author Senpai
 */
@Local
public interface LugarDAOLocal {
    
    List<Lugar> findAll();
    Lugar find(long id);
    void add(Lugar l);
    void update(Lugar l);
    void delete(Long id);
    
}
