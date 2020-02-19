/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cl.usm.residenciaFlorenceWar.beans;

import cl.usm.residenciaEjb.dao.ApoderadoDAOLocal;
import cl.usm.residenciaEjb.dao.PrevisionDAOLocal;
import cl.usm.residenciaEjb.dao.ResidenteDAOLocal;
import cl.usm.residenciaEjb.dto.Apoderado_;
import cl.usm.residenciaEjb.dto.Residente;
import java.io.Serializable;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import javax.annotation.PostConstruct;
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
@Named(value = "residentesManagedBean")
@ViewScoped
public class ResidentesManagedBean implements Serializable{

    @Inject
    private ResidenteDAOLocal residenteDAO;
    @Inject
    private PrevisionDAOLocal previsionDAO;
    @Inject
    private ApoderadoDAOLocal apoderadoDAO;
    
    private List<Residente> residentes;
    //atributos de residentes a agregar / estado por defecto es V
    private String rutResidente;
    private String Nombre;
    private Date fechaNacimieto;
    private Date fechaIngreso;
    private String sexo;
    //claves foraneas de residentes
    private long idPrevision;
    private String rutApoderado;

    public String getRutResidente() {
        return rutResidente;
    }

    public void setRutResidente(String rutResidente) {
        this.rutResidente = rutResidente;
    }

    public String getNombre() {
        return Nombre;
    }

    public void setNombre(String Nombre) {
        this.Nombre = Nombre;
    }

    public Date getFechaNacimieto() {
        return fechaNacimieto;
    }

    public void setFechaNacimieto(Date fechaNacimieto) {
        this.fechaNacimieto = fechaNacimieto;
    }

    public Date getFechaIngreso() {
        return fechaIngreso;
    }

    public void setFechaIngreso(Date fechaIngreso) {
        this.fechaIngreso = fechaIngreso;
    }

    public String getSexo() {
        return sexo;
    }

    public void setSexo(String sexo) {
        this.sexo = sexo;
    }

    public long getIdPrevision() {
        return idPrevision;
    }

    public void setIdPrevision(long idPrevision) {
        this.idPrevision = idPrevision;
    }

    public String getRutApoderado() {
        return rutApoderado;
    }

    public void setRutApoderado(String rutApoderado) {
        this.rutApoderado = rutApoderado;
    }
    
    @PostConstruct
    public void init(){
        this.residentes = this.residenteDAO.findAll();
    }
    
    public ResidentesManagedBean() {
    }

    public List<Residente> getResidentes() {
        return residentes;
    }

    public void setResidentes(List<Residente> residentes) {
        this.residentes = residentes;
    }
    
    public void agregarResidente(ActionEvent e){
        
        Residente r = new Residente();
        r.setRut_residente(rutResidente);
        r.setNombre_residente(Nombre);
        
        Calendar fechaNacimientoConvertida = Calendar.getInstance();
        fechaNacimientoConvertida.setTime(fechaNacimieto);
        r.setFecha_nacimiento(fechaNacimientoConvertida);
        
        Calendar fechaIngresoConvertida = Calendar.getInstance();
        fechaIngresoConvertida.setTime(fechaIngreso);
        r.setFecha_ingreso(fechaIngresoConvertida);
        
        r.setSexo(sexo);
        r.setEstado("V");
        r.setApoderado(this.apoderadoDAO.find(rutApoderado));
        r.setPrecision(this.previsionDAO.find(idPrevision));
        this.residenteDAO.add(r);
        
        FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Residente Agregado"));
        
    }
    
}
