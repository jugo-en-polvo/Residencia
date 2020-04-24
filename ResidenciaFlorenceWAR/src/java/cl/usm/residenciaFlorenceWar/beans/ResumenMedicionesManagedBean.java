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
public class ResumenMedicionesManagedBean implements Serializable {

    @Inject
    private ControlDAOLocal controlDAO;

    private List<Control> controles;
    private String rutResidente;
    private LineChartModel chartPresion;
    private LineChartSeries medidasSeries;
     private LineChartSeries medidasSeries2;

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

    public void manejarFiltro() {
        if (!rutResidente.equals("falso")) {
            this.controles = controlDAO.findByRut(rutResidente);
            poblarChartPresion(controles);
            //poblarChartPresion(this.controles);

        } else {
            this.controles.clear();
        }

    }

    public void poblarChartPresion(List<Control> controls) {

        this.chartPresion = new LineChartModel();
        this.chartPresion.setTitle("Presión Arterial");
        this.chartPresion.setZoom(true);
        this.chartPresion.getAxis(AxisType.Y).setLabel("Presión Arterial");
        DateAxis fechaAxis = new DateAxis("Fecha");
        fechaAxis.setTickFormat("%d-%m-%Y-%H:%M:%S");
        this.chartPresion.getAxes().put(AxisType.X, fechaAxis);
        fechaAxis.setTickAngle(-50);

        this.medidasSeries = new LineChartSeries("sistole");
        this.medidasSeries2 = new LineChartSeries("distole");
        //LineChartSeries diastole = new LineChartSeries();

        //usistole.setFill(true);
        //diastole.setFill(true);
        //sistole.setLabel("Sístole");
        //diastole.setLabel("Diástole");
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

        controls.forEach((controlTmp) -> {
            this.medidasSeries.set(sdf.format(controlTmp.getFecha_hora_control().getTime()),
                    Integer.parseInt(NivelesUtils.sistoleDiastole(controlTmp.getPresion_arterial())[0]));
            this.medidasSeries2.set(sdf.format(controlTmp.getFecha_hora_control().getTime()),
                    Integer.parseInt(NivelesUtils.sistoleDiastole(controlTmp.getPresion_arterial())[1]));
        });

        this.chartPresion.addSeries(this.medidasSeries);
         this.chartPresion.addSeries(this.medidasSeries2);
        //this.chartPresion.addSeries(diastole);
        //this.chartPresion.setLegendPosition("se");
        //this.chartPresion.setStacked(true);
        //this.chartPresion.setShowPointLabels(true);

    }

    public String dis(Control c) {
        return NivelesUtils.sistoleDiastole(c.getPresion_arterial())[1];
    }
}
