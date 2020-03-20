/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cl.usm.residenciaFlorenceWar.beans;

import cl.usm.residenciaEjb.dao.PrevisionNombreTipoDAOLocal;
import cl.usm.residenciaEjb.dto.Prevision;
import cl.usm.residenciaEjb.dto.PrevisionNombreTipo;
import java.io.IOException;
import javax.inject.Named;
import javax.enterprise.context.SessionScoped;
import java.io.Serializable;
import java.util.List;
import javax.faces.context.FacesContext;
import javax.inject.Inject;

/**
 *
 * @author Senpai
 */
@Named(value = "verPrevisionManagedBean")
@SessionScoped
public class VerPrevisionManagedBean implements Serializable {

    @Inject
    private PrevisionNombreTipoDAOLocal previsionNombreDAO;
    @Inject
    private ActualizarNombreTipoPrevisionManagedBean actualizarNombreTipoPrevisionBEAN;
    
    private Prevision previsionDetalle;

    public Prevision getPrevisionDetalle() {
        return previsionDetalle;
    }

    public void setPrevisionDetalle(Prevision previsionDetalle) {
        this.previsionDetalle = previsionDetalle;
    }
    
    public VerPrevisionManagedBean() {
    }
    
    public List<PrevisionNombreTipo> obtenetListaEspecifica(){
        return this.previsionNombreDAO.findByTipo(previsionDetalle.getId_prevision());
    }
    
    public void editar(PrevisionNombreTipo p) throws IOException{
        
        this.actualizarNombreTipoPrevisionBEAN.setPrevisionNombreTipoActualizado(p);
        this.actualizarNombreTipoPrevisionBEAN.setIdPrevision(Long.toString(p.getPrevision().getId_prevision()));
        FacesContext.getCurrentInstance().getExternalContext().redirect("actualizar_nombre_tipo_prevision.xhtml");
        
    }
    
}
