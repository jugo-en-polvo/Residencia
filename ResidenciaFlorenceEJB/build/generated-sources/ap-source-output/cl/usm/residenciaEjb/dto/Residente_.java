package cl.usm.residenciaEjb.dto;

import cl.usm.residenciaEjb.dto.Apoderado;
import cl.usm.residenciaEjb.dto.Prevision;
import cl.usm.residenciaEjb.dto.Tratamiento;
import java.util.Calendar;
import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2020-02-20T11:17:50")
@StaticMetamodel(Residente.class)
public class Residente_ { 

    public static volatile SingularAttribute<Residente, String> rut_residente;
    public static volatile SingularAttribute<Residente, String> estado;
    public static volatile SingularAttribute<Residente, Apoderado> apoderado;
    public static volatile SingularAttribute<Residente, String> nombre_residente;
    public static volatile ListAttribute<Residente, Tratamiento> tratamientos;
    public static volatile SingularAttribute<Residente, Calendar> fecha_nacimiento;
    public static volatile SingularAttribute<Residente, Calendar> fecha_ingreso;
    public static volatile SingularAttribute<Residente, String> sexo;
    public static volatile SingularAttribute<Residente, Prevision> prevision;

}