/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cl.usm.residenciaFlorenceWar.beans;

import cl.usm.residenciaEjb.dao.PrevisionDAOLocal;
import cl.usm.residenciaEjb.dto.Prevision;
import java.io.IOException;
import java.io.Serializable;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.annotation.PostConstruct;
import javax.faces.context.FacesContext;
import javax.inject.Named;
import javax.faces.view.ViewScoped;
import javax.inject.Inject;

/**
 *
 * @author Senpai
 */
@Named(value = "listarPrevisionesManagedBean")
@ViewScoped
public class ListarPrevisionesManagedBean implements Serializable{

    @Inject
    private PrevisionDAOLocal previsionesDAO;
    @Inject
    private VerPrevisionManagedBean verPrevisionBEAN;
    @Inject
    private ActualizarPrevisionManagedBean actualizarPrevisionBEAN;
    
    private List<Prevision> previsiones;
    private Map<String, String> previsionesCombo = new HashMap<>();

    public Map<String, String> getPrevisionesCombo() {
        return previsionesCombo;
    }

    public void setPrevisionesCombo(Map<String, String> previsionesCombo) {
        this.previsionesCombo = previsionesCombo;
    }

    public List<Prevision> getPrevisiones() {
        return previsiones;
    }

    public void setPrevisiones(List<Prevision> previsiones) {
        this.previsiones = previsiones;
    }
    
    @PostConstruct
    public void init(){
        this.previsiones = this.previsionesDAO.findAll();
        previsiones.forEach((p) -> {
            previsionesCombo.put(p.getTipo_prevision(), Long.toString(p.getId_prevision()));
        });
    }
    
    public ListarPrevisionesManagedBean() {
    }
    
    public void detalles(Prevision p) throws IOException{
        this.verPrevisionBEAN.setPrevisionDetalle(p);
        FacesContext.getCurrentInstance().getExternalContext().redirect("ver_prevision_detalle.xhtml");
    }
    
    public void editar(Prevision p) throws IOException{
        
        this.actualizarPrevisionBEAN.setPrevisionActualizado(p);
        FacesContext.getCurrentInstance().getExternalContext().redirect("actualizar_prevision.xhtml");
        
    }
}
