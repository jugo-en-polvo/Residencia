/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cl.usm.residenciaFlorenceWar.beans;

import cl.usm.residenciaEjb.dao.Administrar_MedicamentoDAOLocal;
import cl.usm.residenciaEjb.dao.TratamientosDAOLocal;
import cl.usm.residenciaEjb.dto.Administrar_Medicamento;
import cl.usm.residenciaEjb.dto.Tratamiento;
import java.io.IOException;
import java.io.Serializable;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.inject.Named;
import javax.faces.view.ViewScoped;
import javax.inject.Inject;

/**
 *
 * @author Senpai
 */
@Named(value = "agregarAdministracionMedicacionManagedBean")
@ViewScoped
public class AgregarAdministracionMedicacionManagedBean implements Serializable {

    @Inject
    private TratamientosDAOLocal tratamientosDAO;
    @Inject
    private Administrar_MedicamentoDAOLocal administrarMedicacionDAO;
    @Inject
    private ActualizarMedicacionManagedBean actualizarMedicacionManagedBean;

    private String rutResidente = "vacio";
    private List<Administrar_Medicamento> medicacionFiltro;

    public List<Administrar_Medicamento> getMedicacionFiltro() {
        return medicacionFiltro;
    }

    public void setMedicacionFiltro(List<Administrar_Medicamento> medicacionFiltro) {
        this.medicacionFiltro = medicacionFiltro;
    }

    public String getRutResidente() {
        return rutResidente;
    }

    public void setRutResidente(String rutResidente) {
        this.rutResidente = rutResidente;
    }

    public AgregarAdministracionMedicacionManagedBean() {
    }

    public void manejarCreacionRegistro() throws ParseException {
        int cont = 0;
        boolean proceso = true;
        SimpleDateFormat formato = new SimpleDateFormat("yyyy-MM-dd");
        String fechaString = formato.format(new Date());
        Date fechaBuscar = new SimpleDateFormat("yyyy-MM-dd").parse(fechaString);

        Calendar fechaBuscarConvertida = Calendar.getInstance();
        fechaBuscarConvertida.setTime(fechaBuscar);

        if (!rutResidente.equals("vacio")) {
            for (Tratamiento t : tratamientosDAO.findByRut(rutResidente)) {
                if (administrarMedicacionDAO.findByCompositeKey(fechaBuscarConvertida, t.getId_tratamiento()) == null) {

                    Administrar_Medicamento am = new Administrar_Medicamento();

                    am.setTratamiento(t);
                    am.setFecha_administracion(fechaBuscarConvertida);
                    am.setObservaciones("");
                    am.setEstado(false);

                    administrarMedicacionDAO.add(am);
                    proceso = true;

                } else {

                    proceso = false;

                }
                cont++;
            }
        }
        if (proceso) {
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Se Crearon " + cont + " Registtros para Hoy"));
        } else {
            if (cont > 0) {
                FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Se Cargaron " + cont + " Registtros para Hoy"));
            }
        }
        manejarFiltro();
    }

    public void update(Administrar_Medicamento am) throws IOException {

        this.actualizarMedicacionManagedBean.setAmParaActualizar(am);
        FacesContext.getCurrentInstance().getExternalContext().redirect("editar_medicacion.xhtml");

    }
    
    public String verificarEstado(Administrar_Medicamento am){
        
        if(am.isEstado()){
            return "Consumido";
        }else{
            return "No Consumido";
        }
        
    }

    public void manejarFiltro() throws ParseException {

        SimpleDateFormat formato = new SimpleDateFormat("yyyy-MM-dd");
        String fechaString = formato.format(new Date());
        Date fechaBuscar = new SimpleDateFormat("yyyy-MM-dd").parse(fechaString);

        Calendar fechaBuscarConvertida = Calendar.getInstance();
        fechaBuscarConvertida.setTime(fechaBuscar);

        if (!rutResidente.equals("vacio")) {
            this.medicacionFiltro = administrarMedicacionDAO.findByRutAndFecha(rutResidente, fechaBuscarConvertida);
        } else {

        }

    }
}
