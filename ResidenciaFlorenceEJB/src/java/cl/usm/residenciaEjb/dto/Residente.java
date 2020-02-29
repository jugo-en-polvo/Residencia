/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cl.usm.residenciaEjb.dto;

import java.io.Serializable;
import java.util.Calendar;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
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
    @Temporal(TemporalType.TIMESTAMP)
    private Calendar fecha_egreso;
    private String sexo;
    private String alergias;
    private String observaciones;
    private String regimen_alimentario;
    
    @JoinColumn(name = "rut_apoderado", nullable = false)
    @ManyToOne(optional = false, cascade = CascadeType.MERGE, fetch = FetchType.EAGER)
    private Apoderado apoderado;
    
    @JoinColumn(name = "id_prevision", nullable = false)
    @ManyToOne(optional = false, cascade = CascadeType.MERGE, fetch = FetchType.EAGER)
    private Prevision prevision;
   
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "residente")
    private List<Tratamiento> tratamientos;

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

    public Apoderado getApoderado() {
        return apoderado;
    }

    public void setApoderado(Apoderado apoderado) {
        this.apoderado = apoderado;
    }

    public Prevision getPrevision() {
        return prevision;
    }

    public void setPrevision(Prevision prevision) {
        this.prevision = prevision;
    }

    public List<Tratamiento> getTratamientos() {
        return tratamientos;
    }

    public void setTratamientos(List<Tratamiento> tratamientos) {
        this.tratamientos = tratamientos;
    }

    public Calendar getFecha_egreso() {
        return fecha_egreso;
    }

    public void setFecha_egreso(Calendar fecha_egreso) {
        this.fecha_egreso = fecha_egreso;
    }

    public String getAlergias() {
        return alergias;
    }

    public void setAlergias(String alergias) {
        this.alergias = alergias;
    }

    public String getObservaciones() {
        return observaciones;
    }

    public void setObservaciones(String observaciones) {
        this.observaciones = observaciones;
    }

    public String getRegimen_alimentario() {
        return regimen_alimentario;
    }

    public void setRegimen_alimentario(String regimen_alimentario) {
        this.regimen_alimentario = regimen_alimentario;
    }
    
    
}
