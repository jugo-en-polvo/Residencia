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
public class Control_MedicoID implements Serializable{
    
    private Calendar fecha_hora_control;
    private String residente;

    public Control_MedicoID(Calendar fecha_hora_control, String residente) {
        this.fecha_hora_control = fecha_hora_control;
        this.residente = residente;
    }

    public Calendar getFecha_hora_control() {
        return fecha_hora_control;
    }

    public String getResidente() {
        return residente;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 83 * hash + Objects.hashCode(this.fecha_hora_control);
        hash = 83 * hash + Objects.hashCode(this.residente);
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
        final Control_MedicoID other = (Control_MedicoID) obj;
        if (!Objects.equals(this.residente, other.residente)) {
            return false;
        }
        if (!Objects.equals(this.fecha_hora_control, other.fecha_hora_control)) {
            return false;
        }
        return true;
    }

   
    
}
