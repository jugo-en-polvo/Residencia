/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cl.usm.residenciaFlorenceWar.beans;

import cl.usm.residenciaEjb.dao.DiagnosticoDAOLocal;
import cl.usm.residenciaEjb.dao.ResidenteDAOLocal;
import cl.usm.residenciaEjb.dto.Diagnostico;
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
@Named(value = "actualizarDiagnosticoManagedBean")
@SessionScoped
public class ActualizarDiagnosticoManagedBean implements Serializable {

    @Inject
    private DiagnosticoDAOLocal diagnosticoDAO;
    @Inject
    private ResidenteDAOLocal residenteDAO;
    
    private Diagnostico diagnosticoActualizado;
    private String rutResidente;

    public Diagnostico getDiagnosticoActualizado() {
        return diagnosticoActualizado;
    }

    public void setDiagnosticoActualizado(Diagnostico diagnosticoActualizado) {
        this.diagnosticoActualizado = diagnosticoActualizado;
    }

    public String getRutResidente() {
        return rutResidente;
    }

    public void setRutResidente(String rutResidente) {
        this.rutResidente = rutResidente;
    }
    
    public ActualizarDiagnosticoManagedBean() {
    }
    
    public void editar() throws IOException{
        
        diagnosticoActualizado.setResidente(residenteDAO.find(rutResidente));
        this.diagnosticoDAO.update(diagnosticoActualizado);
        FacesContext.getCurrentInstance().getExternalContext().redirect("listar_diagnosticos.xhtml");
                
    }
    
}
