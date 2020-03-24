/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cl.usm.residenciaFlorenceWar.beans;

import cl.usm.residenciaEjb.dao.ControlDAOLocal;
import cl.usm.residenciaEjb.dao.ControlesMedicosDAOLocal;
import cl.usm.residenciaEjb.dto.Control;
import java.io.Serializable;
import java.util.List;
import javax.inject.Named;
import javax.faces.view.ViewScoped;
import javax.inject.Inject;

/**
 *
 * @author Senpai
 */
@Named(value = "listaControlesManagedBean")
@ViewScoped
public class ListaControlesManagedBean implements Serializable{

    @Inject
    private ControlDAOLocal controlDAO;
    
    private List<Control> controles;
    private String rutResidente;

    public List<Control> getControles() {
        return controles;
    }

    public void setControles(List<Control> controles) {
        this.controles = controles;
    }

    public String getRutResidente() {
        return rutResidente;
    }

    public void setRutResidente(String rutResidente) {
        this.rutResidente = rutResidente;
    }
    
    public ListaControlesManagedBean() {
    }
    
    public void manejarFiltro() {

        if (!rutResidente.equals("falso")) {
            this.controles = controlDAO.findByRut(rutResidente);
        } else {
            this.controles.clear();
        }

    }
    
    public boolean renderPresion(Control c){
        return !c.getPresion_arterial().equals("");
    }
    
    public boolean renderPulso(Control c){
        return !c.getPulso().equals("");
    }
    
   public boolean renderSaturacion(Control c){
        return !c.getSaturacion().equals("");
    } 
   
   public boolean renderHGT(Control c){
        return !c.getHgt().equals("");
    }
   
   public boolean renderCambioPosicion(Control c){
        return !c.getCambio_posicion().equals("");
    }
   
    public boolean renderSolucionParenteral(Control c){
        return !c.getSolucion_parenteral().equals("");
    }
    
     public boolean renderSuero(Control c){
        return !c.getSuero().equals("");
    }
     
     public String determinaObservacion(Control c){
         if(c.getObservaciones().equals("")){
             return "Sin Observaciones.";
         }else{
             return c.getObservaciones();
         }
     }
    
}
