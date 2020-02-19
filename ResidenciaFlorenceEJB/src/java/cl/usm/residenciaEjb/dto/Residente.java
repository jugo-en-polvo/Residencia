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
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
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
@Table(name = "residente")
@NamedQueries({
    @NamedQuery(name = "Residente.findAll", query = "SELECT r FROM Residente r")
})
public class Residente implements Serializable{

    @Id
    private String rut_residente;
    private String nombre_residente;
    @Temporal(TemporalType.TIMESTAMP)
    private Calendar fecha_nacimiento;
    @Temporal(TemporalType.TIMESTAMP)
    private Calendar fecha_ingreso;
    private String sexo;
    private String estado;
    
    @JoinColumn(name = "rut_apoderado", nullable = false)
    @ManyToOne(optional = false, cascade = CascadeType.MERGE, fetch = FetchType.EAGER)
    private Apoderado apoderado;
    
    @JoinColumn(name = "id_prevision", nullable = false)
    @ManyToOne(optional = false, cascade = CascadeType.MERGE, fetch = FetchType.EAGER)
    private Prevision prevision;

    public String getRut_residente() {
        return rut_residente;
    }

    public void setRut_residente(String rut_residente) {
        this.rut_residente = rut_residente;
    }

    public String getNombre_residente() {
        return nombre_residente;
    }

    public void setNombre_residente(String nombre_residente) {
        this.nombre_residente = nombre_residente;
    }

    public Calendar getFecha_nacimiento() {
        return fecha_nacimiento;
    }

    public void setFecha_nacimiento(Calendar fecha_nacimiento) {
        this.fecha_nacimiento = fecha_nacimiento;
    }

    public Calendar getFecha_ingreso() {
        return fecha_ingreso;
    }

    public void setFecha_ingreso(Calendar fecha_ingreso) {
        this.fecha_ingreso = fecha_ingreso;
    }

    public String getSexo() {
        return sexo;
    }

    public void setSexo(String sexo) {
        this.sexo = sexo;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public Apoderado getApoderado() {
        return apoderado;
    }

    public void setApoderado(Apoderado apoderado) {
        this.apoderado = apoderado;
    }

    public Prevision getPrecision() {
        return prevision;
    }

    public void setPrecision(Prevision precision) {
        this.prevision = precision;
    }
    
    
}
