package cl.usm.residenciaEjb.dto;

import cl.usm.residenciaEjb.dto.Residente;
import cl.usm.residenciaEjb.dto.Usuario;
import java.util.Calendar;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2020-04-03T23:16:40")
@StaticMetamodel(Control.class)
public class Control_ { 

    public static volatile SingularAttribute<Control, Calendar> fecha_hora_control;
    public static volatile SingularAttribute<Control, String> solucion_parenteral;
    public static volatile SingularAttribute<Control, String> pulso;
    public static volatile SingularAttribute<Control, String> cambio_posicion;
    public static volatile SingularAttribute<Control, String> hgt;
    public static volatile SingularAttribute<Control, String> presion_arterial;
    public static volatile SingularAttribute<Control, String> saturacion;
    public static volatile SingularAttribute<Control, String> observaciones;
    public static volatile SingularAttribute<Control, Usuario> usuario;
    public static volatile SingularAttribute<Control, String> suero;
    public static volatile SingularAttribute<Control, Residente> residente;

}