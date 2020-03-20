/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cl.usm.residenciaFlorenceWar.beans;

import cl.usm.residenciaEjb.dao.MedicamentoDAOLocal;
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
@Named(value = "actualizarMedicamentoManagedBean")
@SessionScoped
public class ActualizarMedicamentoManagedBean implements Serializable {

    @Inject
    private MedicamentoDAOLocal medicamentoDAO;
    @Inject
    private VerMedicamentoManagedBean verMedicamentoBEAN;
    
    private Medicamento medicamentoActualizado;

    public Medicamento getMedicamentoActualizado() {
        return medicamentoActualizado;
    }

    public void setMedicamentoActualizado(Medicamento medicamentoActualizado) {
        this.medicamentoActualizado = medicamentoActualizado;
    }
    
    public ActualizarMedicamentoManagedBean() {
    }
    
    public void actualizar() throws IOException{
        
        this.medicamentoDAO.update(medicamentoActualizado);
        this.verMedicamentoBEAN.setMedicamentoDetalle(medicamentoActualizado);
        FacesContext.getCurrentInstance().getExternalContext().redirect("ver_medicamento_detalle.xhtml");
        
    }
    
}
