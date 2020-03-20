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
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 *
 * @author Senpai
 */
@Entity
@Table(name = "previsionnombretipo")
@NamedQueries({
    @NamedQuery(name = "PrevisionNombreTipo.findByTipo", query = "SELECT p FROM PrevisionNombreTipo p WHERE p.prevision.id_prevision = :tipoPrevision ORDER BY p.nombre_prevision ASC")
})
public class PrevisionNombreTipo implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id_prevision_nombre_tipo;
    private String descripcion;
    private String nombre_prevision;

    @JoinColumn(name = "id_prevision", nullable = false)
    @ManyToOne(optional = false, cascade = CascadeType.MERGE, fetch = FetchType.EAGER)
    private Prevision prevision;
    
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "previsionNombreTipo")
    private List<Residente> residentes; 

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }
    
    public long getId_prevision_nombre_tipo() {
        return id_prevision_nombre_tipo;
    }

    public void setId_prevision_nombre_tipo(long id_prevision_nombre_tipo) {
        this.id_prevision_nombre_tipo = id_prevision_nombre_tipo;
    }

    public String getNombre_prevision() {
        return nombre_prevision;
    }

    public void setNombre_prevision(String nombre_prevision) {
        this.nombre_prevision = nombre_prevision;
    }

    public Prevision getPrevision() {
        return prevision;
    }

    public void setPrevision(Prevision prevision) {
        this.prevision = prevision;
    }

    public List<Residente> getResidentes() {
        return residentes;
    }

    public void setResidentes(List<Residente> residentes) {
        this.residentes = residentes;
    }
    
}
