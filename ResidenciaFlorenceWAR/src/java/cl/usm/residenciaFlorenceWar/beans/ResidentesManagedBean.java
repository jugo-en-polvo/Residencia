/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cl.usm.residenciaFlorenceWar.beans;

import cl.usm.residenciaEjb.dao.ApoderadoDAOLocal;
import cl.usm.residenciaEjb.dao.PrevisionDAOLocal;
import cl.usm.residenciaEjb.dao.ResidenteDAOLocal;
import cl.usm.residenciaEjb.dto.Residente;
import java.io.Serializable;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.faces.event.ActionEvent;
import javax.inject.Named;
import javax.faces.view.ViewScoped;
import javax.inject.Inject;

/**
 *
 * @author Senpai
 */
@Named(value = "residentesManagedBean")
@ViewScoped
public class ResidentesManagedBean implements Serializable {

    @Inject
    private ResidenteDAOLocal residenteDAO;
    @Inject
    private PrevisionDAOLocal previsionDAO;
    @Inject
    private ApoderadoDAOLocal apoderadoDAO;

    private List<Residente> residentes;
    private Map<String, String> residentesCombo = new HashMap<String, String>();
    //atributos de residentes a agregar
    private String rutResidente;
    private String Nombre;
    private Date fechaNacimieto;
    private Date fechaIngreso;
    private Date fechaEgreso;
    private String sexo;
    private String alergias;
    private String observaciones;
    private String regimenAlimentario;
    //claves foraneas de residentes
    private long idPrevision;
    private String rutApoderado;

    private boolean hidden = true;

    public boolean isHidden() {
        return hidden;
    }

    public void setHidden(boolean hidden) {
        this.hidden = hidden;
    }

    public void showOrHide() {
        if (rutApoderado.equals("true")) {
            hidden = true;
        } else if (rutApoderado.equals("false")) {
            hidden = false;
        } else {
            hidden = false;
        }
    }

    public Map<String, String> getResidentesCombo() {
        return residentesCombo;
    }

    public void setResidentesCombo(Map<String, String> residentesCombo) {
        this.residentesCombo = residentesCombo;
    }

    public Date getFechaEgreso() {
        return fechaEgreso;
    }

    public void setFechaEgreso(Date fechaEgreso) {
        this.fechaEgreso = fechaEgreso;
    }

    public String getAlergias() {
        return alergias;
    }

    public void setAlergias(String alergias) {
        this.alergias = alergias;
    }

    public String getObservaciones() {
        return observaciones;
    }

    public void setObservaciones(String observaciones) {
        this.observaciones = observaciones;
    }

    public String getRutResidente() {
        return rutResidente;
    }

    public void setRutResidente(String rutResidente) {
        this.rutResidente = rutResidente;
    }

    public String getNombre() {
        return Nombre;
    }

    public String getRegimenAlimentario() {
        return regimenAlimentario;
    }

    public void setRegimenAlimentario(String regimenAlimentario) {
        this.regimenAlimentario = regimenAlimentario;
    }

    public void setNombre(String Nombre) {
        this.Nombre = Nombre;
    }

    public Date getFechaNacimieto() {
        return fechaNacimieto;
    }

    public void setFechaNacimieto(Date fechaNacimieto) {
        this.fechaNacimieto = fechaNacimieto;
    }

    public Date getFechaIngreso() {
        return fechaIngreso;
    }

    public void setFechaIngreso(Date fechaIngreso) {
        this.fechaIngreso = fechaIngreso;
    }

    public String getSexo() {
        return sexo;
    }

    public void setSexo(String sexo) {
        this.sexo = sexo;
    }

    public long getIdPrevision() {
        return idPrevision;
    }

    public void setIdPrevision(long idPrevision) {
        this.idPrevision = idPrevision;
    }

    public String getRutApoderado() {
        return rutApoderado;
    }

    public void setRutApoderado(String rutApoderado) {
        this.rutApoderado = rutApoderado;
    }

    @PostConstruct
    public void init() {
        this.residentes = this.residenteDAO.findAll();
        for (Residente re : residentes) {
            residentesCombo.put(re.getNombre_residente(), re.getRut_residente());
        }
    }

    public ResidentesManagedBean() {
    }

    public List<Residente> getResidentes() {
        return residentes;
    }

    public void setResidentes(List<Residente> residentes) {
        this.residentes = residentes;
    }

    public void agregarResidente(ActionEvent e) {

        Residente r = new Residente();
        r.setRut_residente(rutResidente);
        r.setNombre_residente(Nombre);

        Calendar fechaNacimientoConvertida = Calendar.getInstance();
        fechaNacimientoConvertida.setTime(fechaNacimieto);
        r.setFecha_nacimiento(fechaNacimientoConvertida);

        Calendar fechaIngresoConvertida = Calendar.getInstance();
        fechaIngresoConvertida.setTime(fechaIngreso);
        r.setFecha_ingreso(fechaIngresoConvertida);
        r.setFecha_egreso(null);

        r.setSexo(sexo);
        r.setAlergias(alergias);
        r.setObservaciones(observaciones);
        r.setRegimen_alimentario(regimenAlimentario);
        r.setApoderado(this.apoderadoDAO.find(rutApoderado));
        r.setPrevision(this.previsionDAO.find(idPrevision));

        if (rutApoderado.length() == 11) {
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Rut muy Corto"));    
        } else {
            this.residenteDAO.add(r);
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Residente Agregado"));
        }
    }

}
