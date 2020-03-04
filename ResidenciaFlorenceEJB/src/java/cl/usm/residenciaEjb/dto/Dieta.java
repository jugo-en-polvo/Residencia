/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cl.usm.residenciaEjb.dto;

import java.io.Serializable;
import java.util.Calendar;
import java.util.Date;
import javax.persistence.CascadeType;
import javax.persistence.EmbeddedId;
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
@IdClass(DietaID.class)
@Table(name = "dieta")
@NamedQueries({
    @NamedQuery(name = "Dieta.findAll", query = "SELECT d FROM Dieta d"),
    @NamedQuery(name = "Dieta.findByRut", query = "SELECT d FROM Dieta d WHERE d.residente.rut_residente = :rut_residente"),
    @NamedQuery(name = "Dieta.findByFecha", query = "SELECT d FROM Dieta d WHERE d.fecha_dieta = :fecha")
})
public class Dieta implements Serializable{
    
    @Id
    @Temporal(TemporalType.TIMESTAMP)
    private Calendar fecha_dieta;
    
    @Id
    @JoinColumn(name = "rut_residente", nullable = false)
    @ManyToOne(optional = false, cascade = CascadeType.MERGE, fetch = FetchType.EAGER)
    private Residente residente;
    
    private boolean desayuno;
    private boolean colacion_1;
    private boolean almuerzo;
    private boolean colacion_2;
    private boolean once;
    private boolean cena;
    private String observaciones;

    public Calendar getFecha_dieta() {
        return fecha_dieta;
    }

    public void setFecha_dieta(Calendar fecha_dieta) {
        this.fecha_dieta = fecha_dieta;
    }

    public Residente getResidente() {
        return residente;
    }

    public void setResidente(Residente residente) {
        this.residente = residente;
    }

    public boolean isDesayuno() {
        return desayuno;
    }

    public void setDesayuno(boolean desayuno) {
        this.desayuno = desayuno;
    }

    public boolean isColacion_1() {
        return colacion_1;
    }

    public void setColacion_1(boolean colacion_1) {
        this.colacion_1 = colacion_1;
    }

    public boolean isAlmuerzo() {
        return almuerzo;
    }

    public void setAlmuerzo(boolean almuerzo) {
        this.almuerzo = almuerzo;
    }

    public boolean isColacion_2() {
        return colacion_2;
    }

    public void setColacion_2(boolean colacion_2) {
        this.colacion_2 = colacion_2;
    }

    public boolean isOnce() {
        return once;
    }

    public void setOnce(boolean once) {
        this.once = once;
    }

    public boolean isCena() {
        return cena;
    }

    public void setCena(boolean cena) {
        this.cena = cena;
    }

    public String getObservaciones() {
        return observaciones;
    }

    public void setObservaciones(String observaciones) {
        this.observaciones = observaciones;
    }

    
    
    
}
