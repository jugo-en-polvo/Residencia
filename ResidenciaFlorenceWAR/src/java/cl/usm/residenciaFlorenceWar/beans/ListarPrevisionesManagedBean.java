/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cl.usm.residenciaFlorenceWar.beans;

import cl.usm.residenciaEjb.dao.PrevisionDAOLocal;
import cl.usm.residenciaEjb.dto.Prevision;
import java.io.Serializable;
import java.util.List;
import javax.annotation.PostConstruct;
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
    private List<Prevision> previsiones;

    public List<Prevision> getPrevisiones() {
        return previsiones;
    }

    public void setPrevisiones(List<Prevision> previsiones) {
        this.previsiones = previsiones;
    }
    
    @PostConstruct
    public void init(){
        this.previsiones = this.previsionesDAO.findAll();
    }
    
    public ListarPrevisionesManagedBean() {
    }
    
}
