/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cl.usm.residenciaFlorenceWar.beans;

import cl.usm.residenciaEjb.dao.ApoderadoDAOLocal;
import cl.usm.residenciaEjb.dto.Apoderado;
import java.io.Serializable;
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
@Named(value = "agregarApoderadoManagedBean")
@ViewScoped
public class AgregarApoderadoManagedBean implements Serializable{

    @Inject
    private ApoderadoDAOLocal apoderadosDAO;
    private String rutApoderado;
    private String nombreApoderado;
    private String fonoApoderado;
    private String direccionApoderado;

    public String getRutApoderado() {
        return rutApoderado;
    }

    public void setRutApoderado(String rutApoderado) {
        this.rutApoderado = rutApoderado;
    }

    public String getNombreApoderado() {
        return nombreApoderado;
    }

    public void setNombreApoderado(String nombreApoderado) {
        this.nombreApoderado = nombreApoderado;
    }

    public String getFonoApoderado() {
        return fonoApoderado;
    }

    public void setFonoApoderado(String fonoApoderado) {
        this.fonoApoderado = fonoApoderado;
    }

    public String getDireccionApoderado() {
        return direccionApoderado;
    }

    public void setDireccionApoderado(String direccionApoderado) {
        this.direccionApoderado = direccionApoderado;
    }
    
    public AgregarApoderadoManagedBean() {
    }
    
    
    public void agregar(ActionEvent e){
        
        Apoderado a = new Apoderado();
        a.setRut_apoderado(rutApoderado);
        a.setNombre_apoderado(nombreApoderado);
        a.setFono_apoderado(fonoApoderado);
        a.setDireccion_apoderado(direccionApoderado);
        
        this.apoderadosDAO.add(a);
        FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Apoderado Agragado"));
    }
}
