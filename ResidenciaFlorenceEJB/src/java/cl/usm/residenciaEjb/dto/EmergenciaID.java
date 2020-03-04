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
public class EmergenciaID implements Serializable{
    
    private Calendar fecha_emergencia;
    private String residente;

    public Calendar getFecha_emergencia() {
        return fecha_emergencia;
    }

    public String getResidente() {
        return residente;
    }

    public EmergenciaID(Calendar fecha_emergencia, String residente) {
        this.fecha_emergencia = fecha_emergencia;
        this.residente = residente;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 59 * hash + Objects.hashCode(this.fecha_emergencia);
        hash = 59 * hash + Objects.hashCode(this.residente);
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
        final EmergenciaID other = (EmergenciaID) obj;
        if (!Objects.equals(this.residente, other.residente)) {
            return false;
        }
        if (!Objects.equals(this.fecha_emergencia, other.fecha_emergencia)) {
            return false;
        }
        return true;
    }
    
}
