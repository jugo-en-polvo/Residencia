package cl.usm.residenciaEjb.dto;

import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

/**
 *
 * @author Esteban
 */

@Entity
@Table(name="usuarios")
@NamedQueries(
        {
            @NamedQuery(name = "Usuario.findAll", query = "SELECT u FROM Usuario u"),
            @NamedQuery(name = "Usuario.findAllByEstado", query = "SELECT u FROM Usuario u WHERE u.estado = :estado"),
            @NamedQuery(name = "Usuario.findAllByNiveldeAcceso", query = "SELECT u FROM Usuario u WHERE u.nivel_acceso = :acceso"),
            @NamedQuery(name = "Usuario.findByRutYClave", query = "SELECT u FROM Usuario u WHERE u.rut_usuario=:rut AND u.clave=:clave AND u.estado = FALSE"),
            @NamedQuery(name = "Usuario.CompruebaExistencia", query = "SELECT u FROM Usuario u WHERE u.rut_usuario = :rut")
        }
)
public class Usuario implements Serializable {
    
    @Id
    private String rut_usuario;
    private String nombre_usuario;
    private String clave;
    private int nivel_acceso;
    private int estado;

    public String getRut_usuario() {
        return rut_usuario;
    }

    public void setRut_usuario(String rut_usuario) {
        this.rut_usuario = rut_usuario;
    }

    public String getNombre_usuario() {
        return nombre_usuario;
    }

    public void setNombre_usuario(String nombre_usuario) {
        this.nombre_usuario = nombre_usuario;
    }

    public String getClave() {
        return clave;
    }

    public void setClave(String clave) {
        this.clave = clave;
    }

    public int getNivel_acceso() {
        return nivel_acceso;
    }

    public void setNivel_acceso(int nivel_acceso) {
        this.nivel_acceso = nivel_acceso;
    }

    public int getEstado() {
        return estado;
    }

    public void setEstado(int estado) {
        this.estado = estado;
    }
}