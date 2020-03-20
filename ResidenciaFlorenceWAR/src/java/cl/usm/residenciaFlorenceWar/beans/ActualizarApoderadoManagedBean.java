/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cl.usm.residenciaFlorenceWar.beans;

import cl.usm.residenciaEjb.dao.ApoderadoDAOLocal;
import cl.usm.residenciaEjb.dto.Apoderado;
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
@Named(value = "actualizarApoderadoManagedBean")
@SessionScoped
public class ActualizarApoderadoManagedBean implements Serializable {

    @Inject
    private ApoderadoDAOLocal apoderadoDAO; 
    @Inject
    private VerApoderadoManagedBean verApoderadoBEAN;
    private Apoderado apoderadoActualizado;

    public Apoderado getApoderadoActualizado() {
        return apoderadoActualizado;
    }

    public void setApoderadoActualizado(Apoderado apoderadoActualizado) {
        this.apoderadoActualizado = apoderadoActualizado;
    }
    
    public ActualizarApoderadoManagedBean() {
    }
    
    public void actualizar() throws IOException{
        
        this.apoderadoDAO.update(apoderadoActualizado);
        this.verApoderadoBEAN.setApoderadoDetalle(apoderadoActualizado);
        FacesContext.getCurrentInstance().getExternalContext().redirect("ver_apoderado_detalle.xhtml");
        
    }
    
}
