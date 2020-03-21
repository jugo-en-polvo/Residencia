/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cl.usm.residenciaFlorenceWar.beans;

import cl.usm.residenciaEjb.dao.DiagnosticoDAOLocal;
import cl.usm.residenciaEjb.dto.Diagnostico;
import java.io.IOException;
import java.io.Serializable;
import java.util.List;
import javax.faces.context.FacesContext;
import javax.inject.Named;
import javax.faces.view.ViewScoped;
import javax.inject.Inject;

/**
 *
 * @author Senpai
 */
@Named(value = "listarDiagnosticosManagedBean")
@ViewScoped
public class ListarDiagnosticosManagedBean implements Serializable {

    @Inject
    private DiagnosticoDAOLocal diagnosticoDAO;
    @Inject
    private ActualizarDiagnosticoManagedBean actualizarDiagnosticoBEAN;
    
    private List<Diagnostico> diagnosticosFiltro;
    private String rutResidente;

    public String getRutResidente() {
        return rutResidente;
    }

    public void setRutResidente(String rutResidente) {
        this.rutResidente = rutResidente;
    }

    public List<Diagnostico> getDiagnosticosFiltro() {
        return diagnosticosFiltro;
    }

    public void setDiagnosticosFiltro(List<Diagnostico> diagnosticosFiltro) {
        this.diagnosticosFiltro = diagnosticosFiltro;
    }

    public ListarDiagnosticosManagedBean() {
    }

    public void filtroDiagnotico() {

        if (rutResidente != null && !rutResidente.equals("")) {
            this.diagnosticosFiltro = diagnosticoDAO.findByRut(rutResidente);
        } else {
            this.diagnosticosFiltro.clear();
        }

    }
    
    public void editar(Diagnostico d) throws IOException{
        
        this.actualizarDiagnosticoBEAN.setRutResidente(d.getResidente().getRut_residente());
        this.actualizarDiagnosticoBEAN.setDiagnosticoActualizado(d);
        FacesContext.getCurrentInstance().getExternalContext().redirect("actualizar_diagnostico.xhtml");
        
    }

}
