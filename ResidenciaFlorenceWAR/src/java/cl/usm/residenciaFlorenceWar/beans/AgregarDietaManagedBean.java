/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cl.usm.residenciaFlorenceWar.beans;

import cl.usm.residenciaEjb.dao.DietaDAOLocal;
import cl.usm.residenciaEjb.dao.ResidenteDAOLocal;
import cl.usm.residenciaEjb.dto.Dieta;
import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.inject.Named;
import javax.faces.view.ViewScoped;
import javax.inject.Inject;

/**
 *
 * @author Senpai
 */
@Named(value = "agregarDietaManagedBean")
@ViewScoped
public class AgregarDietaManagedBean implements Serializable {

    @Inject
    private DietaDAOLocal dietaDAO;
    @Inject
    private ResidenteDAOLocal residenteDAO;
    private Dieta laDieta;
    private String rutResidente;
    private boolean desayuno;
    private boolean colacion_1;
    private boolean almuerzo;
    private boolean colacion_2;
    private boolean once;
    private boolean cena;
    private String observaciones;
    private boolean hidden = true;

    public boolean isHidden() {
        return hidden;
    }

    public void setHidden(boolean hidden) {
        this.hidden = hidden;
    }

    public void showOrHide() {
        if (rutResidente.equals("true")) {
            hidden = true;
        } else if (rutResidente.equals("false")) {
            hidden = false;
        } else {
            hidden = false;
        }
    }

    public boolean isDesayuno() {
        return desayuno;
    }

    public void setDesayuno(boolean desayuno) {
        this.desayuno = desayuno;
    }

    public boolean isColacion_1() {
        return colacion_1;
    }

    public void setColacion_1(boolean colacion_1) {
        this.colacion_1 = colacion_1;
    }

    public boolean isAlmuerzo() {
        return almuerzo;
    }

    public void setAlmuerzo(boolean almuerzo) {
        this.almuerzo = almuerzo;
    }

    public boolean isColacion_2() {
        return colacion_2;
    }

    public void setColacion_2(boolean colacion_2) {
        this.colacion_2 = colacion_2;
    }

    public boolean isOnce() {
        return once;
    }

    public void setOnce(boolean once) {
        this.once = once;
    }

    public boolean isCena() {
        return cena;
    }

    public void setCena(boolean cena) {
        this.cena = cena;
    }

    public String getObservaciones() {
        return observaciones;
    }

    public void setObservaciones(String observaciones) {
        this.observaciones = observaciones;
    }

    public Dieta getLaDieta() {
        return laDieta;
    }

    public void setLaDieta(Dieta laDieta) {
        this.laDieta = laDieta;
    }

    public String getRutResidente() {
        return rutResidente;
    }

    public void setRutResidente(String rutResidente) {
        this.rutResidente = rutResidente;
    }

    public AgregarDietaManagedBean() {
    }

    public void manejarFiltroDieta() throws Exception {

        Date today = Calendar.getInstance().getTime();
        SimpleDateFormat formato = new SimpleDateFormat("yyyy-MM-dd");
        String fechaString = formato.format(today);
        Date fechaBuscar = new SimpleDateFormat("yyyy-MM-dd").parse(fechaString);
        Calendar fechaBuscarConvertida = Calendar.getInstance();
        fechaBuscarConvertida.setTime(fechaBuscar);

        if (!rutResidente.equals("true")) {
            if (dietaDAO.findByCompositeKey(fechaBuscarConvertida, rutResidente) == null) {
                Dieta d = new Dieta();
                d.setResidente(residenteDAO.find(rutResidente));
                d.setFecha_dieta(fechaBuscarConvertida);
                d.setDesayuno(false);
                d.setColacion_1(false);
                d.setAlmuerzo(false);
                d.setColacion_2(false);
                d.setOnce(false);
                d.setCena(false);
                dietaDAO.add(d);
                crearVista(d);
                mensaje("Registro para hoy creado");
            } else {
                crearVista(dietaDAO.findByCompositeKey(fechaBuscarConvertida, rutResidente));
                mensaje("Obteniendo datos de hoy");
            }

        }
        showOrHide();
    }

    public boolean mensajesDesayuno() {
        if (desayuno == false) {
            mensaje("Desayuno No Consumida");
            update();
        } else {
            update();
            mensaje("Desayuno Consumida");
        }
        return true;
    }

    public boolean mensajesColacion1() {
        if (colacion_1 == false) {
            mensaje("Primera Colacion No Consumida");
            update();
        } else {
            update();
            mensaje("PrimeraColacion Consumida");
        }
        return true;
    }

    public boolean mensajesAlmuerzo() {
        if (almuerzo == false) {
            mensaje("Almuerzo No Consumida");
            update();
        } else {
            update();
            mensaje("Almuerzo Consumida");
        }
        return true;
    }

    public boolean mensajesColacion2() {
        if (colacion_2 == false) {
            mensaje("Segunda Colacion No Consumida");
            update();
        } else {
            update();
            mensaje("Segunda Colacion Consumida");
        }
        return true;
    }

    public boolean mensajesOnce() {
        if (once == false) {
            mensaje("Once No Consumida");
            update();
        } else {
            update();
            mensaje("Once Consumida");
        }
        return true;
    }

    public boolean mensajesCena() {
        if (cena == false) {
            mensaje("Cena No Consumida");
            update();
        } else {
            update();
            mensaje("Cena Consumida");
        }
        return true;
    }

    public void agregarObservacion() {
        update();
    }

    public void update() {
        Dieta d = new Dieta();
        d.setResidente(laDieta.getResidente());
        d.setFecha_dieta(laDieta.getFecha_dieta());
        d.setDesayuno(desayuno);
        d.setColacion_1(colacion_1);
        d.setAlmuerzo(almuerzo);
        d.setColacion_2(colacion_2);
        d.setOnce(once);
        d.setCena(cena);
        d.setObservaciones(observaciones);
        dietaDAO.update(d);
        mensaje("Valor actualizado");
    }

    public void mensaje(String msg) {
        FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(msg));
    }

    public void crearVista(Dieta d) {
        laDieta = d;
        desayuno = laDieta.isDesayuno();
        colacion_1 = laDieta.isColacion_1();
        almuerzo = laDieta.isAlmuerzo();
        colacion_2 = laDieta.isColacion_2();
        once = laDieta.isOnce();
        cena = laDieta.isCena();
        observaciones = laDieta.getObservaciones();
    }

}
