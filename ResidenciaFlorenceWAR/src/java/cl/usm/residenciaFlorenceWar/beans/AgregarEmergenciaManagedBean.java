/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cl.usm.residenciaFlorenceWar.beans;

import cl.usm.residenciaEjb.dao.EmergenciaDAOLocal;
import cl.usm.residenciaEjb.dao.LugarDAO;
import cl.usm.residenciaEjb.dao.LugarDAOLocal;
import cl.usm.residenciaEjb.dao.ResidenteDAOLocal;
import cl.usm.residenciaEjb.dto.Emergencia;
import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.Calendar;
import java.util.Date;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.faces.event.ActionEvent;
import javax.inject.Named;
import javax.faces.view.ViewScoped;
import javax.inject.Inject;

/**
 *
 * @author Senpai
 */
@Named(value = "agregarEmergenciaManagedBean")
@ViewScoped
public class AgregarEmergenciaManagedBean implements Serializable{

    @Inject
    private EmergenciaDAOLocal emergenciaDAO;
    @Inject
    private ResidenteDAOLocal residenteDAO;
    @Inject
    private LugarDAOLocal lugarDAO;
    private String rut_residente;
    private Date fecha_emergencia;
    private long id_lugar;
    private String observaciones;

    public String getRut_residente() {
        return rut_residente;
    }

    public void setRut_residente(String rut_residente) {
        this.rut_residente = rut_residente;
    }

    public Date getFecha_emergencia() {
        return fecha_emergencia;
    }

    public void setFecha_emergencia(Date fecha_emergencia) {
        this.fecha_emergencia = fecha_emergencia;
    }

    public long getId_lugar() {
        return id_lugar;
    }

    public void setId_lugar(long id_lugar) {
        this.id_lugar = id_lugar;
    }

    public String getObservaciones() {
        return observaciones;
    }

    public void setObservaciones(String observaciones) {
        this.observaciones = observaciones;
    }
    
    public AgregarEmergenciaManagedBean() {
    }
    
    public void add(ActionEvent e){
        
        Emergencia emer = new Emergencia();
        
        Calendar fechaEmergenciaConvertida = Calendar.getInstance();
        fechaEmergenciaConvertida.setTime(fecha_emergencia);
        emer.setFecha_emergencia(fechaEmergenciaConvertida);
        
        emer.setResidente(residenteDAO.find(rut_residente));
        emer.setLugar(lugarDAO.find(id_lugar));
        emer.setObservaciones(observaciones);
        
        emergenciaDAO.add(emer);
        
        FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Emergencia Registrada"));
        
    }
    
}
