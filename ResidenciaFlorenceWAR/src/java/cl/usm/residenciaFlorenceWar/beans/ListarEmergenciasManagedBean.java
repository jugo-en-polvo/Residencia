/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cl.usm.residenciaFlorenceWar.beans;

import cl.usm.residenciaEjb.dao.EmergenciaDAOLocal;
import cl.usm.residenciaEjb.dto.Emergencia;
import java.io.Serializable;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.inject.Named;
import javax.faces.view.ViewScoped;
import javax.inject.Inject;

/**
 *
 * @author Senpai
 */
@Named(value = "listarEmergenciasManagedBean")
@ViewScoped
public class ListarEmergenciasManagedBean implements Serializable {

    @Inject
    private EmergenciaDAOLocal emergenciaDAO;

    private List<Emergencia> emergencias;
    private String rutResidente;
    private String periodo;

    public String getRutResidente() {
        return rutResidente;
    }

    public void setRutResidente(String rutResidente) {
        this.rutResidente = rutResidente;
    }

    public List<Emergencia> getEmergencias() {
        return emergencias;
    }

    public void setEmergencias(List<Emergencia> emergencias) {
        this.emergencias = emergencias;
    }

    public ListarEmergenciasManagedBean() {
    }

    public String getPeriodo() {
        return periodo;
    }

    public void setPeriodo(String periodo) {
        this.periodo = periodo;
    }

    public void filtroEmergencia() {

        if (rutResidente != null && !rutResidente.equals("")) {
            this.emergencias = this.emergenciaDAO.FindAllByRut(rutResidente);
        } else {
            this.emergencias.clear();
        }

    }

    public void filtroEmergenciaPeriodo() {

        switch (periodo) {
            case "todos":
                FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("todos"));
                break;
            case "semana":
                FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("semana"));
                break;
            case "mes":
                FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("mes"));
                break;
            default:
                break;
        }

    }

}
