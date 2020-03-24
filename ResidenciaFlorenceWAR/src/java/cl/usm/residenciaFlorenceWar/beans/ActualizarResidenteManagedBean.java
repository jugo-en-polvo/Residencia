/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cl.usm.residenciaFlorenceWar.beans;

import cl.usm.residenciaEjb.dao.PrevisionNombreTipoDAOLocal;
import cl.usm.residenciaEjb.dao.ResidenteDAOLocal;
import cl.usm.residenciaEjb.dto.Residente;
import java.io.IOException;
import javax.inject.Named;
import javax.enterprise.context.SessionScoped;
import java.io.Serializable;
import java.util.Calendar;
import java.util.Date;
import javax.faces.context.FacesContext;
import javax.faces.event.ActionEvent;
import javax.inject.Inject;

/**
 *
 * @author Senpai
 */
@Named(value = "actualizarResidenteManagedBean")
@SessionScoped
public class ActualizarResidenteManagedBean implements Serializable {

    @Inject
    private ResidenteDAOLocal residenteDAO;
    @Inject
    private PrevisionNombreTipoDAOLocal previsionNombreTipoDAO;
    @Inject
    private ListarPrevisionesNombreTipoManagedBean listarPrevisionesNombreTipoBean;
    private Residente residenteActualizado;
    private Date fechaEgreso;
    private long idNombrePrevision;

    public long getIdNombrePrevision() {
        return idNombrePrevision;
    }

    public void setIdNombrePrevision(long idNombrePrevision) {
        this.idNombrePrevision = idNombrePrevision;
    }

    public Residente getResidenteActualizado() {
        return residenteActualizado;
    }

    public void setResidenteActualizado(Residente residenteActualizado) {
        this.residenteActualizado = residenteActualizado;
    }

    public Date getFechaEgreso() {
        return fechaEgreso;
    }

    public void setFechaEgreso(Date fechaEgreso) {
        this.fechaEgreso = fechaEgreso;
    }

    public ActualizarResidenteManagedBean() {
    }

    public void actualizarResidente(ActionEvent e) throws IOException {
        this.residenteActualizado.setPrevisionNombreTipo(previsionNombreTipoDAO.find(idNombrePrevision));
        this.residenteDAO.update(residenteActualizado);
        FacesContext.getCurrentInstance().getExternalContext().redirect("lista_residentes.xhtml");

    }

}
