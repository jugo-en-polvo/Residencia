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
public class DietaID implements Serializable{
        
    private Calendar fecha_dieta;
    private String residente;

    public DietaID(Calendar fecha_dieta, String residente) {
        this.fecha_dieta = fecha_dieta;
        this.residente = residente;
    }

    public Calendar getFecha_dieta() {
        return fecha_dieta;
    }

    public String getResidente() {
        return residente;
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 79 * hash + Objects.hashCode(this.fecha_dieta);
        hash = 79 * hash + Objects.hashCode(this.residente);
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
        final DietaID other = (DietaID) obj;
        if (!Objects.equals(this.residente, other.residente)) {
            return false;
        }
        if (!Objects.equals(this.fecha_dieta, other.fecha_dieta)) {
            return false;
        }
        return true;
    }

}
