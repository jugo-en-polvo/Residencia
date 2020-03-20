/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cl.usm.residenciaFlorenceWar.beans;

import cl.usm.residenciaEjb.dao.LugarDAOLocal;
import cl.usm.residenciaEjb.dto.Lugar;
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
@Named(value = "actualizarLugarManagedBean")
@SessionScoped
public class ActualizarLugarManagedBean implements Serializable {

    @Inject
    private LugarDAOLocal lugarDAO;
    @Inject
    private VerLugarManagedBean verLugarBEAN;
    private Lugar lugarActualizado;

    public Lugar getLugarActualizado() {
        return lugarActualizado;
    }

    public void setLugarActualizado(Lugar lugarActualizado) {
        this.lugarActualizado = lugarActualizado;
    }
    
    public ActualizarLugarManagedBean() {
    }
    
    public void actualizar() throws IOException{
        
        this.lugarDAO.update(lugarActualizado);
        this.verLugarBEAN.setLugarDetalle(lugarActualizado);
        FacesContext.getCurrentInstance().getExternalContext().redirect("ver_lugar_detalle.xhtml");
        
    }
    
}
