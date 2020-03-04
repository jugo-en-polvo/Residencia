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
@IdClass(Administrar_MedicamentoID.class)
@Table(name = "administrar_medicamento")
@NamedQueries({
    @NamedQuery(name = "AdministratMedicamento.findByRut", query = "SELECT am FROM Administrar_Medicamento am WHERE am.tratamiento.residente.rut_residente = :rut ORDER BY am.tratamiento.hora ASC"),
    @NamedQuery(name = "AdministrarMedicamento.findByRutAndFecha", query = "SELECT am FROM Administrar_Medicamento am WHERE am.tratamiento.residente.rut_residente = :rut AND am.fecha_administracion = :fecha ORDER BY am.tratamiento.hora ASC")
        
})
public class Administrar_Medicamento implements Serializable{
    
    @Id
    @JoinColumn(name = "id_tratamiento", nullable = false)
    @ManyToOne(optional = false, cascade = CascadeType.MERGE, fetch = FetchType.EAGER)
    private Tratamiento tratamiento;
    
    @Id
    @Temporal(TemporalType.TIMESTAMP)
    private Calendar fecha_administracion;
    
    @JoinColumn(name = "rut_usuario", nullable = false)
    @ManyToOne(optional = false, cascade = CascadeType.MERGE, fetch = FetchType.EAGER)
    private Usuario usuario;
    
    private boolean estado;
    private String observaciones;

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    public Tratamiento getTratamiento() {
        return tratamiento;
    }

    public void setTratamiento(Tratamiento tratamiento) {
        this.tratamiento = tratamiento;
    }

    public Calendar getFecha_administracion() {
        return fecha_administracion;
    }

    public void setFecha_administracion(Calendar fecha_administracion) {
        this.fecha_administracion = fecha_administracion;
    }

    public boolean isEstado() {
        return estado;
    }

    public void setEstado(boolean estado) {
        this.estado = estado;
    }

    public String getObservaciones() {
        return observaciones;
    }

    public void setObservaciones(String observaciones) {
        this.observaciones = observaciones;
    }
    
}
