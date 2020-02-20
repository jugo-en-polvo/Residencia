/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cl.usm.residenciaFlorenceWar.beans;

import cl.usm.residenciaEjb.dao.MedicamentoDAOLocal;
import cl.usm.residenciaEjb.dto.Medicamento;
import java.io.Serializable;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.faces.event.ActionEvent;
import javax.inject.Named;
import javax.faces.view.ViewScoped;
import javax.inject.Inject;

/**
 *
 * @author Senpai
 */
@Named(value = "agregarMedicamentoManagedBean")
@ViewScoped
public class AgregarMedicamentoManagedBean implements Serializable{

    @Inject
    private MedicamentoDAOLocal medicamentosDAO;
    private String nombre_medicamento;
    private String tipo;
    private String detalle;
    private int stock;
    private int stock_critico;

    public String getNombre_medicamento() {
        return nombre_medicamento;
    }

    public void setNombre_medicamento(String nombre_medicamento) {
        this.nombre_medicamento = nombre_medicamento;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public String getDetalle() {
        return detalle;
    }

    public void setDetalle(String detalle) {
        this.detalle = detalle;
    }

    public int getStock() {
        return stock;
    }

    public void setStock(int stock) {
        this.stock = stock;
    }

    public int getStock_critico() {
        return stock_critico;
    }

    public void setStock_critico(int stock_critico) {
        this.stock_critico = stock_critico;
    }
    
    public AgregarMedicamentoManagedBean() {
    }
    
    public void agregar(ActionEvent e){
        
        Medicamento m = new Medicamento();
        m.setNombre_medicamento(nombre_medicamento);
        m.setTipo(tipo);
        m.setDetalle(detalle);
        m.setStock(stock);
        m.setStock_critico(stock_critico);
        
        medicamentosDAO.add(m);
        FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Medicamento agregdo"));
        
    }
    
}
