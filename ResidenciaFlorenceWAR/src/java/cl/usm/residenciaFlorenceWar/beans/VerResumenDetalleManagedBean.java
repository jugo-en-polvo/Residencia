/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cl.usm.residenciaFlorenceWar.beans;

import cl.usm.residenciaEjb.dto.Diagnostico;
import cl.usm.residenciaEjb.dto.Emergencia;
import cl.usm.residenciaEjb.dto.Residente;
import cl.usm.residenciaEjb.dto.Tratamiento;
import java.io.IOException;
import javax.inject.Named;
import javax.enterprise.context.SessionScoped;
import java.io.Serializable;
import java.util.List;
import javax.faces.context.FacesContext;

/**
 *
 * @author Senpai
 */
@Named(value = "verResumenDetalleManagedBean")
@SessionScoped
public class VerResumenDetalleManagedBean implements Serializable {

    private Residente residenteDetalle;
    private List<Tratamiento> tratamientos;
    private List<Diagnostico> diagnosticos;
    private List<Emergencia> emergencias;

    public List<Emergencia> getEmergencias() {
        return emergencias;
    }

    public void setEmergencias(List<Emergencia> emergencias) {
        this.emergencias = emergencias;
    }

    public List<Tratamiento> getTratamientos() {
        return tratamientos;
    }

    public void setTratamientos(List<Tratamiento> tratamientos) {
        this.tratamientos = tratamientos;
    }

    public List<Diagnostico> getDiagnosticos() {
        return diagnosticos;
    }

    public void setDiagnosticos(List<Diagnostico> diagnosticos) {
        this.diagnosticos = diagnosticos;
    }

    public Residente getResidenteDetalle() {
        return residenteDetalle;
    }

    public void setResidenteDetalle(Residente residenteDetalle) {
        this.residenteDetalle = residenteDetalle;
    }

    public VerResumenDetalleManagedBean() {
    }

    public String determinaSexo(String s) {
        if (s.equals("M")) {
            return "Masculino";
        } else if (s.equals("F")) {
            return "Femenino";
        }
        return "";
    }

    public String determinaAlergia(String a) {
        if (a.equals("")) {
            return "Sin Registros";
        } else {
            return a;
        }
    }

    public String determinaObservacion(String o) {
        if (o.equals("")) {
            return "Sin Registros";
        } else {
            return o;
        }
    }
    
    public void atras() throws IOException{
        FacesContext.getCurrentInstance().getExternalContext().redirect("resumen_residente.xhtml");
    }

}
