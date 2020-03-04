package cl.usm.residenciaEjb.dto;

import cl.usm.residenciaEjb.dto.Residente;
import java.util.Calendar;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2020-03-04T15:22:39")
@StaticMetamodel(Dieta.class)
public class Dieta_ { 

    public static volatile SingularAttribute<Dieta, Boolean> colacion_2;
    public static volatile SingularAttribute<Dieta, Boolean> colacion_1;
    public static volatile SingularAttribute<Dieta, Boolean> once;
    public static volatile SingularAttribute<Dieta, Boolean> almuerzo;
    public static volatile SingularAttribute<Dieta, String> observaciones;
    public static volatile SingularAttribute<Dieta, Boolean> desayuno;
    public static volatile SingularAttribute<Dieta, Boolean> cena;
    public static volatile SingularAttribute<Dieta, Calendar> fecha_dieta;
    public static volatile SingularAttribute<Dieta, Residente> residente;

}