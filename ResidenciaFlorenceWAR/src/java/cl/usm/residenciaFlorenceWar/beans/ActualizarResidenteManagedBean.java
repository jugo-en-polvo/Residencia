/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cl.usm.residenciaFlorenceWar.beans;

import cl.usm.residenciaEjb.dao.ResidenteDAOLocal;
import cl.usm.residenciaEjb.dto.Residente;
import java.io.IOException;
import javax.inject.Named;
import javax.enterprise.context.SessionScoped;
import java.io.Serializable;
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
    private Residente residenteActualizado;
    private String Nombre;
    private Date fechaNacimieto;
    private Date fechaIngreso;
    private Date fechaEgreso;
    private String sexo;
    private String alergias;
    private String observaciones;
    private String regimenAlimentario;
    private long idPrevision;
    private String rutApoderado;

    public Residente getResidenteActualizado() {
        return residenteActualizado;
    }

    public void setResidenteActualizado(Residente residenteActualizado) {
        this.residenteActualizado = residenteActualizado;
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

    public Date getFechaEgreso() {
        return fechaEgreso;
    }

    public void setFechaEgreso(Date fechaEgreso) {
        this.fechaEgreso = fechaEgreso;
    }

    public String getSexo() {
        return sexo;
    }

    public void setSexo(String sexo) {
        this.sexo = sexo;
    }

    public String getAlergias() {
        return alergias;
    }

    public void setAlergias(String alergias) {
        this.alergias = alergias;
    }

    public String getObservaciones() {
        return observaciones;
    }

    public void setObservaciones(String observaciones) {
        this.observaciones = observaciones;
    }

    public String getRegimenAlimentario() {
        return regimenAlimentario;
    }

    public void setRegimenAlimentario(String regimenAlimentario) {
        this.regimenAlimentario = regimenAlimentario;
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
    
    public ActualizarResidenteManagedBean() {
    }
    
    public void actualizarResidente(ActionEvent e) throws IOException{
        
        this.residenteDAO.update(residenteActualizado);
        FacesContext.getCurrentInstance().getExternalContext().redirect("lista_residentes.xhtml");
        
    }
    
}
