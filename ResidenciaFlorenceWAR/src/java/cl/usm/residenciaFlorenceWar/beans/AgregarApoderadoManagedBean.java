/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cl.usm.residenciaFlorenceWar.beans;

import cl.usm.residenciaEjb.dao.ApoderadoDAOLocal;
import cl.usm.residenciaEjb.dto.Apoderado;
import cl.usm.residenciaFlorenceWar.utils.ValidadorRut;
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
@Named(value = "agregarApoderadoManagedBean")
@ViewScoped
public class AgregarApoderadoManagedBean implements Serializable {

    @Inject
    private ApoderadoDAOLocal apoderadosDAO;
    private String rutApoderado;
    private String nombreApoderado;
    private int fonoApoderado;
    private String direccionApoderado;
    private String emailApoderado;

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

    public int getFonoApoderado() {
        return fonoApoderado;
    }

    public void setFonoApoderado(int fonoApoderado) {
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

    public String getEmailApoderado() {
        return emailApoderado;
    }

    public void setEmailApoderado(String emailApoderado) {
        this.emailApoderado = emailApoderado;
    }

    public void agregar(ActionEvent e) throws IOException {

        if (apoderadosDAO.compruebaExistencia(rutApoderado)) {
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Error", "Apoderado ya existe en el sistema."));
        } else {
            if (ValidadorRut.validarRut(rutApoderado)) {
                Apoderado a = new Apoderado();
                a.setRut_apoderado(rutApoderado);
                a.setNombre_apoderado(nombreApoderado);
                a.setFono_apoderado(Integer.toString(fonoApoderado));
                a.setDireccion_apoderado(direccionApoderado);
                a.setEmail_apoderado(emailApoderado);

                this.apoderadosDAO.add(a);
                FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Apoderado Agregado"));
                FacesContext.getCurrentInstance().getExternalContext().redirect("listar_apoderados.xhtml");
            } else {
                FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Rut de apoderado inválido, reingrese"));
            }
        }

    }

}
