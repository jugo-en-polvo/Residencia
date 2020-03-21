/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cl.usm.residenciaFlorenceWar.beans;

import cl.usm.residenciaEjb.dao.ApoderadoDAOLocal;
import cl.usm.residenciaEjb.dao.PrevisionNombreTipoDAOLocal;
import cl.usm.residenciaEjb.dao.ResidenteDAOLocal;
import cl.usm.residenciaEjb.dto.Apoderado;
import cl.usm.residenciaEjb.dto.Residente;
import cl.usm.residenciaFlorenceWar.utils.ValidadorRut;
import java.io.Serializable;
import java.util.Calendar;
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
@Named(value = "agregarResidenteApoderadoManagedBean")
@ViewScoped
public class AgregarResidenteApoderadoManagedBean implements Serializable {

    @Inject
    private ResidentesManagedBean residenteBean;
    @Inject
    private AgregarApoderadoManagedBean apoderadoBean;
    @Inject
    private ListarPrevisionesNombreTipoManagedBean previsionNombreTipoBEAN;
    @Inject
    private ResidenteDAOLocal residenteDAO;
    @Inject
    private ApoderadoDAOLocal apoderadosDAO;
    @Inject
    private PrevisionNombreTipoDAOLocal previsionNombreTipoDAO;

    public AgregarResidenteApoderadoManagedBean() {
    }

    public void agregar(ActionEvent e) {

        if (residenteDAO.compruebaExistencia(residenteBean.getRutResidente())) {
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Error", "Residente ya existe en el sistema."));
        } else if (apoderadosDAO.compruebaExistencia(apoderadoBean.getRutApoderado())) {
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Error", "Apoderado ya existe en el sistema."));
        } else if (residenteDAO.compruebaExistencia(residenteBean.getRutResidente()) && apoderadosDAO.compruebaExistencia(apoderadoBean.getRutApoderado())) {
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Error", "Residente y Apoderado ya existen en el sistema."));
        } else {

            if (ValidadorRut.validarRut(apoderadoBean.getRutApoderado()) && ValidadorRut.validarRut(residenteBean.getRutResidente())) {

                Residente r = new Residente();
                Apoderado a = new Apoderado();

                //Apoderado
                a.setRut_apoderado(apoderadoBean.getRutApoderado());
                a.setNombre_apoderado(apoderadoBean.getNombreApoderado());
                a.setFono_apoderado(Integer.toString(apoderadoBean.getFonoApoderado()));
                a.setDireccion_apoderado(apoderadoBean.getDireccionApoderado());
                a.setEmail_apoderado(apoderadoBean.getEmailApoderado());

                this.apoderadosDAO.add(a);

                //Residente
                r.setRut_residente(residenteBean.getRutResidente());
                r.setNombre_residente(residenteBean.getNombre());

                Calendar fechaNacimientoConvertida = Calendar.getInstance();
                fechaNacimientoConvertida.setTime(residenteBean.getFechaNacimieto());
                r.setFecha_nacimiento(fechaNacimientoConvertida);

                Calendar fechaIngresoConvertida = Calendar.getInstance();
                fechaIngresoConvertida.setTime(residenteBean.getFechaIngreso());
                r.setFecha_ingreso(fechaIngresoConvertida);

                r.setSexo(residenteBean.getSexo());
                r.setFecha_egreso(null);
                r.setRegimen_alimentario(residenteBean.getRegimenAlimentario());
                r.setAlergias(residenteBean.getAlergias());
                r.setObservaciones(residenteBean.getObservaciones());
                r.setApoderado(apoderadosDAO.find(apoderadoBean.getRutApoderado()));
                //r.setPrevision(this.previsionDAO.find(residenteBean.getIdPrevision()));
                r.setPrevisionNombreTipo(previsionNombreTipoDAO.find(residenteBean.getIdPrevision()));
                this.residenteDAO.add(r);

                FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Residente y Apoderado ingresados"));
            } else {
                if (!ValidadorRut.validarRut(apoderadoBean.getRutApoderado())) {
                    FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Rut de Apoderado inválido, reingrese."));
                } else if (!ValidadorRut.validarRut(residenteBean.getRutResidente())) {
                    FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Rut de Residente inválido, reingrese."));
                } else {
                    FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Rut de apoderado y residente inválidos, reingrese."));
                }
            }
        }
    }

    public void actualizarResidente() {
        residenteBean.setRutApoderado(apoderadoBean.getRutApoderado());
    }

}
