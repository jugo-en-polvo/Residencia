/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cl.usm.residenciaFlorenceWar.beans;

import cl.usm.residenciaEjb.dao.EmergenciaDAOLocal;
import cl.usm.residenciaEjb.dto.Emergencia;
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
@Named(value = "listarEmergenciasManagedBean")
@ViewScoped
public class ListarEmergenciasManagedBean implements Serializable{

    @Inject
    private EmergenciaDAOLocal emergenciaDAO;
    private List<Emergencia> emergencias;

    public List<Emergencia> getEmergencias() {
        return emergencias;
    }

    public void setEmergencias(List<Emergencia> emergencias) {
        this.emergencias = emergencias;
    }
    
    @PostConstruct
    public void init(){
        this.emergencias = this.emergenciaDAO.findAll();
    }
    
    public ListarEmergenciasManagedBean() {
    }
    
}
