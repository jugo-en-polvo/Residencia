/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cl.usm.residenciaFlorenceWar.beans;

import cl.usm.residenciaEjb.dao.PrevisionDAOLocal;
import cl.usm.residenciaEjb.dto.Prevision;
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
@Named(value = "actualizarPrevisionManagedBean")
@SessionScoped
public class ActualizarPrevisionManagedBean implements Serializable {

    @Inject
    private PrevisionDAOLocal previsionDAO;
    @Inject
    private ListarPrevisionesManagedBean listarPrevisionesBEAN;
    
    private Prevision previsionActualizado;

    public Prevision getPrevisionActualizado() {
        return previsionActualizado;
    }

    public void setPrevisionActualizado(Prevision previsionActualizado) {
        this.previsionActualizado = previsionActualizado;
    }
    
    public ActualizarPrevisionManagedBean() {
    }
    
    public void update() throws IOException{
        
        this.previsionDAO.update(previsionActualizado);
        FacesContext.getCurrentInstance().getExternalContext().redirect("listar_previsiones.xhtml");
        
    }
    
}
