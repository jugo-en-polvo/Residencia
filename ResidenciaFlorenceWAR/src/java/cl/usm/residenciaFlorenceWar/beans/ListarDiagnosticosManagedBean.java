/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cl.usm.residenciaFlorenceWar.beans;

import cl.usm.residenciaEjb.dao.DiagnosticoDAOLocal;
import cl.usm.residenciaEjb.dto.Diagnostico;
import java.io.Serializable;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.inject.Named;
import javax.faces.view.ViewScoped;
import javax.inject.Inject;

/**
 *
 * @author Senpai
 */
@Named(value = "listarDiagnosticosManagedBean")
@ViewScoped
public class ListarDiagnosticosManagedBean implements Serializable {

    @Inject
    private DiagnosticoDAOLocal diagnosticoDAO;
    private List<Diagnostico> diagnosticosFiltro;
    private String rutResidente;

    public String getRutResidente() {
        return rutResidente;
    }

    public void setRutResidente(String rutResidente) {
        this.rutResidente = rutResidente;
    }

    public List<Diagnostico> getDiagnosticosFiltro() {
        return diagnosticosFiltro;
    }

    public void setDiagnosticosFiltro(List<Diagnostico> diagnosticosFiltro) {
        this.diagnosticosFiltro = diagnosticosFiltro;
    }

    public ListarDiagnosticosManagedBean() {
    }

    public void filtroDiagnotico() {

        if (rutResidente != null && !rutResidente.equals("")) {
            this.diagnosticosFiltro = diagnosticoDAO.findByRut(rutResidente);
        } else {
            //this.diagnosticosFiltro = diagnosticosFiltro.findAll();
        }

    }

}
