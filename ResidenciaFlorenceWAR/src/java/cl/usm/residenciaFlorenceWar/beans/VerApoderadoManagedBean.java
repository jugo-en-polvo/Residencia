package cl.usm.residenciaFlorenceWar.beans;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

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
@Named(value = "verApoderadoManagedBean")
@SessionScoped
public class VerApoderadoManagedBean implements Serializable {

    @Inject
    private ActualizarApoderadoManagedBean actualizarApoderadoBEAN;
    private Apoderado apoderadoDetalle;

    public Apoderado getApoderadoDetalle() {
        return apoderadoDetalle;
    }

    public void setApoderadoDetalle(Apoderado apoderadoDetalle) {
        this.apoderadoDetalle = apoderadoDetalle;
    }
    
    public VerApoderadoManagedBean() {
    }
    
    public void atras() throws IOException{
        FacesContext.getCurrentInstance().getExternalContext().redirect("listar_apoderados.xhtml");
    }
    
    public void editar() throws IOException{
        this.actualizarApoderadoBEAN.setApoderadoActualizado(apoderadoDetalle);
        FacesContext.getCurrentInstance().getExternalContext().redirect("actualizar_apoderado.xhtml");
    }
    
}
