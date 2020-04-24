package cl.usm.residenciaEjb.dto;

import cl.usm.residenciaEjb.dto.Lugar;
import cl.usm.residenciaEjb.dto.Residente;
import java.util.Calendar;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2020-04-24T12:23:13")
@StaticMetamodel(Control_Medico.class)
public class Control_Medico_ { 

    public static volatile SingularAttribute<Control_Medico, Calendar> fecha_hora_control;
    public static volatile SingularAttribute<Control_Medico, String> estado_control;
    public static volatile SingularAttribute<Control_Medico, Lugar> lugar;
    public static volatile SingularAttribute<Control_Medico, String> observaciones;
    public static volatile SingularAttribute<Control_Medico, Residente> residente;

}