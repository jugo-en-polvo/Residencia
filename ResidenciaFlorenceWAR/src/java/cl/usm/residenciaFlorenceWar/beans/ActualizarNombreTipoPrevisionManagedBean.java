/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cl.usm.residenciaFlorenceWar.beans;

import cl.usm.residenciaEjb.dao.PrevisionDAO;
import cl.usm.residenciaEjb.dao.PrevisionDAOLocal;
import cl.usm.residenciaEjb.dao.PrevisionNombreTipoDAOLocal;
import cl.usm.residenciaEjb.dto.PrevisionNombreTipo;
import java.io.IOException;
import javax.inject.Named;
import javax.enterprise.context.SessionScoped;
import java.io.Serializable;
import javax.faces.context.FacesContext;
import javax.inject.Inject;

/**
 *
 * @author Senpai
 */
@Named(value = "actualizarNombreTipoPrevisoiinManagedBean")
@SessionScoped
public class ActualizarNombreTipoPrevisionManagedBean implements Serializable {

    @Inject
    private PrevisionNombreTipoDAOLocal previsionNombreTipoDAO;
    @Inject
    private PrevisionDAOLocal previsionDAO;
    @Inject
    private VerPrevisionManagedBean verPrevisionBEAN;
    
    private PrevisionNombreTipo previsionNombreTipoActualizado;
    private String idPrevision;

    public String getIdPrevision() {
        return idPrevision;
    }

    public void setIdPrevision(String idPrevision) {
        this.idPrevision = idPrevision;
    }

    public PrevisionNombreTipo getPrevisionNombreTipoActualizado() {
        return previsionNombreTipoActualizado;
    }

    public void setPrevisionNombreTipoActualizado(PrevisionNombreTipo previsionNombreTipoActualizado) {
        this.previsionNombreTipoActualizado = previsionNombreTipoActualizado;
    }
    
    public ActualizarNombreTipoPrevisionManagedBean() {
    }
    
    public void update() throws IOException{
        
        this.previsionNombreTipoActualizado.setPrevision(previsionDAO.find(Long.parseLong(idPrevision)));
        this.previsionNombreTipoDAO.update(previsionNombreTipoActualizado);
        
        this.verPrevisionBEAN.setPrevisionDetalle(previsionDAO.find(Long.parseLong(idPrevision)));
        FacesContext.getCurrentInstance().getExternalContext().redirect("ver_prevision_detalle.xhtml");
        
        
    }
    
}
