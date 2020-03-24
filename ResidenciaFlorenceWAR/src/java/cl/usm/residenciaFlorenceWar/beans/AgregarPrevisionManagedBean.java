/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cl.usm.residenciaFlorenceWar.beans;

import cl.usm.residenciaEjb.dao.PrevisionDAOLocal;
import cl.usm.residenciaEjb.dto.Prevision;
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
@Named(value = "agregarPrevisionManagedBean")
@ViewScoped
public class AgregarPrevisionManagedBean implements Serializable{

    @Inject
    private PrevisionDAOLocal previsionDAO;
    private String nombrePrevision;
    private String descripcion;

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getNombrePrevision() {
        return nombrePrevision;
    }

    public void setNombrePrevision(String nombrePrevision) {
        this.nombrePrevision = nombrePrevision;
    }
     
    public AgregarPrevisionManagedBean() {
    }
    
    public void agregar(ActionEvent e) throws IOException{
        
        Prevision p = new Prevision();
        p.setTipo_prevision(nombrePrevision);
        p.setDescripcion(descripcion);
        this.previsionDAO.add(p);
        FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Prevision agregarda"));
        FacesContext.getCurrentInstance().getExternalContext().redirect("listar_previsiones.xhtml");
        
    }
}
