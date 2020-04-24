/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cl.usm.residenciaFlorenceWar.beans;

import cl.usm.residenciaEjb.dao.Administrar_MedicamentoDAOLocal;
import cl.usm.residenciaEjb.dto.Administrar_Medicamento;
import java.io.Serializable;
import java.util.List;
import javax.inject.Named;
import javax.faces.view.ViewScoped;
import javax.inject.Inject;

/**
 *
 * @author Senpai
 */
@Named(value = "listarMedicacionManagedBean")
@ViewScoped
public class ListarMedicacionManagedBean implements Serializable{

    @Inject
    private Administrar_MedicamentoDAOLocal medicacionDAO;
    private List<Administrar_Medicamento> medicaciones;
    private String rutResidente;

    public List<Administrar_Medicamento> getMedicaciones() {
        return medicaciones;
    }

    public void setMedicaciones(List<Administrar_Medicamento> medicaciones) {
        this.medicaciones = medicaciones;
    }

    public String getRutResidente() {
        return rutResidente;
    }

    public void setRutResidente(String rutResidente) {
        this.rutResidente = rutResidente;
    }
    
    public ListarMedicacionManagedBean() {
    }
    
     public void filtroDieta(){
        
         if(rutResidente != null && !rutResidente.equals("")){
            this.medicaciones = medicacionDAO.findByRut(rutResidente);
        }else{
            
        }
        
    }
    
     public String verificarEstado(Administrar_Medicamento am){
        
        if(am.isEstado()){
            return "Consumido";
        }else{
            return "No Consumido";
        }
        
    }
     
}
