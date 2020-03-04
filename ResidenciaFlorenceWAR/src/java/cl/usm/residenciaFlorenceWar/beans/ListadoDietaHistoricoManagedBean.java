/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cl.usm.residenciaFlorenceWar.beans;

import cl.usm.residenciaEjb.dao.DietaDAOLocal;
import cl.usm.residenciaEjb.dto.Dieta;
import java.io.Serializable;
import java.util.List;
import javax.inject.Named;
import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import org.glassfish.soteria.cdi.CdiUtils;

/**
 *
 * @author Senpai
 */
@Named(value = "listadoDietaHistoricoManagedBean")
@ViewScoped
public class ListadoDietaHistoricoManagedBean implements Serializable{

    @Inject
    private DietaDAOLocal dietaDAO;
    private List<Dieta> dietasFiltro;
    private String rutResidente;

    public String getRutResidente() {
        return rutResidente;
    }

    public void setRutResidente(String rutResidente) {
        this.rutResidente = rutResidente;
    }

    public List<Dieta> getDietasFiltro() {
        return dietasFiltro;
    }

    public void setDietasFiltro(List<Dieta> dietasFiltro) {
        this.dietasFiltro = dietasFiltro;
    }
    
    public ListadoDietaHistoricoManagedBean() {
    }
    
    public String verificarDesayuno(Dieta dieta){
        if(dieta.isDesayuno()){
            return "SI";
        }else{
            return "NO";
        }
    }
    
    public String verificarColacion1(Dieta dieta){
        if(dieta.isColacion_1()){
            return "SI";
        }else{
            return "NO";
        }
    }
    
    public String verificarAlmuerzo(Dieta dieta){
        if(dieta.isAlmuerzo()){
            return "SI";
        }else{
            return "NO";
        }
    }
    
    public String verificarColacion2(Dieta dieta){
        if(dieta.isColacion_2()){
            return "SI";
        }else{
            return "NO";
        }
    }
    
    public String verificarOnce(Dieta dieta){
        if(dieta.isOnce()){
            return "SI";
        }else{
            return "NO";
        }
    }
    
    public String verificarCena(Dieta dieta){
        if(dieta.isCena()){
            return "SI";
        }else{
            return "NO";
        }
    }
    
    public void filtroDieta(){
        
         if(rutResidente != null && !rutResidente.equals("")){
            this.dietasFiltro = dietaDAO.findByRut(rutResidente);
        }else{
            this.dietasFiltro.clear();
        }
        
    }
    
}
