/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cl.usm.residenciaFlorenceWar.beans;

import cl.usm.residenciaEjb.dao.MedicamentoDAOLocal;
import cl.usm.residenciaEjb.dto.Medicamento;
import java.io.IOException;
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
    private String nombre;
    private String concentracion;
    private String presentacion;
    private String tipo;
    private String detalle;
    private int stock;
    private int stockCritico;

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    
    public int getStockCritico() {
        return stockCritico;
    }

    public void setStockCritico(int stockCritico) {
        this.stockCritico = stockCritico;
    }

    public String getConcentracion() {
        return concentracion;
    }

    public void setConcentracion(String concentracion) {
        this.concentracion = concentracion;
    }

    public String getPresentacion() {
        return presentacion;
    }

    public void setPresentacion(String presentacion) {
        this.presentacion = presentacion;
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
    
    public AgregarMedicamentoManagedBean() {
    }
    
    public void agregar(ActionEvent e) throws IOException{
        
        Medicamento m = new Medicamento();
        m.setNombre(nombre);
        m.setConcentracion(concentracion);
        m.setPresentacion(presentacion);
        m.setTipo(tipo);
        m.setDetalle(detalle);
        m.setStock(stock);
        m.setStock_critico(stockCritico);
        
        medicamentosDAO.add(m);
        FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Medicamento Agregado"));
        FacesContext.getCurrentInstance().getExternalContext().redirect("listar_medicamento.xhtml");
        
    }
    
}
