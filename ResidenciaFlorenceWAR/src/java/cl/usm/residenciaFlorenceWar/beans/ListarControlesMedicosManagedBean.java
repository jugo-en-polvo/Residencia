/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cl.usm.residenciaFlorenceWar.beans;

import cl.usm.residenciaEjb.dao.ControlesMedicosDAOLocal;
import cl.usm.residenciaEjb.dto.Control_Medico;
import java.io.Serializable;
import java.util.List;
import javax.inject.Named;
import javax.faces.view.ViewScoped;
import javax.inject.Inject;

/**
 *
 * @author Senpai
 */
@Named(value = "listarControlesMedicosManagedBean")
@ViewScoped
public class ListarControlesMedicosManagedBean implements Serializable{

    @Inject
    private ControlesMedicosDAOLocal controlesMedicosDAO;
    
    private String rutResidente;
    private List<Control_Medico> controlesMedicos;

    public String getRutResidente() {
        return rutResidente;
    }

    public void setRutResidente(String rutResidente) {
        this.rutResidente = rutResidente;
    }

    public List<Control_Medico> getControlesMedicos() {
        return controlesMedicos;
    }

    public void setControlesMedicos(List<Control_Medico> controlesMedicos) {
        this.controlesMedicos = controlesMedicos;
    }
    
    public ListarControlesMedicosManagedBean() {
    }
    public void filtroControlMedico() {

        if (rutResidente != null && !rutResidente.equals("")) {
            this.controlesMedicos = this.controlesMedicosDAO.findByRut(rutResidente);
        } else {
            this.controlesMedicos.clear();
        }

    }
    
    public String DeterminaEstado(Control_Medico m){
        
        if(m.getEstado_control().equals("N")){
            return "NO REALIZADO";
        }else{
            return "REALIZADO";
        }
        
    }
    
}
