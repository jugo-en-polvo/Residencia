/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cl.usm.residenciaEjb.dao;

import cl.usm.residenciaEjb.dto.Dieta;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author Senpai
 */
@Local
public interface DietaDAOLocal {
    
    void add(Dieta d);
    void update(Dieta d);
    List<Dieta> findAll();
    List<Dieta> findByRut(String rut);
    Dieta findByFecha(Date fecha);
    Dieta findByCompositeKey(Calendar fecha, String rut);
    void updateCena(Calendar fecha, String rut, boolean cena);
    
}
