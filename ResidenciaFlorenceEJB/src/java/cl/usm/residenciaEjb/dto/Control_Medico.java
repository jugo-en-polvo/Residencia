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
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 *
 * @author Senpai
 */
@Entity
@Table(name = "controles_medicos")
@NamedQueries({
    @NamedQuery(name = "Control_Medico.findAll", query = "SELECT cm FROM Control_Medico cm"),
    @NamedQuery(name = "Control_Medico.findByRut", query = "SELECT cm FROM Control_Medico cm WHERE cm.residente.rut_residente = :rut_residente")
})
public class Control_Medico implements Serializable{
    
    @Id
    @Temporal(TemporalType.TIMESTAMP)
    private Calendar fecha_hora_control;
    
    private String estado_control;
    private String observaciones;
    
    @Id
    @JoinColumn(name = "rut_residente", nullable = false)
    @ManyToOne(optional = false, cascade = CascadeType.MERGE, fetch = FetchType.EAGER)
    private Residente residente;
    
    @JoinColumn(name = "id_lugar", nullable = false)
    @ManyToOne(optional = false, cascade = CascadeType.MERGE, fetch = FetchType.EAGER)
    private Lugar lugar;

    public Calendar getFecha_hora_control() {
        return fecha_hora_control;
    }

    public void setFecha_hora_control(Calendar fecha_hora_control) {
        this.fecha_hora_control = fecha_hora_control;
    }

    public String getEstado_control() {
        return estado_control;
    }

    public void setEstado_control(String estado_control) {
        this.estado_control = estado_control;
    }

    public String getObservaciones() {
        return observaciones;
    }

    public void setObservaciones(String observaciones) {
        this.observaciones = observaciones;
    }

    public Residente getResidente() {
        return residente;
    }

    public void setResidente(Residente residente) {
        this.residente = residente;
    }

    public Lugar getLugar() {
        return lugar;
    }

    public void setLugar(Lugar lugar) {
        this.lugar = lugar;
    }
    
    
}
