/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cl.usm.residenciaFlorenceWar.beans;

import cl.usm.residenciaEjb.dto.Medicamento;
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
@Named(value = "verMedicamentoManagedBean")
@SessionScoped
public class VerMedicamentoManagedBean implements Serializable {
    
    @Inject
    private ActualizarMedicamentoManagedBean actualizarMedicamentoBEAN;
    
    private Medicamento medicamentoDetalle;

    public Medicamento getMedicamentoDetalle() {
        return medicamentoDetalle;
    }

    public void setMedicamentoDetalle(Medicamento medicamentoDetalle) {
        this.medicamentoDetalle = medicamentoDetalle;
    }
    
    public VerMedicamentoManagedBean() {
    }
    
    public void atrar() throws IOException{
        FacesContext.getCurrentInstance().getExternalContext().redirect("listar_medicamento.xhtml");
    }
    
    public void editar() throws IOException{
        
        this.actualizarMedicamentoBEAN.setMedicamentoActualizado(medicamentoDetalle);
        FacesContext.getCurrentInstance().getExternalContext().redirect("actualizar_medicamento.xhtml");
        
    }
    
}
