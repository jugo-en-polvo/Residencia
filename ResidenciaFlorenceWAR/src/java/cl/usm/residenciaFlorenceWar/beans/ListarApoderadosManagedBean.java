/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cl.usm.residenciaFlorenceWar.beans;

import cl.usm.residenciaEjb.dao.ApoderadoDAOLocal;
import cl.usm.residenciaEjb.dto.Apoderado;
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
@Named(value = "listarApoderadosManagedBean")
@ViewScoped
public class ListarApoderadosManagedBean implements Serializable{

    @Inject
    private ApoderadoDAOLocal apoderadosDAO;  
    private List<Apoderado> apoderados;

    public List<Apoderado> getApoderados() {
        return apoderados;
    }

    public void setApoderados(List<Apoderado> apoderados) {
        this.apoderados = apoderados;
    }
    
    @PostConstruct
    public void init(){
        this.apoderados = this.apoderadosDAO.findAll();
    }
    
    public ListarApoderadosManagedBean() {
    }
    
}
