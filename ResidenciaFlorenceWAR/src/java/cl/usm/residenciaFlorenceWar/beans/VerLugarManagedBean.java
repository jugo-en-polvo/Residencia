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
@Named(value = "verLugarManagedBean")
@SessionScoped
public class VerLugarManagedBean implements Serializable {

    @Inject
    private ActualizarLugarManagedBean actualizarLugarBEAN;
    @Inject
    private LugarDAOLocal lugarDAODAO;
    private Lugar lugarDetalle;

    public Lugar getLugarDetalle() {
        return lugarDetalle;
    }

    public void setLugarDetalle(Lugar lugarDetalle) {
        this.lugarDetalle = lugarDetalle;
    }

    public VerLugarManagedBean() {
    }

    public void atras() throws IOException {
        FacesContext.getCurrentInstance().getExternalContext().redirect("listar_lugares.xhtml");
    }

    public void editar() throws IOException {
        this.actualizarLugarBEAN.setLugarActualizado(lugarDetalle);
        FacesContext.getCurrentInstance().getExternalContext().redirect("actualizar_lugar.xhtml");
    }

    public void eliminar() throws IOException {
        if (lugarDetalle.getControlesMedicos().isEmpty() || lugarDetalle.getEmergencias().isEmpty()) {
            this.lugarDAODAO.delete(lugarDetalle.getId_lugar());
            FacesContext.getCurrentInstance().getExternalContext().redirect("listar_lugares.xhtml");
        } else {
            this.lugarDetalle.setEstado(false);
            this.lugarDAODAO.update(lugarDetalle);
            FacesContext.getCurrentInstance().getExternalContext().redirect("listar_lugares.xhtml");
        }
    }

}
