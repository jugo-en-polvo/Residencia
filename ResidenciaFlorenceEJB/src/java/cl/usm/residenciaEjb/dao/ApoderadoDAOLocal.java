/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cl.usm.residenciaEjb.dao;

import cl.usm.residenciaEjb.dto.Apoderado;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author Senpai
 */
@Local
public interface ApoderadoDAOLocal {
    
    Apoderado find(String rut);
    List<Apoderado> findAll();
    void add(Apoderado a);
    
}
