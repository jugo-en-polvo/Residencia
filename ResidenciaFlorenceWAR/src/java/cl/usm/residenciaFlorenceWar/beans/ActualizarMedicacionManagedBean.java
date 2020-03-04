/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cl.usm.residenciaFlorenceWar.beans;

import cl.usm.residenciaEjb.dao.Administrar_MedicamentoDAOLocal;
import cl.usm.residenciaEjb.dto.Administrar_Medicamento;
import java.io.IOException;
import java.io.Serializable;
import javax.enterprise.context.SessionScoped;
import javax.faces.context.FacesContext;
import javax.faces.event.ActionEvent;
import javax.inject.Named;
import javax.inject.Inject;

/**
 *
 * @author Senpai
 */
@Named(value = "actualizarMedicacionManagedBean")
@SessionScoped
public class ActualizarMedicacionManagedBean implements Serializable {

    @Inject
    private Administrar_MedicamentoDAOLocal medicacionDAO;
    private String observaciones;
    private boolean estado;
    private Administrar_Medicamento amParaActualizar;

    public ActualizarMedicacionManagedBean() {
    }

    public Administrar_Medicamento getAmParaActualizar() {
        return amParaActualizar;
    }

    public void setAmParaActualizar(Administrar_Medicamento amParaActualizar) {
        this.amParaActualizar = amParaActualizar;
    }
    
    public String getObservaciones() {
        return observaciones;
    }

    public void setObservaciones(String observaciones) {
        this.observaciones = observaciones;
    }

    public boolean isEstado() {
        return estado;
    }

    public void setEstado(boolean estado) {
        this.estado = estado;
    }
    
    public void update(ActionEvent e) throws IOException{
        
        this.amParaActualizar.setEstado(estado);
        this.amParaActualizar.setObservaciones(observaciones);
        this.medicacionDAO.update(amParaActualizar);
        
        FacesContext.getCurrentInstance().getExternalContext().redirect("agregar_administracion_medicamento.xhtml");
        
    }

}
