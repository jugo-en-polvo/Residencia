package cl.usm.residenciaFlorenceWar.beans;

import cl.usm.residenciaEjb.dao.ControlDAOLocal;
import cl.usm.residenciaEjb.dto.Control;
import cl.usm.residenciaFlorenceWar.utils.NivelesUtils;
import java.io.Serializable;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.ZonedDateTime;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.List;
import javax.inject.Named;
import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import org.primefaces.model.chart.AxisType;
import org.primefaces.model.chart.DateAxis;
import org.primefaces.model.chart.LineChartModel;
import org.primefaces.model.chart.LineChartSeries;

@Named(value = "resumenMedicionesManagedBean")
@ViewScoped
public class ResumenMedicionesManagedBean implements Serializable{

    @Inject
    private ControlDAOLocal controlDAO;
    
    private List<Control> controles;
    private String rutResidente;
    private LineChartModel chartPresion;

    public LineChartModel getChartPresion() {
        return chartPresion;
    }

    public void setChartPresion(LineChartModel chartPresion) {
        this.chartPresion = chartPresion;
    }

    public List<Control> getControles() {
        return controles;
    }

    public void setControles(List<Control> controles) {
        this.controles = controles;
    }

    public String getRutResidente() {
        return rutResidente;
    }

    public void setRutResidente(String rutResidente) {
        this.rutResidente = rutResidente;
    }
    
    public ResumenMedicionesManagedBean() {
        
    }
    public void manejarFiltro(){
        if (!rutResidente.equals("falso")) {
            this.controles = controlDAO.findByRut(rutResidente);
            //poblarChartPresion(this.controles);
            
        } else {
            this.controles.clear();
        }

    }
    
    public void poblarChartPresion(List<Control> controls) {
        LineChartModel modelo = new LineChartModel();
        LineChartSeries sistole = new LineChartSeries();
        LineChartSeries diastole = new LineChartSeries();
        sistole.setFill(true);
        diastole.setFill(true);
        sistole.setLabel("Sístole");
        diastole.setLabel("Diástole");
        SimpleDateFormat sdf = new SimpleDateFormat("MM yyyy");
        
        for (Control controlTmp : controls){
            sistole.set(sdf.format(controlTmp.getFecha_hora_control().getTime())
                    ,Integer.parseInt(NivelesUtils.sistoleDiastole(controlTmp.getPresion_arterial())[0]));
            diastole.set(sdf.format(controlTmp.getFecha_hora_control().getTime())
                    ,Integer.parseInt(NivelesUtils.sistoleDiastole(controlTmp.getPresion_arterial())[1]));
        }
        if(!sistole.getData().isEmpty()){
            modelo.addSeries(sistole);
        }
        if(!diastole.getData().isEmpty()){
            modelo.addSeries(diastole);
        }
        
        
        
        modelo.setTitle("Presión Arterial");
        modelo.setLegendPosition("se");
        modelo.setStacked(true);
        modelo.setShowPointLabels(true);
        modelo.setZoom(true);
        
        DateAxis fechaAxis = new DateAxis("Fecha");
        fechaAxis.setTickFormat("%d-%m-%Y-%H:%M:%S");
        
        modelo.getAxes().put(AxisType.X, fechaAxis);
        modelo.getAxis(AxisType.Y).setLabel("Presión Arterial");
        this.chartPresion = modelo;
        
    }
}
    
    
    

