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
    private String descripcion;
    private String tipo_prevision;
    
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "prevision")
    private List<PrevisionNombreTipo> previsionNombreTipos;

    public long getId_prevision() {
        return id_prevision;
    }

    public void setId_prevision(long id_prevision) {
        this.id_prevision = id_prevision;
    }

    public String getTipo_prevision() {
        return tipo_prevision;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }
    
    
    
    public void setTipo_prevision(String tipo_prevision) {
        this.tipo_prevision = tipo_prevision;
    }

    public List<PrevisionNombreTipo> getPrevisionNombreTipos() {
        return previsionNombreTipos;
    }

    public void setPrevisionNombreTipos(List<PrevisionNombreTipo> previsionNombreTipos) {
        this.previsionNombreTipos = previsionNombreTipos;
    }
    
}
