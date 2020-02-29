/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cl.usm.residenciaFlorenceWar.beans;

import cl.usm.residenciaEjb.dao.ControlesMedicosDAOLocal;
import cl.usm.residenciaEjb.dao.LugarDAOLocal;
import cl.usm.residenciaEjb.dao.ResidenteDAOLocal;
import cl.usm.residenciaEjb.dto.Control_Medico;
import java.io.Serializable;
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
@Named(value = "agregarControlMedicoManagedBean")
@ViewScoped
public class AgregarControlMedicoManagedBean implements Serializable{
    
    @Inject
    private ControlesMedicosDAOLocal controlesMedicosDAO;
    @Inject
    private ResidenteDAOLocal residenteDAO;
    @Inject
    private LugarDAOLocal lugarDAO;
    private String rut_residente;
    private Date fecha_hora_contro;
    private String estado;
    //Convertir despues a long
    private String id_lugar;
    private String observaciones;

    public String getRut_residente() {
        return rut_residente;
    }

    public void setRut_residente(String rut_residente) {
        this.rut_residente = rut_residente;
    }

    public Date getFecha_hora_contro() {
        return fecha_hora_contro;
    }

    public void setFecha_hora_contro(Date fecha_hora_contro) {
        this.fecha_hora_contro = fecha_hora_contro;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public String getId_lugar() {
        return id_lugar;
    }

    public void setId_lugar(String id_lugar) {
        this.id_lugar = id_lugar;
    }

    public String getObservaciones() {
        return observaciones;
    }

    public void setObservaciones(String observaciones) {
        this.observaciones = observaciones;
    }
    
    public AgregarControlMedicoManagedBean() {
    }
    
    public void agregar(ActionEvent e){
        
        Control_Medico cm = new Control_Medico();
        cm.setResidente(residenteDAO.find(rut_residente));
        
        Calendar fechaHoraControlConvertida = Calendar.getInstance();
        fechaHoraControlConvertida.setTime(fecha_hora_contro);
        cm.setFecha_hora_control(fechaHoraControlConvertida);
        
        cm.setLugar(lugarDAO.find(Long.parseLong(id_lugar)));
        cm.setEstado_control("N");
        cm.setObservaciones(observaciones);
        
        controlesMedicosDAO.add(cm);
        
        FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Control Agregardo"));
        
    }
    
}
