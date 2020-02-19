/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cl.usm.residenciaEjb.dto;

import java.io.Serializable;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 *
 * @author Senpai
 */
@Entity
@Table(name = "apoderado")
@NamedQueries({
    @NamedQuery(name = "Apoderado.findAll", query = "SELECT a FROM Apoderado a")
})
public class Apoderado implements Serializable{
    
    @Id
    private String rut_apoderado;
    private String nombre_apoderado;
    private String fono_apoderado;
    private String direccion_apoderado;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "apoderado")
    private List<Residente> residentes;

    public String getRut_apoderado() {
        return rut_apoderado;
    }

    public void setRut_apoderado(String rut_apoderado) {
        this.rut_apoderado = rut_apoderado;
    }

    public String getNombre_apoderado() {
        return nombre_apoderado;
    }

    public void setNombre_apoderado(String nombre_apoderado) {
        this.nombre_apoderado = nombre_apoderado;
    }

    public String getFono_apoderado() {
        return fono_apoderado;
    }

    public void setFono_apoderado(String fono_apoderado) {
        this.fono_apoderado = fono_apoderado;
    }

    public String getDireccion_apoderado() {
        return direccion_apoderado;
    }

    public void setDireccion_apoderado(String direccion_apoderado) {
        this.direccion_apoderado = direccion_apoderado;
    }

    public List<Residente> getResidentes() {
        return residentes;
    }

    public void setResidentes(List<Residente> residentes) {
        this.residentes = residentes;
    }
    
    
    
}
