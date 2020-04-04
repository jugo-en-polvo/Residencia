package cl.usm.residenciaEjb.dto;

import cl.usm.residenciaEjb.dto.Residente;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2020-04-03T23:16:40")
@StaticMetamodel(Diagnostico.class)
public class Diagnostico_ { 

    public static volatile SingularAttribute<Diagnostico, String> descripcion;
    public static volatile SingularAttribute<Diagnostico, String> enfermedad;
    public static volatile SingularAttribute<Diagnostico, Long> id_diagnostico;
    public static volatile SingularAttribute<Diagnostico, Residente> residente;

}