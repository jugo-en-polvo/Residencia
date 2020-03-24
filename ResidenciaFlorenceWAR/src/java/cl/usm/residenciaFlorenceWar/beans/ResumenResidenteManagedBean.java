/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cl.usm.residenciaFlorenceWar.beans;

import cl.usm.residenciaEjb.dao.ResidenteDAOLocal;
import cl.usm.residenciaEjb.dto.Residente;
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
@Named(value = "resumenResidenteManagedBean")
@ViewScoped
public class ResumenResidenteManagedBean implements Serializable{

    @Inject
    private ResidenteDAOLocal residenteDAO;
    @Inject
    private VerResumenDetalleManagedBean verResumenDetalleBEAN;
    
    private String rutResidente;
    private List<Residente> residentes;

    public List<Residente> getResidentes() {
        return residentes;
    }

    public void setResidentes(List<Residente> residentes) {
        this.residentes = residentes;
    }

    public String getRutResidente() {
        return rutResidente;
    }

    public void setRutResidente(String rutResidente) {
        this.rutResidente = rutResidente;
    }
   
    public ResumenResidenteManagedBean() {
    }
    
    @PostConstruct
    public void init(){
        this.residentes = this.residenteDAO.findAllActuales();
    }

    public void manejarFiltroNuevo() {

        switch (rutResidente) {
            case "actuales":
                this.residentes = this.residenteDAO.findAllActuales();
                break;
            case "egresados":
                this.residentes = this.residenteDAO.findAllEgresados();
                break;
            default:
                this.residentes = this.residenteDAO.findAll();
                break;
        }

    }
    
    public void verResumenDetallado(Residente r) throws IOException{
        this.verResumenDetalleBEAN.setResidenteDetalle(r);
        this.verResumenDetalleBEAN.setTratamientos(r.getTratamientos());
        this.verResumenDetalleBEAN.setDiagnosticos(r.getDiagnosticos());
        this.verResumenDetalleBEAN.setEmergencias(r.getEmergencias());
        FacesContext.getCurrentInstance().getExternalContext().redirect("ver_resumen_detalle.xhtml");
    }
    
}
