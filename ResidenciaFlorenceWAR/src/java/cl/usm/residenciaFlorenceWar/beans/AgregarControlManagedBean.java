/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cl.usm.residenciaFlorenceWar.beans;

import cl.usm.residenciaEjb.dao.ControlDAOLocal;
import cl.usm.residenciaEjb.dao.ResidenteDAOLocal;
import cl.usm.residenciaEjb.dao.UsuariosDAOLocal;
import cl.usm.residenciaEjb.dto.Control;
import java.io.Serializable;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
//import javafx.beans.property.IntegerProperty;
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
@Named(value = "agregarControlManagedBean")
@ViewScoped
public class AgregarControlManagedBean implements Serializable {

    @Inject
    private ControlDAOLocal controlDAO;
    @Inject
    private ResidenteDAOLocal residenteDAO;
    @Inject
    private UsuariosDAOLocal usuarioDAO;
    @Inject
    private LoginManagedBean UsuarioConectado;
    private String rutResidente;
    private String presionArterial;
    private String pulso;
    private String saturacion;
    private String hgt;
    private String cambioPosicion;
    private String SolucionParenteral;
    private String suero;
    private String observaciones;

    public String getRutResidente() {
        return rutResidente;
    }

    public void setRutResidente(String rutResidente) {
        this.rutResidente = rutResidente;
    }

    public String getPresionArterial() {
        return presionArterial;
    }

    public void setPresionArterial(String presionArterial) {
        this.presionArterial = presionArterial;
    }

    public String getPulso() {
        return pulso;
    }

    public void setPulso(String pulso) {
        this.pulso = pulso;
    }

    public String getSaturacion() {
        return saturacion;
    }

    public void setSaturacion(String saturacion) {
        this.saturacion = saturacion;
    }

    public String getHgt() {
        return hgt;
    }

    public void setHgt(String hgt) {
        this.hgt = hgt;
    }

    public String getCambioPosicion() {
        return cambioPosicion;
    }

    public void setCambioPosicion(String cambioPosicion) {
        this.cambioPosicion = cambioPosicion;
    }

    public String getSolucionParenteral() {
        return SolucionParenteral;
    }

    public void setSolucionParenteral(String SolucionParenteral) {
        this.SolucionParenteral = SolucionParenteral;
    }

    public String getSuero() {
        return suero;
    }

    public void setSuero(String suero) {
        this.suero = suero;
    }

    public String getObservaciones() {
        return observaciones;
    }

    public void setObservaciones(String observaciones) {
        this.observaciones = observaciones;
    }

    public AgregarControlManagedBean() {
    }

    public void add(ActionEvent e) throws ParseException {

        if ("".equals(presionArterial) && "".equals(pulso) && "".equals(saturacion)
                && "".equals(hgt) && "".equals(cambioPosicion)
                && "".equals(SolucionParenteral) && "".equals(suero)) {
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Advertencia", "Para Debe llenar al menos un Control"));
        } else {
            if (validaPresion(presionArterial) && validaPulso(pulso) && validaSaturacion(saturacion)) {
                Control c = new Control();

                Date today = Calendar.getInstance().getTime();
                SimpleDateFormat formato = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
                String fechaString = formato.format(today);
                Date fechaBuscar = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss").parse(fechaString);
                Calendar fechaBuscarConvertida = Calendar.getInstance();
                fechaBuscarConvertida.setTime(fechaBuscar);

                c.setFecha_hora_control(fechaBuscarConvertida);
                c.setResidente(residenteDAO.find(rutResidente));
                c.setUsuario(usuarioDAO.find(UsuarioConectado.getRut()));

                c.setPresion_arterial(presionArterial);
                c.setPulso(pulso);
                c.setSaturacion(saturacion);
                c.setHgt(hgt);
                c.setCambio_posicion(cambioPosicion);
                c.setSolucion_parenteral(SolucionParenteral);
                c.setSuero(suero);
                c.setObservaciones(observaciones);
                controlDAO.add(c);
                FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Control Registrado"));
            }
        }

    }

    private boolean validaPresion(String p) {

        if ("".equals(p)) {
            return true;
        } else {
            if (!p.contains("/")) {
                FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Presión Arterial", "Formato inválido"));
                return false;
            } else {
                String sistoloca = p.substring(0, p.indexOf("/"));
                String diastolica = p.substring(p.indexOf("/") + 1, p.length());

                if (!sistoloca.chars().allMatch(Character::isDigit) || !diastolica.chars().allMatch(Character::isDigit)) {
                    FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Presión Arterial", "Valores no numéricos"));
                    return false;
                } else {
                    if (Integer.parseInt(sistoloca) < 0 || Integer.parseInt(diastolica) < 0
                            || Integer.parseInt(sistoloca) > 300 || Integer.parseInt(diastolica) > 300) {
                        FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Presión Arterial", "Valores Inválidos"));
                        return false;
                    } else {
                        return true;
                    }
                }
            }
        }

    }

    private boolean validaPulso(String p) {
        if ("".equals(p)) {
            return true;
        } else {
            if (p.chars().allMatch(Character::isDigit)) {
                if (Integer.parseInt(p) < 0 || Integer.parseInt(p) > 300) {
                    FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Pulso", "Valores inválidos"));
                    return false;
                } else {
                    return true;
                }
            } else {
                FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Pulso", "Valores no numéricos"));
                return false;
            }
        }
    }

    private boolean validaSaturacion(String s) {

        if ("".equals(s)) {
            return true;
        } else {
            if (s.chars().allMatch(Character::isDigit)) {
                if (Integer.parseInt(s) < 0 || Integer.parseInt(s) > 100) {
                    FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Saturación", "Valores inválidos"));
                    return false;
                } else {
                    return true;
                }
            } else {
                FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Saturación", "Valores no numéricos"));
                return false;
            }
        }
    }

}
