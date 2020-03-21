/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cl.usm.residenciaFlorenceWar.beans;

import cl.usm.residenciaEjb.dao.UsuariosDAOLocal;
import cl.usm.residenciaEjb.dto.Usuario;
import cl.usm.residenciaFlorenceWar.utils.PasswordUtils;
import cl.usm.residenciaFlorenceWar.utils.UtilsConstants;
import cl.usm.residenciaFlorenceWar.utils.ValidadorRut;
import java.io.Serializable;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.faces.event.ActionEvent;
import javax.inject.Named;
import javax.faces.view.ViewScoped;
import javax.inject.Inject;

/**
 *
 * @author Esteban
 */
@Named(value = "agregarUsuarioManagedBean")
@ViewScoped
public class AgregarUsuarioManagedBean implements Serializable {

    @Inject
    private UsuariosDAOLocal usuariosDAO;

    private String rut;
    private String nombre;
    private String clave;
    private int nivel_acceso;
    private int estado;

    public void registrar(ActionEvent e) {
        if (usuariosDAO.compruebaExistencia(rut)) {
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Error", "Usuario ya existe en el sistema."));
        } else {
            if (ValidadorRut.validarRut(rut)) {
                String hash = PasswordUtils.generateSecurePassword(clave, UtilsConstants.SALT);
                Usuario usuario = new Usuario();
                usuario.setRut_usuario(rut);
                usuario.setNombre_usuario(nombre);
                usuario.setNivel_acceso(nivel_acceso);
                usuario.setEstado(estado);
                usuario.setClave(hash);
                usuariosDAO.add(usuario);
                FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Usuario Ingresado."));
            } else {
                FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Rut de usuario inválido, reingrese."));
            }

        }
    }

    public int getNivel_acceso() {
        return nivel_acceso;
    }

    public void setNivel_acceso(int nivel_acceso) {
        this.nivel_acceso = nivel_acceso;
    }

    public int getEstado() {
        return estado;
    }

    public void setEstado(int estado) {
        this.estado = estado;
    }

    public String getRut() {
        return rut;
    }

    public void setRut(String rut) {
        this.rut = rut;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getClave() {
        return clave;
    }

    public void setClave(String clave) {
        this.clave = clave;
    }

    /**
     * Creates a new instance of AgregarUsuarioManagedBean
     */
    public AgregarUsuarioManagedBean() {
    }

}
