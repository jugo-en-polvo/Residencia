/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cl.usm.residenciaFlorenceWar.beans;

import cl.usm.residenciaEjb.dao.ResidenteDAOLocal;
import cl.usm.residenciaEjb.dto.Residente;
import java.io.IOException;
import java.io.Serializable;
import java.util.Calendar;
import java.util.Date;
import javax.enterprise.context.SessionScoped;
import javax.faces.context.FacesContext;
import javax.inject.Inject;
import javax.inject.Named;

/**
 *
 * @author Senpai
 */
@Named(value = "verResidenteManagedBean")
@SessionScoped
public class VerResidenteManagedBean implements Serializable{

    @Inject
    private ResidenteDAOLocal residenteDAO;
    
    private Residente residenteDetalle;

    public Residente getResidenteDetalle() {
        return residenteDetalle;
    }

    public void setResidenteDetalle(Residente residenteDetalle) {
        this.residenteDetalle = residenteDetalle;
    }
    
    public VerResidenteManagedBean() {
    }
    
    public void atras() throws IOException{
        FacesContext.getCurrentInstance().getExternalContext().redirect("lista_residentes.xhtml");
    }
    
     public String determinaSexo(String s) {
        if (s.equals("M")) {
            return "Masculino";
        } else if (s.equals("F")) {
            return "Femenino";
        }
        return "";
    }
     
      public String determinaAlergia(String a) {
        if (a.equals("")) {
            return "Sin Registros";
        } else {
            return a;
        }
    }

    public String determinaObservacion(String o) {
        if (o.equals("")) {
            return "Sin Registros";
        } else {
            return o;
        }
    }
    
}
