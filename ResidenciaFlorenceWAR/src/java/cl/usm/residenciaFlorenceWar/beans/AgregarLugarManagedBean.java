/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cl.usm.residenciaFlorenceWar.beans;

import cl.usm.residenciaEjb.dao.LugarDAOLocal;
import cl.usm.residenciaEjb.dto.Lugar;
import java.io.IOException;
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
@Named(value = "agregarLugarManagedBean")
@ViewScoped
public class AgregarLugarManagedBean implements Serializable{

    @Inject
    private LugarDAOLocal lugarDAO;
    private String nombreLugar;
    private String fonoLugar;
    private String direccionLugar;

    public String getDireccionLugar() {
        return direccionLugar;
    }

    public void setDireccionLugar(String direccionLugar) {
        this.direccionLugar = direccionLugar;
    }

    public String getNombreLugar() {
        return nombreLugar;
    }

    public void setNombreLugar(String nombreLugar) {
        this.nombreLugar = nombreLugar;
    }

    public String getFonoLugar() {
        return fonoLugar;
    }

    public void setFonoLugar(String fonoLugar) {
        this.fonoLugar = fonoLugar;
    }
    
    public void agregar(ActionEvent e) throws IOException{
        
        Lugar l = new Lugar();
        l.setNombre_lugar(nombreLugar);
        l.setFono_lugar(fonoLugar);
        l.setDireccion_lugar(direccionLugar);
        l.setEstado(true);
        
        lugarDAO.add(l);
        
        FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Lugar Agregado"));
        FacesContext.getCurrentInstance().getExternalContext().redirect("listar_lugares.xhtml");
        
    }
    
    public AgregarLugarManagedBean() {
    }
    
}
