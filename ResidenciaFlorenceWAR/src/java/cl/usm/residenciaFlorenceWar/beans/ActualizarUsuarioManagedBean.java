/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cl.usm.residenciaFlorenceWar.beans;

import cl.usm.residenciaEjb.dao.UsuariosDAOLocal;
import cl.usm.residenciaEjb.dto.Usuario;
import java.io.IOException;
import javax.inject.Named;
import javax.enterprise.context.SessionScoped;
import java.io.Serializable;
import javax.faces.context.FacesContext;
import javax.inject.Inject;

/**
 *
 * @author Senpai
 */
@Named(value = "actualizarUsuarioManagedBean")
@SessionScoped
public class ActualizarUsuarioManagedBean implements Serializable {

    @Inject
    private UsuariosDAOLocal usuariosDAO;
    @Inject
    private VerUsuarioManagedBean verUsuarioBEAN;
    private Usuario usuarioActualizado;
    
    public Usuario getUsuarioActualizado() {
        return usuarioActualizado;
    }

    public void setUsuarioActualizado(Usuario usuarioActualizado) {
        this.usuarioActualizado = usuarioActualizado;
    }
    
    public ActualizarUsuarioManagedBean() {
    }
    
    public void actualizar() throws IOException{
        
        this.usuariosDAO.update(usuarioActualizado);
        this.verUsuarioBEAN.setUsuarioDetalle(usuarioActualizado);
        FacesContext.getCurrentInstance().getExternalContext().redirect("ver_usuario_detalle.xhtml");
        
    }
}
