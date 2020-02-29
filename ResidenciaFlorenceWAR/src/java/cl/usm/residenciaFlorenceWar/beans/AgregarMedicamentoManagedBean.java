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
    private String nombreGenerico;
    private String nombreFantasia;
    private String tipo;
    private String detalle;
    private int stock;
    private int stockCritico;

    public String getNombreGenerico() {
        return nombreGenerico;
    }

    public void setNombreGenerico(String nombreGenerico) {
        this.nombreGenerico = nombreGenerico;
    }

    public String getNombreFantasia() {
        return nombreFantasia;
    }

    public void setNombreFantasia(String nombreFantasia) {
        this.nombreFantasia = nombreFantasia;
    }

    public int getStockCritico() {
        return stockCritico;
    }

    public void setStockCritico(int stockCritico) {
        this.stockCritico = stockCritico;
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
    
    public void agregar(ActionEvent e){
        
        Medicamento m = new Medicamento();
        m.setNombre_generico(nombreGenerico);
        m.setNombre_fantasia(nombreFantasia);
        m.setTipo(tipo);
        m.setDetalle(detalle);
        m.setStock(stock);
        m.setStock_critico(stockCritico);
        
        medicamentosDAO.add(m);
        FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Medicamento Agregado"));
        
    }
    
}
