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
@Table(name = "prevision")
@NamedQueries({
    @NamedQuery(name = "Prevision.findAll", query = "SELECT p FROM Prevision p")
})
public class Prevision implements Serializable{
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id_prevision;
    private String nombre_prevision;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "prevision")
    private List<Residente> residentes;

    public long getId_prevision() {
        return id_prevision;
    }

    public void setId_prevision(long id_prevision) {
        this.id_prevision = id_prevision;
    }

    public String getNombre_prevision() {
        return nombre_prevision;
    }

    public void setNombre_prevision(String nombre_prevision) {
        this.nombre_prevision = nombre_prevision;
    }

    public List<Residente> getResidentes() {
        return residentes;
    }

    public void setResidentes(List<Residente> residentes) {
        this.residentes = residentes;
    }
    
}
