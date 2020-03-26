/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cl.usm.residenciaFlorenceWar.beans;

import cl.usm.residenciaEjb.dao.ControlesMedicosDAOLocal;
import cl.usm.residenciaEjb.dao.LugarDAOLocal;
import cl.usm.residenciaEjb.dao.ResidenteDAOLocal;
import cl.usm.residenciaEjb.dto.Control_Medico;
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
@Named(value = "editarControlMedicoManagedBean")
@SessionScoped
public class EditarControlMedicoManagedBean implements Serializable {

    @Inject
    private ControlesMedicosDAOLocal controlesDAO;
    @Inject
    private ResidenteDAOLocal residenteDAO;
    @Inject
    private LugarDAOLocal lugarDAO;
    private Control_Medico controlMedicoEditado;

    public Control_Medico getControlMedicoEditado() {
        return controlMedicoEditado;
    }

    public void setControlMedicoEditado(Control_Medico controlMedicoEditado) {
        this.controlMedicoEditado = controlMedicoEditado;
    }

    public EditarControlMedicoManagedBean() {
    }

    public String obtenerEstado() {
        if(controlMedicoEditado.getEstado_control().equals("N")){
            return "false";
        }else{
            return "true";
        }
    }

    public void editar() throws IOException {

        this.controlMedicoEditado.setLugar(this.lugarDAO.find(this.controlMedicoEditado.getLugar().getId_lugar()));
        this.controlMedicoEditado.setResidente(this.residenteDAO.find(this.controlMedicoEditado.getResidente().getRut_residente()));
        this.controlesDAO.update(controlMedicoEditado);
        FacesContext.getCurrentInstance().getExternalContext().redirect("ver_controles_medicos.xhtml");
        
    }

}
