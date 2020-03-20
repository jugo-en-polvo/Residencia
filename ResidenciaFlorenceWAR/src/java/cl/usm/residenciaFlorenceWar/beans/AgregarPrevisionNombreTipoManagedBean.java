/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cl.usm.residenciaFlorenceWar.beans;

import cl.usm.residenciaEjb.dao.PrevisionDAOLocal;
import cl.usm.residenciaEjb.dao.PrevisionNombreTipoDAOLocal;
import cl.usm.residenciaEjb.dto.PrevisionNombreTipo;
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
@Named(value = "agregarPrevisionNombreTipoManagedBean")
@ViewScoped
public class AgregarPrevisionNombreTipoManagedBean implements Serializable{

    @Inject
    private PrevisionNombreTipoDAOLocal previsionNombreTipoDAO;
    @Inject
    private PrevisionDAOLocal previsionDAO;
    
    private String nombreTipoPrevision;
    private String descripcion;
    private String idPrevision;

    public String getNombreTipoPrevision() {
        return nombreTipoPrevision;
    }

    public void setNombreTipoPrevision(String nombreTipoPrevision) {
        this.nombreTipoPrevision = nombreTipoPrevision;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getIdPrevision() {
        return idPrevision;
    }

    public void setIdPrevision(String idPrevision) {
        this.idPrevision = idPrevision;
    }
    
    public AgregarPrevisionNombreTipoManagedBean() {
    }
    
    public void add(ActionEvent e){
        
        PrevisionNombreTipo p = new PrevisionNombreTipo();
        p.setNombre_prevision(nombreTipoPrevision);
        p.setDescripcion(descripcion);
        p.setPrevision(this.previsionDAO.find(Long.parseLong(idPrevision)));
        
        this.previsionNombreTipoDAO.add(p);
        FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Tipo de previsión agregarda"));
    }
    
}
