/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cl.usm.residenciaEjb.dto;

import java.io.Serializable;
import java.util.Calendar;
import java.util.Objects;

/**
 *
 * @author Senpai
 */
public class Administrar_MedicamentoID implements Serializable{
    
    private long tratamiento;
    private Calendar fecha_administracion;

    public long getTratamiento() {
        return tratamiento;
    }

    public Calendar getFecha_administracion() {
        return fecha_administracion;
    }

    public Administrar_MedicamentoID(long tratamiento, Calendar fecha_administracion) {
        this.tratamiento = tratamiento;
        this.fecha_administracion = fecha_administracion;
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 61 * hash + (int) (this.tratamiento ^ (this.tratamiento >>> 32));
        hash = 61 * hash + Objects.hashCode(this.fecha_administracion);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Administrar_MedicamentoID other = (Administrar_MedicamentoID) obj;
        if (this.tratamiento != other.tratamiento) {
            return false;
        }
        if (!Objects.equals(this.fecha_administracion, other.fecha_administracion)) {
            return false;
        }
        return true;
    }
    
}
