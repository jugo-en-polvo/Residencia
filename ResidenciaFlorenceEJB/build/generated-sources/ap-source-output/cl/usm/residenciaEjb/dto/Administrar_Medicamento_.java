package cl.usm.residenciaEjb.dto;

import cl.usm.residenciaEjb.dto.Tratamiento;
import java.util.Calendar;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2020-03-03T21:13:42")
@StaticMetamodel(Administrar_Medicamento.class)
public class Administrar_Medicamento_ { 

    public static volatile SingularAttribute<Administrar_Medicamento, Boolean> estado;
    public static volatile SingularAttribute<Administrar_Medicamento, Calendar> fecha_administracion;
    public static volatile SingularAttribute<Administrar_Medicamento, String> observaciones;
    public static volatile SingularAttribute<Administrar_Medicamento, Tratamiento> tratamiento;

}