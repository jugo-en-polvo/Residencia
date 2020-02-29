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
@Table(name = "lugar")
@NamedQueries({
    @NamedQuery(name = "Lugar.findAll", query = "SELECT l FROM Lugar l"),
    @NamedQuery(name = "Lugar.findByName", query = "SELECT l FROM Lugar l WHERE l.nombre_lugar = :nombre_lugar")
})
public class Lugar implements Serializable{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id_lugar;
    private String nombre_lugar;
    private String fono_lugar;
    private String direccion_lugar;
    
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "lugar")
    private List<Control_Medico> controlesMedicos;

    public long getId_lugar() {
        return id_lugar;
    }

    public void setId_lugar(long id_lugar) {
        this.id_lugar = id_lugar;
    }

    public String getNombre_lugar() {
        return nombre_lugar;
    }

    public void setNombre_lugar(String nombre_lugar) {
        this.nombre_lugar = nombre_lugar;
    }

    public String getFono_lugar() {
        return fono_lugar;
    }

    public void setFono_lugar(String fono_lugar) {
        this.fono_lugar = fono_lugar;
    }

    public String getDireccion_lugar() {
        return direccion_lugar;
    }

    public void setDireccion_lugar(String direccion_lugar) {
        this.direccion_lugar = direccion_lugar;
    }

    public List<Control_Medico> getControlesMedicos() {
        return controlesMedicos;
    }

    public void setControlesMedicos(List<Control_Medico> controlesMedicos) {
        this.controlesMedicos = controlesMedicos;
    }
    
}
