/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cl.usm.residenciaFlorenceWar.beans;

import cl.usm.residenciaEjb.dao.DiagnosticoDAOLocal;
import cl.usm.residenciaEjb.dao.ResidenteDAOLocal;
import cl.usm.residenciaEjb.dto.Diagnostico;
import java.io.IOException;
import java.io.Serializable;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.faces.event.ActionEvent;
import javax.inject.Named;
import javax.faces.view.ViewScoped;
import javax.inject.Inject;

/**
 *
 * @author Senpai
 */
@Named(value = "agregarDiagnosticoManagedBean")
@ViewScoped
public class AgregarDiagnosticoManagedBean implements Serializable{

    @Inject
    private DiagnosticoDAOLocal diagnosticoDAO;
    @Inject
    private ResidenteDAOLocal residenteDAO;
    private String rutResidente;
    private String enfermedad;
    private String Descripcion;

    public String getRutResidente() {
        return rutResidente;
    }

    public void setRutResidente(String rutResidente) {
        this.rutResidente = rutResidente;
    }

    public String getEnfermedad() {
        return enfermedad;
    }

    public void setEnfermedad(String enfermedad) {
        this.enfermedad = enfermedad;
    }

    public String getDescripcion() {
        return Descripcion;
    }

    public void setDescripcion(String Descripcion) {
        this.Descripcion = Descripcion;
    }
    
    public AgregarDiagnosticoManagedBean() {
    }
    
    public void add(ActionEvent e) throws IOException{
        
        Diagnostico d = new Diagnostico();
        d.setResidente(residenteDAO.find(rutResidente));
        d.setEnfermedad(enfermedad);
        d.setDescripcion(Descripcion);
        diagnosticoDAO.add(d);
        
        FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Diagnostico Agregado"));

        
    }
    
}
