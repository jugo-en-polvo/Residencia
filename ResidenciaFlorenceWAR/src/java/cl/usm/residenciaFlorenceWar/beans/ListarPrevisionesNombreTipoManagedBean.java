/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cl.usm.residenciaFlorenceWar.beans;

import cl.usm.residenciaEjb.dao.PrevisionNombreTipoDAOLocal;
import cl.usm.residenciaEjb.dto.PrevisionNombreTipo;
import java.io.Serializable;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.annotation.PostConstruct;
import javax.enterprise.context.SessionScoped;
import javax.inject.Named;
import javax.inject.Inject;

/**
 *
 * @author Senpai
 */
@Named(value = "listarPrevisionesNombreTipoManagedBean")
@SessionScoped
public class ListarPrevisionesNombreTipoManagedBean implements Serializable {

    @Inject
    private PrevisionNombreTipoDAOLocal previsionesNombreTipoDAO;
    private List<PrevisionNombreTipo> previsionesNombreTipo;
    private Map<String, String> previsionesNombreTipoCombo = new HashMap<>();
    private String filtro = "";

    public String getFiltro() {
        return filtro;
    }

    public void setFiltro(String filtro) {
        this.filtro = filtro;
    }

    public List<PrevisionNombreTipo> getPrevisionesNombreTipo() {
        return previsionesNombreTipo;
    }

    public void setPrevisionesNombreTipo(List<PrevisionNombreTipo> previsionesNombreTipo) {
        this.previsionesNombreTipo = previsionesNombreTipo;
    }

    public Map<String, String> getPrevisionesNombreTipoCombo() {
        return previsionesNombreTipoCombo;
    }

    public void setPrevisionesNombreTipoCombo(Map<String, String> previsionesNombreTipoCombo) {
        this.previsionesNombreTipoCombo = previsionesNombreTipoCombo;
    }

    @PostConstruct
    public void init() {
        if (filtro.equals("")) {
            this.previsionesNombreTipo = previsionesNombreTipoDAO.findByTipo(1);
        } else {
            this.previsionesNombreTipo = previsionesNombreTipoDAO.findByTipo(Long.parseLong(filtro));
            previsionesNombreTipo.forEach((p) -> {
                previsionesNombreTipoCombo.put(p.getNombre_prevision(), Long.toString(p.getId_prevision_nombre_tipo()));
            });
        }
    }

    public ListarPrevisionesNombreTipoManagedBean() {
    }

    public void manejarCombo() {
        previsionesNombreTipoCombo.clear();
        this.previsionesNombreTipo = previsionesNombreTipoDAO.findByTipo(Long.parseLong(filtro));
        previsionesNombreTipo.forEach((p) -> {
            previsionesNombreTipoCombo.put(p.getNombre_prevision(), Long.toString(p.getId_prevision_nombre_tipo()));
        });
    }
}
