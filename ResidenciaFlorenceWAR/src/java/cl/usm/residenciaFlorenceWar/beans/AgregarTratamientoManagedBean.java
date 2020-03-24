/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cl.usm.residenciaFlorenceWar.beans;

import cl.usm.residenciaEjb.dao.MedicamentoDAOLocal;
import cl.usm.residenciaEjb.dao.ResidenteDAOLocal;
import cl.usm.residenciaEjb.dao.TratamientosDAOLocal;
import cl.usm.residenciaEjb.dao.UsuariosDAOLocal;
import cl.usm.residenciaEjb.dto.Tratamiento;
import java.io.IOException;
import java.io.Serializable;
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
@Named(value = "agregarTratamientoManagedBean")
@ViewScoped
public class AgregarTratamientoManagedBean implements Serializable {

    @Inject
    private TratamientosDAOLocal tratamientosDAO;
    @Inject
    private ResidenteDAOLocal residenteDAO;
    @Inject
    private MedicamentoDAOLocal medicamentosDAO;
    @Inject
    private UsuariosDAOLocal usuarioDAO;
    @Inject
    private LoginManagedBean UsuarioConectado;
    private String rutResidente;
    private String idMedicamento;
    private double dosis;
    private String hora;
    private String Periodo;

    public String getPeriodo() {
        return Periodo;
    }

    public void setPeriodo(String Periodo) {
        this.Periodo = Periodo;
    }

    public String getRutResidente() {
        return rutResidente;
    }

    public void setRutResidente(String rutResidente) {
        this.rutResidente = rutResidente;
    }

    public String getIdMedicamento() {
        return idMedicamento;
    }

    public void setIdMedicamento(String idMedicamento) {
        this.idMedicamento = idMedicamento;
    }

    public double getDosis() {
        return dosis;
    }

    public void setDosis(double dosis) {
        this.dosis = dosis;
    }

    public String getHora() {
        return hora;
    }

    public void setHora(String hora) {
        this.hora = hora;
    }

    public AgregarTratamientoManagedBean() {
    }

    public void agregar(ActionEvent e) throws IOException {

        if (!validaHora(hora)) {
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Hora no válida"));
        } else {

            if (tratamientosDAO.verExistencia(rutResidente, Long.parseLong(idMedicamento), hora)) {
                FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Advertencia", "Ya existe un tratamiento similar para este Residente"));
            } else {
                Tratamiento t = new Tratamiento();
                t.setResidente(residenteDAO.find(rutResidente));
                t.setMedicamento(medicamentosDAO.find(Long.parseLong(idMedicamento)));
                t.setDosis(dosis);
                t.setHora(hora);
                t.setUsuario(usuarioDAO.find(UsuarioConectado.getRut()));
                t.setPeriodo(Periodo);
                tratamientosDAO.add(t);

                FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Tratamiento Agregado"));
            }

        }
    }

    private boolean validaHora(String hora) {

        String horas = hora.substring(0, hora.indexOf(":"));
        String minutos = hora.substring(hora.indexOf(":") + 1, hora.length());

        if (Integer.parseInt(horas) > 23 || Integer.parseInt(minutos) > 59) {
            return false;
        } else {
            return true;
        }
    }
}
