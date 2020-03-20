package cl.usm.residenciaEjb.dto;

import cl.usm.residenciaEjb.dto.Lugar;
import cl.usm.residenciaEjb.dto.Residente;
import java.util.Calendar;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2020-03-16T16:05:16")
@StaticMetamodel(Emergencia.class)
public class Emergencia_ { 

    public static volatile SingularAttribute<Emergencia, Lugar> lugar;
    public static volatile SingularAttribute<Emergencia, String> observaciones;
    public static volatile SingularAttribute<Emergencia, Calendar> fecha_emergencia;
    public static volatile SingularAttribute<Emergencia, Residente> residente;

}