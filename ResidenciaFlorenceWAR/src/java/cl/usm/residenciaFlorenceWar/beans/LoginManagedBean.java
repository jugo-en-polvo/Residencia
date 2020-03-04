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
import java.io.IOException;
import javax.inject.Named;
import javax.enterprise.context.SessionScoped;
import java.io.Serializable;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.faces.event.ActionEvent;
import javax.inject.Inject;

/**
 *
 * @author Esteban
 */
@Named(value = "loginManagedBean")
@SessionScoped
public class LoginManagedBean implements Serializable {

    @Inject
    private UsuariosDAOLocal usuariosDAO;
    private Usuario usuarioLogueado;
    private String rut;
    private String clave;

    public Usuario getUsuarioLogueado() {
        return usuarioLogueado;
    }

    public void setUsuarioLogueado(Usuario usuarioLogueado) {
        this.usuarioLogueado = usuarioLogueado;
    }

    
    public String getRut() {
        return rut;
    }

    public void setRut(String rut) {
        this.rut = rut;
    }

    public String getClave() {
        return clave;
    }

    public void setClave(String clave) {
        this.clave = clave;
    }
    
    
    public void iniciarSesion(ActionEvent ev) throws IOException {
        String claveHash =PasswordUtils.generateSecurePassword(clave, UtilsConstants.SALT);
        this.usuarioLogueado = this.usuariosDAO.findByRutYClave(rut, claveHash);
        if(this.usuarioLogueado != null){
            FacesContext.getCurrentInstance()
                    .getExternalContext()
                    .redirect("index.xhtml");
        } else {
            FacesContext.getCurrentInstance()
                    .addMessage(null
                            , new FacesMessage(FacesMessage.SEVERITY_ERROR
                                    , "Ingreso fallido"
                                    , "Credenciales incorrectas"));
        }
    }
    /**
     * Creates a new instance of LoginManagedBean
     */
    public LoginManagedBean() {
    }
    
}
