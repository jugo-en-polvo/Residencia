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
import javax.persistence.IdClass;
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
@IdClass(EmergenciaID.class)
@Table(name = "emergencia")
@NamedQueries({
    @NamedQuery(name = "Emergencia.findAll", query = "SELECT e FROM Emergencia e"),
    @NamedQuery(name = "Emergencia.findAllByRut", query = "SELECT e FROM Emergencia e WHERE e.residente.rut_residente = :rut"),
    @NamedQuery(name = "Emergencia.findThisWeek", query = "SELECT e FROM Emergencia e Where e.fecha_emergencia >= :fecha")
})
public class Emergencia implements Serializable{
    
    @Id
    @Temporal(TemporalType.TIMESTAMP)
    private Calendar fecha_emergencia;
    
    @Id
    @JoinColumn(name = "rut_residente", nullable = false)
    @ManyToOne(optional = false, cascade = CascadeType.MERGE, fetch = FetchType.EAGER)
    private Residente residente;
    
    @JoinColumn(name = "id_lugar", nullable = false)
    @ManyToOne(optional = false, cascade = CascadeType.MERGE, fetch = FetchType.EAGER)
    private Lugar lugar;
    
    private String observaciones;

    public Calendar getFecha_emergencia() {
        return fecha_emergencia;
    }

    public void setFecha_emergencia(Calendar fecha_emergencia) {
        this.fecha_emergencia = fecha_emergencia;
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

    public String getObservaciones() {
        return observaciones;
    }

    public void setObservaciones(String observaciones) {
        this.observaciones = observaciones;
    }
    
    
}
