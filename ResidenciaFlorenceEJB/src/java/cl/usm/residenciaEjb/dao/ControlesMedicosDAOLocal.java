/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cl.usm.residenciaEjb.dao;

import cl.usm.residenciaEjb.dto.Control_Medico;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author Senpai
 */
@Local
public interface ControlesMedicosDAOLocal {
    
    List<Control_Medico> findAll();
    List<Control_Medico> findByRut(String rut);
    void add(Control_Medico cm);
    
}
