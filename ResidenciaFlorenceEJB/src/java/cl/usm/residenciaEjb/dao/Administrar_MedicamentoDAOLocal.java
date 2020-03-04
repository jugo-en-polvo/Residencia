/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cl.usm.residenciaEjb.dao;

import cl.usm.residenciaEjb.dto.Administrar_Medicamento;
import java.util.Calendar;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author Senpai
 */
@Local
public interface Administrar_MedicamentoDAOLocal {
    
    void add(Administrar_Medicamento am);
    void update(Administrar_Medicamento am);
    Administrar_Medicamento findByCompositeKey(Calendar fecha, long id);
    List<Administrar_Medicamento> findByRut(String rut);
    List<Administrar_Medicamento> findByRutAndFecha(String rut, Calendar fecha);
    
}
