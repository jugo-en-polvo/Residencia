/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cl.usm.residenciaFlorenceWar.beans;

import cl.usm.residenciaEjb.dao.MedicamentoDAOLocal;
import cl.usm.residenciaEjb.dto.Medicamento;
import java.io.Serializable;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.annotation.PostConstruct;
import javax.inject.Named;
import javax.faces.view.ViewScoped;
import javax.inject.Inject;

/**
 *
 * @author Senpai
 */
@Named(value = "listarMedicamentosManagedBean")
@ViewScoped
public class ListarMedicamentosManagedBean implements Serializable{

    @Inject
    private MedicamentoDAOLocal medicamentosDAO;
    private List<Medicamento> medicamentos;
    private Map<String, String> medicamentosCombo = new HashMap<String, String>();

    public List<Medicamento> getMedicamentos() {
        return medicamentos;
    }

    public void setMedicamentos(List<Medicamento> medicamentos) {
        this.medicamentos = medicamentos;
    }

    public Map<String, String> getMedicamentosCombo() {
        return medicamentosCombo;
    }

    public void setMedicamentosCombo(Map<String, String> medicamentosCombo) {
        this.medicamentosCombo = medicamentosCombo;
    }
    
    @PostConstruct
    public void init(){
        this.medicamentos = this.medicamentosDAO.findAll();
        for(Medicamento me: medicamentos){
            medicamentosCombo.put(me.getNombre_medicamento(), String.valueOf(me.getId_medicamento()));
        }
    }
    
    public ListarMedicamentosManagedBean() {
    }
    
}
