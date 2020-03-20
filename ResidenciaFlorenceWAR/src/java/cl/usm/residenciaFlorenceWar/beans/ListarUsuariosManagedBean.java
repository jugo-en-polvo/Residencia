/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cl.usm.residenciaFlorenceWar.beans;

import cl.usm.residenciaEjb.dao.UsuariosDAOLocal;
import cl.usm.residenciaEjb.dto.Usuario;
import java.io.IOException;
import java.io.Serializable;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.faces.context.FacesContext;
import javax.inject.Named;
import javax.faces.view.ViewScoped;
import javax.inject.Inject;

/**
 *
 * @author Senpai
 */
@Named(value = "listarUsuariosManagedBean")
@ViewScoped
public class ListarUsuariosManagedBean implements Serializable{

    @Inject
    private UsuariosDAOLocal usuarioDAO;
    @Inject
    private VerUsuarioManagedBean verUsuarioBEAN;

    public VerUsuarioManagedBean getVerUsuarioBEAN() {
        return verUsuarioBEAN;
    }

    public void setVerUsuarioBEAN(VerUsuarioManagedBean verUsuarioBEAN) {
        this.verUsuarioBEAN = verUsuarioBEAN;
    }
    
    private List<Usuario> usuarios;
    private String valorFiltro;

    public String getValorFiltro() {
        return valorFiltro;
    }

    public void setValorFiltro(String valorFiltro) {
        this.valorFiltro = valorFiltro;
    }

    public List<Usuario> getUsuarios() {
        return usuarios;
    }

    public void setUsuarios(List<Usuario> usuarios) {
        this.usuarios = usuarios;
    }
    
    public ListarUsuariosManagedBean() {
    }
    
    @PostConstruct
    public void init(){
        this.usuarios = this.usuarioDAO.findAllByEstado(0);
    }
    
    public void manejarFiltro(){
        switch(valorFiltro){
            case "todos":
                this.usuarios = this.usuarioDAO.findAll();
                break;
            case "habilitados":
                this.usuarios = this.usuarioDAO.findAllByEstado(0);
                break;
            case "nohabilitados":
                this.usuarios = this.usuarioDAO.findAllByEstado(1);
                break;
            default:
                this.usuarios = this.usuarioDAO.findAll();
                break;
        }
    }
    
    public String determinarEstado(int e){
        if(e == 0){
            return "Habilitado";
        }else if(e == 1){
            return "No Habilitado";
        }
        return null;
    }
    
    public String determinarNivelAcceso(int a){
        if(a == 1){
            return "Administrador";
        }else if (a == 0){
            return "Cuidador";
        }
        return null;
    }
    
    public void editar(Usuario u) throws IOException{
        
        this.verUsuarioBEAN.setUsuarioDetalle(u);
        FacesContext.getCurrentInstance().getExternalContext().redirect("ver_usuario_detalle.xhtml");
        
    }
}
