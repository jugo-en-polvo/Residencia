/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cl.usm.residenciaFlorenceWar.beans;

import cl.usm.residenciaEjb.dto.Usuario;
import java.io.IOException;
import java.io.Serializable;
import javax.enterprise.context.SessionScoped;
import javax.faces.context.FacesContext;
import javax.inject.Inject;
import javax.inject.Named;

/**
 *
 * @author Senpai
 */
@Named(value = "verUsuarioManagedBean")
@SessionScoped
public class VerUsuarioManagedBean implements Serializable {

    @Inject
    private ActualizarUsuarioManagedBean actualizarUsuarioBEAN;
    private Usuario usuarioDetalle;

    public Usuario getUsuarioDetalle() {
        return usuarioDetalle;
    }

    public void setUsuarioDetalle(Usuario usuarioDetalle) {
        this.usuarioDetalle = usuarioDetalle;
    }

    public VerUsuarioManagedBean() {
    }

    public String determinarEstado(int e) {
        if (e == 0) {
            return "Habilitado";
        } else if (e == 1) {
            return "No Habilitado";
        }
        return null;
    }

    public String determinarNivelAcceso(int a) {
        if (a == 1) {
            return "Administrador";
        } else if (a == 0) {
            return "Cuidador";
        }
        return null;
    }
    
    public void atras() throws IOException{
        FacesContext.getCurrentInstance().getExternalContext().redirect("listar_usuarios.xhtml");
    }
    
    public void editar() throws IOException{
        this.actualizarUsuarioBEAN.setUsuarioActualizado(usuarioDetalle);
        FacesContext.getCurrentInstance().getExternalContext().redirect("actualizar_usuario.xhtml");
    }

}
