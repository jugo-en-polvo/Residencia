/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cl.usm.residenciaEjb.dto;

import java.io.Serializable;
import java.util.Calendar;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

/**
 *
 * @author Senpai
 */
@Entity
@Table(name = "control")
@NamedQueries({
    @NamedQuery(name = "Control.findByRut", query = "SELECT c FROM Control c WHERE c.residente.rut_residente = :rut")
})
public class Control implements Serializable{
    
    @Id
    private Calendar fecha_hora_control;
    @JoinColumn(name = "rut_residente", nullable = false)
    @ManyToOne(optional = false, cascade = CascadeType.MERGE, fetch = FetchType.EAGER)
    private Residente residente;
    private String presion_arterial;
    private String pulso;
    private String saturacion;
    private String hgt;
    private String cambio_posicion;
    private String solucion_parenteral;
    private String suero;
    private String observaciones;

    public Calendar getFecha_hora_control() {
        return fecha_hora_control;
    }

    public void setFecha_hora_control(Calendar fecha_hora_control) {
        this.fecha_hora_control = fecha_hora_control;
    }

    public Residente getResidente() {
        return residente;
    }

    public void setResidente(Residente residente) {
        this.residente = residente;
    }

    public String getPresion_arterial() {
        return presion_arterial;
    }

    public void setPresion_arterial(String presion_arterial) {
        this.presion_arterial = presion_arterial;
    }

    public String getPulso() {
        return pulso;
    }

    public void setPulso(String pulso) {
        this.pulso = pulso;
    }

    public String getSaturacion() {
        return saturacion;
    }

    public void setSaturacion(String saturacion) {
        this.saturacion = saturacion;
    }

    public String getHgt() {
        return hgt;
    }

    public void setHgt(String hgt) {
        this.hgt = hgt;
    }

    public String getCambio_posicion() {
        return cambio_posicion;
    }

    public void setCambio_posicion(String cambio_posicion) {
        this.cambio_posicion = cambio_posicion;
    }

    public String getSolucion_parenteral() {
        return solucion_parenteral;
    }

    public void setSolucion_parenteral(String solucion_parenteral) {
        this.solucion_parenteral = solucion_parenteral;
    }

    public String getSuero() {
        return suero;
    }

    public void setSuero(String suero) {
        this.suero = suero;
    }

    public String getObservaciones() {
        return observaciones;
    }

    public void setObservaciones(String observaciones) {
        this.observaciones = observaciones;
    }
    
}
