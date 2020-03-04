/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cl.usm.residenciaEjb.dto;

import java.io.Serializable;
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

/**
 *
 * @author Senpai
 */
@Entity
@Table(name = "diagnostico")
@NamedQueries({
    @NamedQuery(name = "Diagnostico.findByRut", query = "SELECT d FROM Diagnostico d WHERE d.residente.rut_residente = :rut")
})
public class Diagnostico implements Serializable{
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id_diagnostico;
    @JoinColumn(name = "rut_residente", nullable = false)
    @ManyToOne(optional = false, cascade = CascadeType.MERGE, fetch = FetchType.EAGER)
    private Residente residente;
    
    private String enfermedad;
    private String descripcion;

    public long getId_diagnostico() {
        return id_diagnostico;
    }

    public void setId_diagnostico(long id_diagnostico) {
        this.id_diagnostico = id_diagnostico;
    }

    public Residente getResidente() {
        return residente;
    }

    public void setResidente(Residente residente) {
        this.residente = residente;
    }

    public String getEnfermedad() {
        return enfermedad;
    }

    public void setEnfermedad(String enfermedad) {
        this.enfermedad = enfermedad;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }
    
}
