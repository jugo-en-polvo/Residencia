/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cl.usm.residenciaFlorenceWar.beans;

import cl.usm.residenciaEjb.dao.LugarDAOLocal;
import cl.usm.residenciaEjb.dto.Lugar;
import java.io.Serializable;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.annotation.PostConstruct;
import javax.inject.Named;
import javax.faces.view.ViewScoped;
import javax.inject.Inject;

/**
 *
 * @author Senpai
 */
@Named(value = "listarLugaresManagedBean")
@ViewScoped
public class ListarLugaresManagedBean implements Serializable{

    @Inject
    private LugarDAOLocal lugarDao;
    
    private List<Lugar> lugares;
    private Map<String, String> comboLugares = new HashMap<String, String>();

    public Map<String, String> getComboLugares() {
        return comboLugares;
    }

    public void setComboLugares(Map<String, String> comboLugares) {
        this.comboLugares = comboLugares;
    }
    
    public List<Lugar> getLugares() {
        return lugares;
    }

    public void setLugares(List<Lugar> lugares) {
        this.lugares = lugares;
    }
    
    @PostConstruct
    public void init(){
        this.lugares = this.lugarDao.findAll();
        for(Lugar l: lugares){
            comboLugares.put(l.getNombre_lugar(), String.valueOf(l.getId_lugar()));
        }
    }
    
    public ListarLugaresManagedBean() {
    }
    
}
