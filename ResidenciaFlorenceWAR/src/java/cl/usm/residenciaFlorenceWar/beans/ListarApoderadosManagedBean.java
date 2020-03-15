/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cl.usm.residenciaFlorenceWar.beans;

import cl.usm.residenciaEjb.dao.ApoderadoDAOLocal;
import cl.usm.residenciaEjb.dto.Apoderado;
import cl.usm.residenciaEjb.dto.Residente;
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
@Named(value = "listarApoderadosManagedBean")
@ViewScoped
public class ListarApoderadosManagedBean implements Serializable{

    @Inject
    private ApoderadoDAOLocal apoderadosDAO;  
    @Inject
    private VerApoderadoManagedBean apoderadosBEAN;
            
    private List<Apoderado> apoderados;
    private Map<String, String> apoderadosCombo = new HashMap<>();
    private String rutApoderado;

    public String getRutApoderado() {
        return rutApoderado;
    }

    public void setRutApoderado(String rutApoderado) {
        this.rutApoderado = rutApoderado;
    }

    public Map<String, String> getApoderadosCombo() {
        return apoderadosCombo;
    }

    public void setApoderadosCombo(Map<String, String> apoderadosCombo) {
        this.apoderadosCombo = apoderadosCombo;
    }
    
    public List<Apoderado> getApoderados() {
        return apoderados;
    }

    public void setApoderados(List<Apoderado> apoderados) {
        this.apoderados = apoderados;
    }
    
    @PostConstruct
    public void init(){
        this.apoderados = this.apoderadosDAO.findAll();
        apoderados.forEach((a) -> {
            this.apoderadosCombo.put(a.getNombre_apoderado(), a.getRut_apoderado());
        });
    }
    
    public ListarApoderadosManagedBean() {
    }
    
    
    public void verDetalle(Apoderado a) throws IOException {
        this.apoderadosBEAN.setApoderadoDetalle(a);
        FacesContext.getCurrentInstance().getExternalContext().redirect("ver_apoderado_detalle.xhtml");
    }
    
}
