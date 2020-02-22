/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cl.usm.residenciaFlorenceWar.beans;

import cl.usm.residenciaEjb.dao.ApoderadoDAOLocal;
import cl.usm.residenciaEjb.dao.PrevisionDAOLocal;
import cl.usm.residenciaEjb.dao.ResidenteDAOLocal;
import cl.usm.residenciaEjb.dto.Apoderado;
import cl.usm.residenciaEjb.dto.Residente;
import java.io.Serializable;
import java.util.Calendar;
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
@Named(value = "agregarResidenteApoderadoManagedBean")
@ViewScoped
public class AgregarResidenteApoderadoManagedBean implements Serializable{

    @Inject
    private ResidentesManagedBean residenteBean;
    @Inject
    private AgregarApoderadoManagedBean apoderadoBean;
    @Inject
    private ResidenteDAOLocal residenteDAO;
    @Inject
    private ApoderadoDAOLocal apoderadosDAO;
    @Inject
    private PrevisionDAOLocal previsionDAO;
    
    public AgregarResidenteApoderadoManagedBean() {
    }
    
    public void agregar(ActionEvent e){
        
        Residente r = new Residente();
        Apoderado a = new Apoderado();
        
        //Apoderado
        a.setRut_apoderado(apoderadoBean.getRutApoderado());
        a.setNombre_apoderado(apoderadoBean.getNombreApoderado());
        a.setFono_apoderado(apoderadoBean.getFonoApoderado());
        a.setDireccion_apoderado(apoderadoBean.getDireccionApoderado());
        
        this.apoderadosDAO.add(a);
        
        //Residente
        r.setRut_residente(residenteBean.getRutResidente());
        r.setNombre_residente(residenteBean.getNombre());
        
        Calendar fechaNacimientoConvertida = Calendar.getInstance();
        fechaNacimientoConvertida.setTime(residenteBean.getFechaNacimieto());
        r.setFecha_nacimiento(fechaNacimientoConvertida);
        
        Calendar fechaIngresoConvertida = Calendar.getInstance();
        fechaIngresoConvertida.setTime(residenteBean.getFechaIngreso());
        r.setFecha_ingreso(fechaIngresoConvertida);
        
        r.setSexo(residenteBean.getSexo());
        r.setEstado("V");
        r.setApoderado(apoderadosDAO.find(apoderadoBean.getRutApoderado()));
        r.setPrecision(this.previsionDAO.find(residenteBean.getIdPrevision()));
        this.residenteDAO.add(r);
                
        FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Residente y Apoderado ingresados"));
        
    }
    
    public void actualizarResidente(){
        residenteBean.setRutApoderado(apoderadoBean.getRutApoderado());
    }
    
}
