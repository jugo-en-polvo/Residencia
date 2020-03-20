package cl.usm.residenciaEjb.dto;

import cl.usm.residenciaEjb.dto.Apoderado;
import cl.usm.residenciaEjb.dto.Control_Medico;
import cl.usm.residenciaEjb.dto.PrevisionNombreTipo;
import cl.usm.residenciaEjb.dto.Tratamiento;
import java.util.Calendar;
import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2020-03-16T16:05:16")
@StaticMetamodel(Residente.class)
public class Residente_ { 

    public static volatile SingularAttribute<Residente, Calendar> fecha_egreso;
    public static volatile SingularAttribute<Residente, String> rut_residente;
    public static volatile SingularAttribute<Residente, String> regimen_alimentario;
    public static volatile SingularAttribute<Residente, String> nombre_residente;
    public static volatile SingularAttribute<Residente, Calendar> fecha_nacimiento;
    public static volatile SingularAttribute<Residente, String> alergias;
    public static volatile SingularAttribute<Residente, PrevisionNombreTipo> previsionNombreTipo;
    public static volatile SingularAttribute<Residente, Apoderado> apoderado;
    public static volatile ListAttribute<Residente, Control_Medico> controlesMedicos;
    public static volatile ListAttribute<Residente, Tratamiento> tratamientos;
    public static volatile SingularAttribute<Residente, String> observaciones;
    public static volatile SingularAttribute<Residente, Calendar> fecha_ingreso;
    public static volatile SingularAttribute<Residente, String> sexo;

}