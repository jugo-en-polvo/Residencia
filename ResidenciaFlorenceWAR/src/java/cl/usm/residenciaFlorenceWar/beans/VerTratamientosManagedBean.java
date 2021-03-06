/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cl.usm.residenciaFlorenceWar.beans;

import cl.usm.residenciaEjb.dao.TratamientosDAOLocal;
import cl.usm.residenciaEjb.dto.Tratamiento;
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
@Named(value = "verTratamientosManagedBean")
@ViewScoped
public class VerTratamientosManagedBean implements Serializable{

    @Inject
    private TratamientosDAOLocal tratamientosDAO;
    private List<Tratamiento> tratamientos;
    private List<Tratamiento> tratamientoFiltro;
    private String rutResidente;

    public List<Tratamiento> getTratamientoFiltro() {
        return tratamientoFiltro;
    }

    public void setTratamientoFiltro(List<Tratamiento> tratamientoFiltro) {
        this.tratamientoFiltro = tratamientoFiltro;
    }

    public String getRutResidente() {
        return rutResidente;
    }

    public void setRutResidente(String rutResidente) {
        this.rutResidente = rutResidente;
    }

    public List<Tratamiento> getTratamientos() {
        return tratamientos;
    }

    public void setTratamientos(List<Tratamiento> tratamientos) {
        this.tratamientos = tratamientos;
    }
    
    @PostConstruct
    public void init(){
        this.tratamientos = this.tratamientosDAO.findAll();
        this.tratamientoFiltro = tratamientos;
    }
    
    public VerTratamientosManagedBean() {
    }
    
    public void manejarFiltro(){
        
        if(rutResidente != null && !rutResidente.equals("")){
            this.tratamientoFiltro = tratamientosDAO.findByRut(rutResidente);           
        }else{
            this.tratamientoFiltro = tratamientosDAO.findAll();
        }
        
    }
}
